package com.example.rest;

import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.model.ApplicationConfiguration;
import com.example.service.ApplicationConfigurationRespository;
import com.example.util.Cache;
import com.example.producers.DBConfigValue;

@Path("/")
public class ConfigResource {

	@Inject
	@DBConfigValue(value="name1")
	private String name1;
	
	@Inject
	@DBConfigValue(value="name2")
	private String name2;
	
	@Inject 
	private ApplicationConfigurationRespository respository;
	
	@GET
	@Path("update")
	public void update() {
		respository.update();
		Cache.store.setConfigMap(respository
				.findConfigurationItemsByApplication("app")
				.stream()
				.collect(Collectors.toMap(ApplicationConfiguration::getName, 
						ApplicationConfiguration::getValue)));
	}
	
	@GET
	@Path("get")
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		return name1+name2;
	}
}
