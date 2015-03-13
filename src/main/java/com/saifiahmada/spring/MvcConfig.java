package com.saifiahmada.spring;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;


@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	private int maxUploadSizeInMb = 1 * 1024 * 1024; // 1 MB
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/static/bootstrap/3.1.0/");
		registry.addResourceHandler("/jquery/**").addResourceLocations("classpath:/static/jquery/");
	    registry.addResourceHandler("/jqueryui/**").addResourceLocations("classpath:/static/jqueryui/");
	    registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
	    registry.addResourceHandler("/datepicker/**").addResourceLocations("classpath:/static/datepicker/");
	    registry.addResourceHandler("/qrcode/**").addResourceLocations("file:/home/saifi/GAZA/QRCODE/");
	    
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(maxUploadSizeInMb);
		return multipartResolver;
	}
	
}
