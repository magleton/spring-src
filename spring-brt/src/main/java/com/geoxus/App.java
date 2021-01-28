package com.geoxus;

import com.geoxus.config.AppConfig;
import com.geoxus.entities.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//OrdersService ordersService = context.getBean(OrdersService.class);
		//UsersService usersService = context.getBean(UsersService.class);
		//System.out.println(usersService.insert());
		//System.out.println(ordersService.insert());
		Person bean = context.getBean(Person.class);
		System.out.println(bean);
		/*Person bean = SpringContextUtils.getBean(Person.class);
		System.out.println(bean);*/
		/*X x = context.getBean(X.class);*/
		context.close();
	}
}
