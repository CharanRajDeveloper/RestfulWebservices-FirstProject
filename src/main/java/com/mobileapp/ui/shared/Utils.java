package com.mobileapp.ui.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	public String generateStudentId() {
		return UUID.randomUUID().toString();
	}

}
