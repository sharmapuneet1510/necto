package com.v2tech.necto.plusconnect.configuration;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages =
	{ "com.v2tech.nacto.plusconnect" })
@EnableNeo4jRepositories(basePackages = "com.v2tech.nacto.plusconnect")
@PropertySource("classpath:application.properties")
public class ServerConfiguration extends Neo4jConfiguration
	{
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException
			{
				PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
				Resource resource = new ClassPathResource("application.properties");
				Properties properties = new Properties();
				properties.load(resource.getInputStream());
				Set<Object> keySet = properties.keySet();
				if (keySet != null)
					{
						Iterator<Object> iterator = keySet.iterator();
						while (iterator.hasNext())
							{
								String key = (String) iterator.next();
								String value = (String) properties.get(key);
								ConfigProperties.setPropertyValue(key.trim().toLowerCase(), value.trim());
							}
					}
				return propertySourcesPlaceholderConfigurer;
			}

		@Value("${neo4jServerUrl}")
		private String neo4jServerUrl;

		@Value("${neo4jUserName}")
		private String neo4jUserName;

		@Value("${neo4jPassword}")
		private String neo4jPassword;

		@Override
		public Neo4jServer neo4jServer()
			{
				return new RemoteServer(neo4jServerUrl, neo4jUserName, neo4jPassword);
			}

		@Override
		public SessionFactory getSessionFactory()
			{
				return new SessionFactory("com.v2tech.nacto.plusconnect.entity.bo.neo4j");
			}
	}
