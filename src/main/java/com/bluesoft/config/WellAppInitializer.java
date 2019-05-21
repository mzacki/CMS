package com.***REMOVED***.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Matt on 21.05.2019 at 20:01.
 */

@Slf4j
public class WellAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        log.info("onStartup");

        // create Spring Application Context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        // create Dispatcher Servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // register and configure Dispatcher Servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
                dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
