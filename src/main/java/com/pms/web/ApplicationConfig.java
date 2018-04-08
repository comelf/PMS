package com.pms.web;

import com.pms.Configure;
import com.pms.util.PhPass;
import com.pms.web.interceptor.AcademyInterceptor;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;
import java.util.Properties;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import com.mitchellbosecke.pebble.spring4.extension.SpringExtension;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.pms.web.repository")
@Import(value = {DKSecurityConfigurer.class})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.pms.web.controller", "com.pms.web.service", "com.pms.web.interceptor"})
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    Configure conf = Configure.getInstance();

    @Bean
    public Loader templateLoader(){
        return new ClasspathLoader();
    }

    @Bean
    public SpringExtension springExtension() {
        return new SpringExtension();
    }

    @Bean
    public PebbleEngine pebbleEngine() {
        return new PebbleEngine.Builder()
                .loader(this.templateLoader())
                .extension(springExtension())
                .build();
    }

    @Bean
    public ViewResolver viewResolver() {
        PebbleViewResolver viewResolver = new PebbleViewResolver();
        viewResolver.setPrefix("templates/");
        viewResolver.setSuffix(".html");
        viewResolver.setPebbleEngine(pebbleEngine());
        return viewResolver;
    }

    @Bean
    AcademyInterceptor academyInterceptor() {
        return new AcademyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(academyInterceptor()).addPathPatterns("/academy/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
//                .addVersionStrategy(new FixedStaticVersionStrategy(conf.build_version), "/**");
        registry.addResourceHandler("/**/*.js", "/**/*.css", "/**/*.png", "/**/*.jpg", "/**/*.woff*", "/**/*.ttf", "/**/*.hbs", "/**/*.json", "/**/*.svg", "/**/*.gif", "/**/*.pdf", "/**/*.md")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(60 * 60 * 24 * 30)
                .resourceChain(true);
//                .addResolver(versionResourceResolver);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10MB");
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.setFilter(new HiddenHttpMethodFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setInitialSize(10);
        ds.setMaxActive(50);
        ds.setMaxWait(10000);
        ds.setMinIdle(10);
        ds.setRemoveAbandoned(true);
        ds.setValidationQuery("select 1");
        ds.setTestWhileIdle(true);
        ds.setValidationQueryTimeout(1000);
        ds.setTimeBetweenEvictionRunsMillis(86400000);

        if (conf.db_driver.equals("com.mysql.jdbc.Driver")) {
            ds.setDriverClassName(conf.db_driver);
            ds.setUrl(conf.jdbc_url
                    + "/doublekick?useUnicode=true&charaterEncoding=utf8&zeroDateTimeBehavior=convertToNull");
            ds.setUsername(conf.db_username);
            ds.setPassword(conf.db_password);
        } else {
            ds.setDriverClassName("org.h2.Driver");
            ds.setUrl("jdbc:h2:file:./doublekick");
            ds.setUsername("sa");
            ds.setPassword("");
        }
        return ds;
    }

    @Bean
    JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(conf.jpa_show_sql);
        adapter.setGenerateDdl(conf.jpa_generate_ddl);

        if (conf.db_driver.equals("com.mysql.jdbc.Driver")) {
            adapter.setDatabase(Database.MYSQL);
            adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        } else {
            adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
            adapter.setDatabase(Database.H2);
        }
        return adapter;
    }

    @Bean(name = "entityManagerFactory")
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.pms.web.entity");

        Properties jpaProperties = new Properties();
        jpaProperties.put(AvailableSettings.SHOW_SQL, conf.jpa_show_sql);
        jpaProperties.put(AvailableSettings.HBM2DDL_AUTO, conf.jpa_ddl_auto);
        jpaProperties.put("hibernate.connection.characterEncoding", "utf8");
        jpaProperties.put("hibernate.connection.useUnicode", true);
        jpaProperties.put("hibernate.ejb.entitymanager_factory_name", "entityManagerFactory");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }

    @Bean
    public DatabaseInit databaseInit() {
        return new DatabaseInit();
    }

    @Bean
    public PhPass phPass() {
        return new PhPass(8);
    }
}
