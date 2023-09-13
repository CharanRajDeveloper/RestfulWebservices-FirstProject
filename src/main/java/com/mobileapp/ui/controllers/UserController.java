package com.mobileapp.ui.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobileapp.ui.model.Student;
import com.mobileapp.ui.model.request.StudentDetailsRequest;
import com.mobileapp.ui.model.request.UpdateStudentDetailsRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users") // http://localhost:8082/users
public class UserController {

	Map<String, Student> student;

	@GetMapping
	public String getUsers(@RequestParam(value = "page1", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "24") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user called with userId with page:" + page + " limit " + limit + " and sort value: " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Student> getUser(@PathVariable String userId) {
		// return "get user called with userId: "+userId;
		/*
		 * Student returnVal = new Student(); returnVal.setFirstName("Charan Raj");
		 * returnVal.setLastName("MS"); returnVal.setUserId("1"); Instead of hardcoded
		 * value ,fetching the data dynamically
		 */
		if (student.containsKey(userId)) {
			return new ResponseEntity<Student>(student.get(userId), HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Student> createUser(@Valid @RequestBody StudentDetailsRequest studentDetails) {
		Student returnVal = new Student();
		returnVal.setFirstName(studentDetails.getFirstName());
		returnVal.setLastName(studentDetails.getLastName());
		returnVal.setEmail(studentDetails.getEmail());
		returnVal.setPassword(studentDetails.getPassword());
		String userID = UUID.randomUUID().toString();
		if (student == null || student.size()== 0) {
			student = new HashMap<String,Student>();
			student.put(userID, returnVal);
		}
		returnVal.setUserId(userID);
		return new ResponseEntity<Student>(returnVal, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Student> updateUser(@PathVariable String userId,@Valid @RequestBody UpdateStudentDetailsRequest studentDetails) {
		Student storedStudentDetails=student.get(userId);
		if(storedStudentDetails != null) {
			storedStudentDetails.setFirstName(studentDetails.getFirstName());
			storedStudentDetails.setLastName(studentDetails.getLastName());
			student.put(userId, storedStudentDetails);
			return new ResponseEntity<Student>(storedStudentDetails, HttpStatus.OK);
		}else {
			return new ResponseEntity<Student>(storedStudentDetails, HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Student> deleteUser(@PathVariable String userId) {
		Student getUserIdDetails=student.get(userId);
		student.remove(userId);
		return new ResponseEntity<Student>(getUserIdDetails, HttpStatus.OK);
	}

}
