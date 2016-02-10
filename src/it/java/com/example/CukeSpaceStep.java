package com.example;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.net.URL;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.test.api.ArquillianResource;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CukeSpaceStep {
	
	private Response response;

	@ArquillianResource
	URL baseURL;
	
	@Given("The call to external service should be:")
	public void test1() {
	
	}
	
	@When("^I make a GET call to \"(.*?)\" endpoint$")
	public final void I_make_a_GET_call_to_endpoint(final String endpointUrl) throws Throwable {
		response = ClientBuilder.newClient().target(baseURL+endpointUrl).request().get();
	}
	
	@Then("^response status code should be (\\d+)$")
	public final void response_status_code_should_be(final int statusCode) throws Throwable {
		assertThat(this.response.getStatus(), equalTo(statusCode));
	}

	@Then("^response content type should be \"(.*?)\"$")
	public final void response_content_type_should_be(final String contentType) throws Throwable {
		assertEquals(contentType, this.response.getMediaType().toString());
	}
	
	@Then("^response should be json:$")
	public final void response_should_be_json(final String jsonResponseString) throws Throwable {
		assertJsonEquals(jsonResponseString, response.readEntity(String.class));
	}
}
