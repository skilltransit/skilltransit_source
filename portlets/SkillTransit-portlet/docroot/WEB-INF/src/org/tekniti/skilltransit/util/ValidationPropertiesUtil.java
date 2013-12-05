package org.tekniti.skilltransit.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;


public class ValidationPropertiesUtil {
	
	public ValidationPropertiesUtil() {
		super();
	}
	Properties loaderProps=null;
	public Properties loadProps(){
		PropertiesFactoryBean loader = new PropertiesFactoryBean();
		loader.setLocation(new ClassPathResource("ValidationMessages.properties"));
		try {
			loader.afterPropertiesSet();
			 loaderProps = (Properties) loader.getObject();
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loaderProps;
	}
}
