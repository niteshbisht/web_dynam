package com.nitesh.serv.context.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ApplicationContextListener extends ContextLoaderListener {

	private static Log log = LogFactory
			.getLog(ApplicationContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		log.debug("My web app  Loaded.......");

		// You can get Servlet Context
		ServletContext servletContext = event.getServletContext();

		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);

		// You can get any bean, which is defined in spring xml file here.
		/*
		 * SomeClass someclass = (SomeClass)
		 * webApplicationContext.getBean("someclass");
		 * someclass.doSomethingDuringStartup();
		 */

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		log.debug("My web app  Destroyed.......");
	}

}