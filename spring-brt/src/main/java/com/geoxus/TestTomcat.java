package com.geoxus;

import com.geoxus.servlets.IndexServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class TestTomcat {
	public static void main(String[] args) throws LifecycleException {
		Tomcat tomcat = new Tomcat();
	//	tomcat.setPort(8090);
		//tomcat.setBaseDir("d:\\b\\");
		//tomcat.setHostname("192.168.56.1");
		Context context = tomcat.addWebapp("/boot", "d:\\b\\");
		tomcat.start();
		tomcat.addServlet("/boot", "indexServlet", new IndexServlet());
		context.addServletMappingDecoded("/index.do", "indexServlet");
		tomcat.getServer().await();
	}
}
