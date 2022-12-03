$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/live/hrms/features/GetGoRest.feature");
formatter.feature({
  "name": "Get Go Rest",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Regression"
    }
  ]
});
formatter.scenario({
  "name": "Create users",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression"
    },
    {
      "name": "@Api"
    },
    {
      "name": "@CreateUser"
    }
  ]
});
formatter.step({
  "name": "Prepare json payload to create user- name\u003d\"pooji101\" and email\u003d\"pooji101@gmail.com\" and gender\u003d\"female\" and status\u003d\"active\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.live.hrms.stepDef.ServiceStepDef.createUser(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I submit json post request",
  "keyword": "When "
});
formatter.match({
  "location": "com.live.hrms.stepDef.ServiceStepDef.i_submit_json_post_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Response code 201",
  "keyword": "When "
});
formatter.match({
  "location": "com.live.hrms.stepDef.ServiceStepDef.response_code(int)"
});
formatter.result({
  "status": "passed"
});
});