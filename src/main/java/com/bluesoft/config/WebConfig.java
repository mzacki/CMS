package com.***REMOVED***.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Matt on 21.05.2019 at 19:22.
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.***REMOVED***")
public class WebConfig {

}
