package com.example.demo;


import com.example.demo.Entity.Item;
import com.example.demo.Entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbootcrudswaggerApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(SpringbootcrudswaggerApplication.class, args);
		Item myItem = new Item(1, "theItem", new User(2, "Bini", "Babu", 28, "binibabu22@gmail.com"));
	    //String serialized = new ObjectMapper().writeValueAsString(myItem);
	  //  System.out.println(serialized);
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addSerializer(Item.class, new ItemSerializer());
		mapper.registerModule(module);
		String serialized = mapper.writeValueAsString(myItem);
		System.out.println(serialized);
	}

}
