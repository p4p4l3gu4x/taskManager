package com.hudson.task.manager.configuration;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.hudson.task.manager.repository.TaskManagerRepository;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.hudson.task.manager.repository")
public class MongoConfig {

	@Autowired
	TaskManagerRepository taskManagerRepository;

	@Bean
	public MongoClient mongoClient() throws UnknownHostException{
		return new MongoClient("localhost");
	}
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongoClient(), "taskManager");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}
}
