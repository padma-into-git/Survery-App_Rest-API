package com.marketlogic.surveyapplication.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


public class AppConfig {
	
	  @Bean
	  public DataSource h2DataSource() {
			//Declare Bean for H2 Datasource
	      return new EmbeddedDatabaseBuilder()
	              .setType(EmbeddedDatabaseType.H2)
	              .build();
	  }
	  
	  @Bean
	  public LocalContainerEntityManagerFactoryBean factoryBean() {
		  //Declare Bean for Persistence Data
	      LocalContainerEntityManagerFactoryBean factory =
	              new LocalContainerEntityManagerFactoryBean();
	      factory.setDataSource(h2DataSource());
	      factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);

	      factory.setPersistenceXmlLocation("jpa/my-persistence.xml");
	      Properties properties = new Properties();
	      properties.setProperty("javax.persistence.schema-generation.database.action", "create");
	      factory.setJpaProperties(properties);
	      return factory;
	  }
}

