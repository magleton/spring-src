package com.geoxus;

import com.geoxus.config.AppConfig;
import com.geoxus.entities.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		/*UsersService usersService = context.getBean(UsersService.class);
		System.out.println(usersService.insert());*/
		Person bean = context.getBean(Person.class);
		System.out.println(bean);
		context.close();
	}
}
