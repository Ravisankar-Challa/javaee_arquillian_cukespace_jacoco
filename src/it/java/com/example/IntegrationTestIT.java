package com.example;

import java.net.URL;

import javax.ws.rs.client.ClientBuilder;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class IntegrationTestIT {

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test_test.war")
						 .addPackages(true, "com.example")
						 .addAsWebInfResource("beans.xml", "beans.xml")
						 .addAsResource("persistence.xml", "META-INF/persistence.xml");
	}
	
	@ArquillianResource
	URL baseURL;
	
	@Test
	public void test() {
		System.out.println(ClientBuilder.newClient().target(baseURL+"api/students").request().get(String.class));
	}
	
}
