@Regression
  Feature: Get Go Rest
    @Api
    Scenario:Get user
      Given I submit json get request to get employee "1097"
      When  Response code 200
      Then  validate name "Minakshi Chopra"
      Then  validate email "chopra_minakshi@marvin.biz"
      Then  validate gender "male"
      Then  validate status "active"

    @Api @CreateUser
    Scenario:Create users
      Given Prepare json payload to create user- name="pooji102" and email="pooji102@gmail.com" and gender="female" and status="active"
      When I submit json post request
      When  Response code 201
      Then  validate name "pooji102"

    @Api @CreateUserWithParameter
    Scenario:Create users
      Given Prepare json payload to create user
      |ColumnName|Value|
      |name      |poojitha103  |
      |email     |poojitha103@gmail.com|
      |gender    |male         |
      |status    |active       |
      When I submit json post request
      When  Response code 201
      Then  validate name "poojitha103"


    @Api @CreateUserWithScenarioOutline
    Scenario Outline:Create users
      Given Prepare json payload to create user - name  as "<name>" and email as "<email>" and gender as "<gender>" and status as "<status>"
      When I submit json post request
      When  Response code 201
      Then  validate name "<name>"
      Examples:
      |name|email|gender|status|
      |poojitha107|poojitha107@gmail.com|male|active|
      |poojitha108|poojitha108@gmail.com|male|active|
      |poojitha109|poojitha109@gmail.com|male|active|

    @Api @CreateUserWithCsvData
    Scenario Outline: Create users
      Given Read data for "<Tcid>" from "CreateUser" csv file and Prepare json payload to create user

      When I submit json post request
      When  Response code 201
      Examples:
        |Tcid|
        |TC101|
        |TC102|
        |TC103|