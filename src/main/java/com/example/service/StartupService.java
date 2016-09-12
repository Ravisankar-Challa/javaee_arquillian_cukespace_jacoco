package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.Persistence;

import com.example.model.ApplicationConfiguration;
import com.example.model.Student;
import com.example.util.ApplicationConfigurationBuilder;
import com.example.util.Cache;
import com.example.util.StudentBuilder;

@Startup
@Singleton(name="Student Startup Service", description="Creates Some Students During Startup")
public class StartupService {

	@Inject
	private StudentRepository respository;
	
	@Inject
	private ApplicationConfigurationRespository configRespository;
	
	@PostConstruct
	public void init() {
		
		respository.addStudent(StudentBuilder.newStudent()
											 .firstName("Ravi")
											 .lastName("Sankar")
											 .build());
		
		respository.addStudent(StudentBuilder.newStudent()
											 .firstName("Shalini")
											 .lastName("Muchala")
											 .build());
		
		configRespository.addConfigurationItem(
				ApplicationConfigurationBuilder.newConfiguration()
											   .application("app")
											   .name("name1")
											   .value("value1")
											   .build());
		
		configRespository.addConfigurationItem(
				ApplicationConfigurationBuilder.newConfiguration()
											   .application("app")
											   .name("name2")
											   .value("value2")
											   .build());
		
		List<ApplicationConfiguration> appConfig = configRespository.findConfigurationItemsByApplication("app");
        Map<String, String> config = new HashMap<>();
        for(ApplicationConfiguration conf : appConfig) {
            config.put(conf.getName(), conf.getValue());
        }
        Cache.store.setConfigMap(config);
	}
	
}
