package com.love_calculator.dispatcher_config;

//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;


///when we want full access for dispatcher server...... so we use WebApplicationInitializer...
public class DispatcherS  // implements WebApplicationInitializer 
{

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO Auto-generated method stub
//		System.out.println("Hello This Dispatcher");
//
////		/// xml Base Configuration ....
////		XmlWebApplicationContext context = new XmlWebApplicationContext();
////		context.setConfigLocation("classpath:dispatcher.xml");
//
//		
//		// Annotation Base Configuration...
//		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//		context.register(ConfigurationClass.class);
//		
//		DispatcherServlet servlet = new DispatcherServlet(context);
//
//		ServletRegistration.Dynamic d = servletContext.addServlet("dispatcher_frontController", servlet);
//
//		d.setLoadOnStartup(1);
//		d.addMapping("/web/*");
//	}

}
