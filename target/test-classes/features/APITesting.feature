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
    Given request to retrieve employee is prepared
    When get call is made for retrieving employee
    Then status code is 200
    And "employee.employee_id" is match with global employee id value
    And "employee" object data match with created employee information
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title | emp_status |
      | Roger         | MS              | Gold         | 1992-08-01   | Male       | Developer     | Employee   |

  @api
  Scenario: api test to partially update created employee
    Given request to update employee is prepared and body contains information for updating
      | emp_middle_name | emp_lastname | emp_job_title |
      | Van             | Mac          | UI Developer  |
    When patch call is made for updating employee
    Then status code is 201
    And expected "Message" is "Employee record updated successfully"

  @api
  Scenario: api test to get all jobs title
    Given request is prepared to get job titles
    When get call is made
    Then status code is 200
    And object body contains "Jobs"
    And content type is present

  @api
  Scenario: api test to get all employee' employment status
    Given request is prepared to get employment status
    When get call is prepared
    Then status code is 200
    And object body contains "Employeement Status"
    And response time is no exceed 300 ms

  @api
  Scenario: api test to update full employee information
    Given request is made to update full employee information
      | emp_firstname | emp_lastname | emp_middle_name | emp_gender | emp_birthday | emp_status | emp_job_title |
      | Adam          | Gurava       | RS              | M          | 1992-10-09   | employed   | QA Automation |
    When put call is prepared
    Then status code is 200
    And expected "Message" contains value "Employee record Updated"
    And updated fields match with provided information
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title | emp_status |
      | Adam          | RS              | Gurava       | 1992-10-09   | Male       | QA Automation | employed   |

@api
Scenario: api test to delete employee
  Given request is made to delete employee
  When delete call is prepared
  Then status code is 200
  And expected "message" contains value "Employee deleted"
  And "employee.employee_id" match with employee id in globals
  And response time is no exceed 250 ms


