package com.project.bean;

import lombok.Getter;
import lombok.Setter;

public class Contact {
	
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name + ", email=" + email + "]";
	}
	@Getter @Setter private String contactId;
	@Getter @Setter private String name;
	@Getter @Setter private String email;

}
