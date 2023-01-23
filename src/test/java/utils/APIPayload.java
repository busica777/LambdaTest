package utils;

import org.json.simple.JSONObject;

public class APIPayload {
	
	public static String adminLogIn() {
		JSONObject obj = new JSONObject();
		obj.put("email", "email@test.com");
		obj.put("password", "Test@123");
		return obj.toJSONString();
	}
	
	public static String createNewEmloyee(String firstName, String lastName,
										  String middleName, String gender,
										  String DOB, String empStatus, String jobTitle) {
		JSONObject obj = new JSONObject();
		obj.put("emp_firstname", firstName);
		obj.put("emp_lastname", lastName);
		obj.put("emp_middle_name", middleName);
		obj.put("emp_gender", gender);
		obj.put("emp_birthday", DOB);
		obj.put("emp_status", empStatus);
		obj.put("emp_job_title", jobTitle);
		return obj.toJSONString();
	}
	
}
