/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cas10.cas10.showcase;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author kasten
 */
@Configuration
@ComponentScan({"br.com.cas10.domain"})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    
    @Bean 
    public JndiObjectFactoryBean datasource() {
        JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
        jndi.setJndiName("jdbc/showcase");
        jndi.setResourceRef(true);
        return jndi;
    }
    
    @Bean 
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource datasource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("br.com.cas10.domain");
        emf.setPersistenceUnitName("showcase");
        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emf.setDataSource(datasource);
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("hibernate.dialect", PostgreSQL9Dialect.class.getName());
        props.put("hibernate.hbm2ddl.auto", "create-drop");
        emf.setJpaPropertyMap(props);
        return emf;
    }
    
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txm = new JpaTransactionManager();
        txm.setEntityManagerFactory(emf);
        return txm;
    }
}
