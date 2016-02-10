package com.example.util;

import com.example.model.ApplicationConfiguration;

public class ApplicationConfigurationBuilder {
private ApplicationConfiguration configuration = new ApplicationConfiguration();
	
	public static ApplicationConfigurationBuilder newConfiguration() {
		return new ApplicationConfigurationBuilder();
	}
	
	public ApplicationConfigurationBuilder application(String application) {
		this.configuration.setApplication(application);
		return this;
	}
	
	public ApplicationConfigurationBuilder name(String name) {
		this.configuration.setName(name);
		return this;
	}
	
	public ApplicationConfigurationBuilder value(String value) {
		this.configuration.setValue(value);
		return this;
	}
	
	public ApplicationConfiguration build() {
		return this.configuration;
	}
}
