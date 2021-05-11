package com.geoxus.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class X {
	@Autowired
	private Y y;

	public X() {
		System.out.println("X类的构造方法");
	}
}
