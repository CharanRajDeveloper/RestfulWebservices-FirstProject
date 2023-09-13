package com.mobileapp.ui.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapp.ui.model.Student;
import com.mobileapp.ui.model.request.StudentDetailsRequest;
import com.mobileapp.ui.service.StudentService;
import com.mobileapp.ui.shared.Utils;
@Service
public class StudentServiceImpl implements StudentService {

	Map<String, Student> student;
	Utils utils;
	StudentServiceImpl(){
		
	}
	@Autowired
	StudentServiceImpl(Utils utils){
		this.utils=utils;
	}
	@Override
	public Student createStudentDetails(StudentDetailsRequest studentDetails) {
		Student returnVal = new Student();
		returnVal.setFirstName(studentDetails.getFirstName());
		returnVal.setLastName(studentDetails.getLastName());
		returnVal.setEmail(studentDetails.getEmail());
		returnVal.setPassword(studentDetails.getPassword());
		String userID = utils.generateStudentId();
		if (student == null || student.size() == 0) {
			student = new HashMap<String, Student>();
			student.put(userID, returnVal);
		}
		returnVal.setUserId(userID);
		return returnVal;
	}

}
