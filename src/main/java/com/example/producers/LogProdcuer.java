package com.example.producers;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class LogProdcuer {

	private static final Logger LOG = Logger.getLogger(LogProdcuer.class.getSimpleName());
	private static final Map<String, Logger> loggersMap = new HashMap<>();
	
	public LogProdcuer() {
		LOG.info("Inside LogProducer Constructor");
	}
	
	@PostConstruct
	public void init() {
		LOG.info("Inside LogProducer @PostConstruct");
	}
	
	@Produces
	//@ApplicationScoped
	public Logger getLogger(InjectionPoint ip) {
		String className = ip.getMember().getDeclaringClass().getName();
		if(!loggersMap.containsKey(className)) {
			loggersMap.put(className, Logger.getLogger(ip.getMember().getDeclaringClass().getName()));
		}
		return loggersMap.get(className);
	}
	
	@PreDestroy
	public void destroy() {
		LOG.info("Inside LogProducer @PreDestroy");
	}
	
}
