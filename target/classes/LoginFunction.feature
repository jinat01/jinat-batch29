@SmokeTest
Feature: Login function test

@TC_001
Scenario: As a Luma application user, I have to login with valid credential.
Given open any browser
When go to the browser with URL
And click signin button
And put email
And put password
And click second signin button
Then validate the login successful

  