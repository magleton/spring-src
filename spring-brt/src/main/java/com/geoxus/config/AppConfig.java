package com.geoxus.config;

import com.geoxus.entities.Person;
import org.springframework.context.annotation.Bean;

public class AppConfig {
	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("枫叶思源");
		person.setAge(100);
		return person;
	}
}
