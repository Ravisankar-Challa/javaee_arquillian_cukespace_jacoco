package com.example.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ApplicationConfiguration
 *
 */

@Entity
public class ApplicationConfiguration implements Serializable {

	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE, generator="TableGenerator1")
	//@TableGenerator(name="TableGenerator1", allocationSize=1, initialValue=1, table="Hello")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_gen1")
	@SequenceGenerator(name="seq_gen1", allocationSize=1, initialValue=1, sequenceName="MY_SEQ_1")
	private Long id;
	private String application;
	private String name;
	private String value;
  
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getApplication() {
		return this.application;
	}

	public void setApplication(String application) {
		this.application = application;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
   
}
