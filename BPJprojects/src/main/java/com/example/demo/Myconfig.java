package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Myconfig  {

	@Bean
    public	interceptor_autointercepter iu()
    {
		return new interceptor_autointercepter();
    }
	@Bean
	public interceptor_loginintercepter il()
	{
		return new interceptor_loginintercepter();
	}
	
    @Bean
	public WebMvcConfigurer conf()
	{
	  return new WebMvcConfigurer()
	  {
		public void addViewControllers(ViewControllerRegistry registry)
		{
			registry.addViewController("/").setViewName("index");
			registry.addViewController("/index").setViewName("index");
			registry.addViewController("/publish").setViewName("publish");
			
 		}
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(iu()).addPathPatterns("/","/index");
			registry.addInterceptor(il()).addPathPatterns("/publish");
		}
		
	  };
	}
}
