package steps;

import org.junit.Assert;
import org.junit.Test;
import utils.DBQuery;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;


import static utils.DBUtility.*;

public class DBSteps {
	static BiConsumer<String,String> matcher = Assert::assertEquals;
	@Test
	public void findPersonsWhoHasSalaryBiggerThanAverage(){
		List<Map<String,String>>DBResult = getListOfMapsFromResultSet(DBQuery.PERSONS_WITH_SALARY_ABOVE_AVERAGE);
		DBResult.forEach(map -> map.forEach((k,v) -> System.out.println(k + "\t\t" + v)));
	}
	@Test
	public void findPersonWithHighestSalary(){
		String expectedHeader = "FirstName";
		String expectedEmployeeName = "jon";
		List<Map<String,String>>DBResult = getListOfMapsFromResultSet(DBQuery.PERSON_WITH_HIGHEST_SALARY);
		DBResult.forEach(map -> map.entrySet()
				.stream()
				.filter(k-> k.getKey().equals(expectedHeader))
				.forEach(k -> matcher.accept(k.getValue(), expectedEmployeeName)));
	}
}
