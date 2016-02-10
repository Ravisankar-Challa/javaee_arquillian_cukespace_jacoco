package com.example.service;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.model.Student;

@ApplicationScoped
@Transactional
public class StudentRepository {
	
	@Inject
	private Logger LOG;
	
	@PersistenceContext(unitName="test_pu")
	private EntityManager em;
	
	public StudentRepository() {
		System.out.println("Inside StudentRepository Constructor ");
	}
	
	@PostConstruct
	public void init() {
		LOG.info("Inside StudentRepository @PostConstruct"+em);
	}
	
	public List<Student> findAll() {
		return em.createQuery("SELECT s from Student s", Student.class).getResultList();
	}
	
	public Student findStudent(Long id) {
		return em.find(Student.class, id);
	}

	public Student addStudent(Student student) {
		em.persist(student);
		return student;
	}
	
	@PreDestroy
	public void destroy() {
		LOG.info("Inside StudentRepository @PreDestroy");
	}

}
