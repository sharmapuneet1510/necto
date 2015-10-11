package com.v2tech.necto.plusconnect.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@PropertySource("classpath:error.properties")
public class Error
	{
		/*		@Bean
				public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException
					{
						return new PropertySourcesPlaceholderConfigurer();
					}
		*/

		@Autowired
		private PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer;
	}
