Feature: API workflow test

  Background: before each request generate token
    Given JWT is generated

  @api
  Scenario: api test to creating new employee
    Given request is prepared and body  contains "Roger", "Gold", "MS", "M", "1992-08-01", "employee", "Developer"
    When post call is made to create employee
    Then status code is 201
    And expected message is "Employee Created"
    And "Employee.employee_id" is stored in global variables

  @api
  Scenario: api test to retrieve created employee
    Given request is prepared
    When get call is made for retrieving employee
    Then status code is 200
    And "employee.employee_id" is match with global employee id value
    And "employee" object data match with created employee information
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title | emp_status |
      | Roger         | MS              | Gold         | 1992-08-01   | Male       | Developer     | Employee   |



