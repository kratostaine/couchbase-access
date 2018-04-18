package com.project.couchbaseApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.dao.DataAccess;

@SpringBootApplication(scanBasePackages = "com.project")
public class CouchbaseApp implements CommandLineRunner{
	
	@Autowired
	private DataAccess db;
	
	public static void main(String[] args) {
		SpringApplication.run(CouchbaseApp.class, args).close();
	}
	
	public void getContact(String id) {
		db.getContacts(id);
	}

	@Override
	public void run(String... args) throws Exception {
		getContact("2");
	}
}
