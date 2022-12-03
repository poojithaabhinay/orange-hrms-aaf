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

#    @Api
#    Scenario:Create users
#      Given Prepare json payload to create user
#      |ColumnName|Value|
#      |name      |poo  |
#      |email     |poo@gmail.com|
#      |gender    |male         |
#      |status    |active       |
#      When I submit json post request
#      When  Response code 201
#
#    @Api
#    Scenario Outline:Create users
#      Given Prepare json payload to create user - name="<name>" and email="<email>" and gender="female" and status="active"
#      When I submit json post request
#      When  Response code 201
#      Examples:
#      |name|email|gender|status|
#      |rama|ram@gmail.com|male|active|
#      |rama1|ram1@gmail.com|male|active|
#      |rama2|ram2@gmail.com|male|active|
#
#    @Api
#    Scenario:Create users
#      Given Read data for "TC1" from "data.csv" csv file and Prepare json payload to create user
#
#      When I submit json post request
#      When  Response code 201