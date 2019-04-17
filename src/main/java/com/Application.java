package com;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.Severity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@SpringBootApplication(exclude={}) // Spring Boot项目的核心注解，主要目的是开启自动配置
//exclude={}用来排除不用的依赖
@Controller // 标明这是一个SpringMVC的Controller控制器
@ImportResource(value={})//引入xml配置文件
public class Application {
//public class Application extends WebMvcConfigurationSupport{
	
	//控制访问路径
//	setUseSuffixPatternMatch
//	当此参数设置为true的时候，那么/user.html，/user.aa，/user.*都能是正常访问的。
//	当此参数设置为false的时候，那么只能访问/user或者/user/( 这个前提是setUseTrailingSlashMatch 设置为true了)。
//	setUseTrailingSlashMatch 
//	当此参数设置为true的会后，那么地址/user，/user/或者/user? 都能正常访问。
//	当此参数设置为false的时候，那么就只能访问/user了。

//	@Override
//    protected void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer
//            .setUseSuffixPatternMatch(false)
//            .setUseTrailingSlashMatch(false);
//    }
	
	
	
    // 在main方法中启动一个应用，即：这个应用的入口
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}