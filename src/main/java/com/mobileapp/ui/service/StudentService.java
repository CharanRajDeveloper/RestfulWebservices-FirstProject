package com.mobileapp.ui.service;

import com.mobileapp.ui.model.Student;
import com.mobileapp.ui.model.request.StudentDetailsRequest;

public interface StudentService {
	Student createStudentDetails(StudentDetailsRequest studentDetails);

}
