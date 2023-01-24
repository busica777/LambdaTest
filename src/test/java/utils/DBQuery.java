package utils;

public interface DBQuery {
	String PERSONS_WITH_SALARY_ABOVE_AVERAGE =
			"SELECT EMP.FirstName, WORK.salary " +
			"FROM person EMP JOIN employee WORK \n " +
			"ON EMP.empId = WORK.empId\n " +
			"WHERE WORK.salary > (SELECT AVG(salary) FROM employee);";
	String PERSON_WITH_HIGHEST_SALARY =
			"SELECT EMP.FirstName, EMP.LastName, MAX(WORK.salary) " +
			"FROM person EMP JOIN employee WORK \n" +
			"ON EMP.empId = WORK.empId;";
}
