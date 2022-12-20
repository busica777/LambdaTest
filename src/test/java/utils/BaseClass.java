package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.*;

import static steps.PageInitializer.initializePages;

public class BaseClass {
	private static final Map<String, Supplier<WebDriver>> DRIVER_MAP = new HashMap<>();
	private static final Supplier<WebDriver> CHROME_DRIVER = ()
			-> {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	};
	private static final Supplier<WebDriver> FIREFOX_DRIVER = ()
			-> {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	};
	private static final Supplier<WebDriver> EDGE_DRIVER = ()
			-> {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	};
	public static WebDriver driver;
	public static Supplier<WebDriver> driverFactory = ()
			-> {
		DRIVER_MAP.put("chrome", CHROME_DRIVER);
		DRIVER_MAP.put("firefox", FIREFOX_DRIVER);
		DRIVER_MAP.put("edge", EDGE_DRIVER);
		ConfigReader.loadProperty(Constants.CONFIGURATION_FILE_PATH);
		try {
			driver = DRIVER_MAP.get(ConfigReader.getPropertyValue.apply("browser")).get();
		} catch (RuntimeException r) {
			throw new RuntimeException("NO SUCH BROWSER IN DIRECTORY");
		}
		return driver;
	};
	
	public static Consumer<WebDriver> launchApplication = (driver)
			-> {
		driver.get(ConfigReader.getPropertyValue.apply("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		initializePages();
		
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("My test case");
		Log.info("Test in process");
		Log.warning("My test case might be failed");
	};
	public static BiConsumer<WebElement, String> sendText = (element, text)
			-> {
		element.clear();
		element.sendKeys(text);
	};
	public static Supplier<WebDriverWait> getWait = ()
			-> new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
	public static Consumer<WebElement> click = (element)
			-> {
		wait_Until_Element_Be_Clickable(element);
		element.click();
	};
	public static BiConsumer<String, String> assertThatText = (expected, actual)
			-> Assert.assertEquals("text does NOT match", expected, actual);
	
	public static Predicate<WebElement> assertElementIsVisible = WebElement::isDisplayed;
	
	public static void quitBrowser() {
		Log.info("My test case is about to complete");
		Log.endTestCase("This is my login test again");
		driver.quit();
	}
	
	public static void wait_Until_Element_Be_Clickable(WebElement element) {
		getWait.get().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static byte[] takeScreenshot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(sourceFile,
					new File(Constants.SCREENSHOT_FILEPATH + fileName + " " +
							getTimeStamp("yyyy-MM-dd-HH-mm-ss,SSS") + ".png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return picBytes;
	}
	
	public static String getTimeStamp(String pattern) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Supplier<JavascriptExecutor> getJavaScriptExecutor = ()
			-> (JavascriptExecutor) (driver);
	
	public static Consumer<WebElement> scrollIntoView = (element)
			-> getJavaScriptExecutor.get().executeScript("arguments[0].scrollIntoView();", element);
	
	public static Supplier<Actions> getActions = ()
			-> new Actions(driver);
	public static Consumer<WebElement> moveCursorToElement = (element)
			-> getActions.get().moveToElement(element).perform();
	
	public static Select dropDown(WebElement element) {
		return new Select(element);
	}
	
	public static BiConsumer<WebElement, Integer> dropDownselectByIndex = (element, index)
			-> dropDown(element).selectByIndex(index);
	
	public static Consumer<WebElement>visibilityOfElementLocated = (element)
			-> getWait.get().until
					(ExpectedConditions.visibilityOf(element));
	
}


