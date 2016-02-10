Feature: First Feature
  Scenario: Mock external API
    Given The call to external service should be:
    When I make a GET call to "api/students" endpoint
    Then response status code should be 200
    And response content type should be "application/json"
    And response should be json:
    """
    [
	   {
	      "id":"${json-unit.ignore}",
	      "firstName":"Ravi",
	      "lastName":"Sankar"
	   },
	   {
	      "id":"${json-unit.ignore}",
	      "firstName":"Shalini",
	      "lastName":"Muchala"
	   }
	]
    """

