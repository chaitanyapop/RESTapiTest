Feature: Rest api feature file

Scenario: Test the get request using json file
Given take the necessary information from json file
When send get request
Then validate the response with internal json file 

Scenario: Test the post request
Given fetch the data from the json file
When send post request using json file data
Then validate response

