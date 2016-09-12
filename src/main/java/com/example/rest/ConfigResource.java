package com.example.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		List<ApplicationConfiguration> appConfig = respository.findConfigurationItemsByApplication("app");
		Map<String, String> config = new HashMap<>();
		for(ApplicationConfiguration conf : appConfig) {
		    config.put(conf.getName(), conf.getValue());
		}
		Cache.store.setConfigMap(config);
	}
	
	@GET
	@Path("get")
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		return name1+name2;
	}
}
