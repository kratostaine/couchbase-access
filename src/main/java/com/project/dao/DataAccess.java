package com.project.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.query.N1qlQuery;
import com.project.bean.Contact;

@Repository
public class DataAccess {
	
	@Autowired
	private CouchbaseTemplate cbTemplate;
	
	private N1qlQuery query;
	
	public void getContacts(String id) {
		query = N1qlQuery.simple("select Contact.* from Contact where contactId="+"'"+id+"'");
		List<Contact> contacts= cbTemplate.findByN1QLProjection(query, Contact.class);
		System.out.println(Arrays.toString(contacts.toArray()));
	}

}
