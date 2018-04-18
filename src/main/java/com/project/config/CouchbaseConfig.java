package com.project.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@PropertySources({
	@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)})
@EnableCouchbaseRepositories(basePackages={"com.project.config"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration{
	
	@Value("${couchbase.cluster.bucketName}")
	private String bucketName;
	
	@Value("${couchbase.cluster.ip}")
	private String ip;
	
	@Value("${couchbase.cluster.password:}")
	private String password;
	
	public CouchbaseConfig(){}
	
	public CouchbaseConfig(String bucketName, String password, String ip) {
		this.bucketName = bucketName;
		this.password = password;
		this.ip = ip;
	}
	
	@Override
	protected String getBucketName() {
		return bucketName;
	}

	@Override
	protected String getBucketPassword() {
		return "";
	}

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList(ip);
	}

}
