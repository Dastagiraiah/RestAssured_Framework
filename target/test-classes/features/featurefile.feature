Feature: Validate the Rahul APIs

@AddPlace @Regression
Scenario Outline: Verify Add place API 
	Given Add place paylod with "<Name>" "<Language>" "<Address>"
	When  User calls "AddPlaceAPI" with https "Post"
	Then Verify the response is success with status code 200 
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And Verify the place_id created map to "<Name>" using "GetPlaceAPI"
Examples:
	| Name   | Language | Address | 
	| Giri   | 	Telugu  | Kurnool |
#	| Ayesha |  Hindi		| Kadapa 	|

@DeletePlace @Regression
Scenario: Verify Delete place API
	Given Delete place payload
	When  User calls "DeletePalceAPI" with https "Post"
	Then Verify the response is success with status code 200 
	And "status" in response body is "OK"
	