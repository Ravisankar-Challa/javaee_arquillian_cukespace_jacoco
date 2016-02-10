package com.example.producers;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.example.util.Cache;

@ApplicationScoped
public class DBConfigurationProducer {
	
private static final Logger LOG = Logger.getLogger(DBConfigurationProducer.class.getSimpleName());
	
	public DBConfigurationProducer() {
		LOG.info("Inside DBConfigurationProducer Constructor");
	}
	
	@PostConstruct
	public void init() {
		LOG.info("Inside DBConfigurationProducer @PostConstruct");
	}
	
	@Produces
	@DBConfigValue
	public String getConfigValue(InjectionPoint ip) {
		String fieldName = ip.getAnnotated().getAnnotation(DBConfigValue.class).value();
		LOG.info(fieldName+" "+Cache.store.getConfigMap().get(fieldName));
		return Cache.store.getConfigMap().get(fieldName);
	}
	
	@PreDestroy
	public void destroy() {
		LOG.info("Inside DBConfigurationProducer @PreDestroy");
	}
	
}
