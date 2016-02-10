package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.runner.RunWith;

import cucumber.runtime.arquillian.CukeSpace;
import cucumber.runtime.arquillian.api.Features;
import cucumber.runtime.arquillian.api.Glues;

@Glues({CukeSpaceStep.class})
@Features({"features/first.feature"})
@RunWith(CukeSpace.class)
public class CukeSpaceTestIT {

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test_test.war")
						 .addPackages(true, "com.example")
						 .addAsWebInfResource("beans.xml", "beans.xml")
						 .addAsResource("persistence.xml", "META-INF/persistence.xml")
						 .addAsLibraries(Maven.resolver().resolve("net.javacrumbs.json-unit:json-unit:1.9.0").withTransitivity().asFile());
	}
	
}
