package com.geoxus;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

public class SpringContextUtils {
	private SpringContextUtils() {
	}

	public static Object getBean(String name) {
		try {
			return Context.getLastApplicationContext().getBean(name);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static <T> T getBean(Class<T> clazz) {
		try {
			return Context.getLastApplicationContext().getBean(clazz);
		} catch (Exception e) {
			System.out.println(String.format("Bean获取出错 : %s / %s", clazz.getSimpleName(), e.getMessage()));
		}
		return null;
	}

	@Component
	private static class Context implements ApplicationContextAware {
		private static ApplicationContext applicationContext;

		public static ApplicationContext getLastApplicationContext() {
			return applicationContext;
		}

		@Override
		public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
			Context.applicationContext = applicationContext;
		}
	}
}
