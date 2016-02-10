package com.example.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.model.ApplicationConfiguration;

@ApplicationScoped
@Transactional
public class ApplicationConfigurationRespository {

	@PersistenceContext(unitName="test_pu")
	private EntityManager em;
	
	public ApplicationConfiguration addConfigurationItem(ApplicationConfiguration configuration) {
		em.persist(configuration);
		return configuration;
	}
	
	public void removeConfigurationItem(Long id) {
		em.remove(em.find(ApplicationConfiguration.class, id));
	}
	
	public List<ApplicationConfiguration> findAll() {
		return em.createQuery("SELECT a FROM ApplicationConfiguration a", ApplicationConfiguration.class).getResultList();
	}
	
	public List<ApplicationConfiguration> findConfigurationItemsByApplication(String application) {
		return em.createQuery("SELECT a FROM ApplicationConfiguration a WHERE a.application = :application", ApplicationConfiguration.class)
				 .setParameter("application", application)
				 .getResultList();
	}
	
	public void update() {
		ApplicationConfiguration config = em.find(ApplicationConfiguration.class, 2L);
		config.setValue("value10");
		//ApplicationConfiguration config1 = em.find(ApplicationConfiguration.class, 2L);
		//config1.setValue("value11");
	}
}
