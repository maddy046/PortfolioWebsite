package com.validation;

import javax.servlet.http.Part;

public class Validation {

	private String result;
	public String validateData(String name, String email, String message) {
		if (name!= null && email!= null && message!=null) {
			if (name.length()<2 || name.length()>25) {
				result = "invalid name";
			}else if (!email.endsWith(".com")) {
				result = "invalid email";
			}else if (message.equals("") || message.length()>100) {
				result = "invalid message";
			}
			else {
				result = "valid";
			}
		}else {
			result = "fields should be empty";
		}

		return result;
	}
	public String validateImage(Part part) {
		long size = part.getSize();	//byte
		String type = part.getContentType().toLowerCase(); //type
		
		System.out.println(size);
		System.out.println(type);
		
		if (size>1048576) {
			result="file size exceeded";
		}else if (!(type.endsWith("jpeg") || type.endsWith("jpg"))) {
			result="Invalid Format";
		}
		else {
			result="valid";
		}
		return result;
	}

}
