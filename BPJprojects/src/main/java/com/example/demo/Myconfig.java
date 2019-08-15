package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Myconfig {
     
	@Bean
	public WebMvcConfigurer conf()
	{
	  return new WebMvcConfigurer()
	  {
		public void addViewControllers(ViewControllerRegistry registry)
		{
			registry.addViewController("/").setViewName("index");
			registry.addViewController("/index").setViewName("index");
 		}
	  };
	}
}
