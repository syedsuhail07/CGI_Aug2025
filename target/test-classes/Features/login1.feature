Feature: Verify the login fuctionality
 
Scenario: verify login success

Given Open the Browser
And Navigate to the url
Then Enter the valid username and password
And Click on Login
Then Verify login success


Scenario: verify login unsuccess

Given Open the Browser1
And Navigate to the url1
Then Enter the invalid username and password
And Click on Login1
Then Verify login unsuccess