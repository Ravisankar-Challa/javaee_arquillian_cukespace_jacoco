package com.example.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Student implements Serializable {

	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE, generator="TableGenerator")
	//@TableGenerator(name="TableGenerator", allocationSize=1, initialValue=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_gen")
	//@SequenceGenerator(name="seq_gen", allocationSize=1, initialValue=1, sequenceName="MY_SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
 
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
   
}
