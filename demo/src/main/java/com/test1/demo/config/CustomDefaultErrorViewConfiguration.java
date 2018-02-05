package com.test1.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class CustomDefaultErrorViewConfiguration {
	
	private final static String DEFAULT_ERROR_VIEW="error";
	
	@Autowired
	private MyErrorViewResolver myerrorViewResolver;

  @Bean
  public ModelAndView error() throws Exception {
	  ModelAndView view=myerrorViewResolver.resolveErrorView(null, null, null);
      view.setViewName(DEFAULT_ERROR_VIEW);
	  return  view;
  }

}