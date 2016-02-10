package com.example.rest;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.example.model.Student;
import com.example.service.StudentRepository;

@Path("/")
public class StudentResource {
	
	@Inject
	private StudentRepository repository;
	
	@GET
	@Path("students")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> findAll() {
		return repository.findAll();
	}
	
	@GET
	@Path("student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Pattern(regexp="[0-9]*$", message="Invalid Id") 
	public Response findStudent(@PathParam("id") String id) {
		Student student = repository.findStudent(Long.valueOf(id));
		if(student!=null) {
			return Response.ok(student).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@POST
	@Path("student")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudent(@Context UriInfo uriInfo, Student student) {
		Student createdStudent = repository.addStudent(student);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(createdStudent.getId())).build("");
		//return Response.created(URI.create(uriInfo.getAbsolutePath().toString()+"/"+createdStudent.getId())).build();
		return Response.created(uri).build();
	}
	
}
