package com.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.stereotype.Component;

@Component
//@Configuration
@PropertySource(value = "classpath:myconfig.properties",factory=PropertySourceFactory.class)
//@ConfigurationProperties(prefix="system.user")
@ConfigurationProperties(prefix="people")
public class PropertiesPeople {

    private String name;
    private String password;
    private int age;
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	@Override
//	public String toString() {
//		return "PropertiesPeople [name=" + name + ", password=" + password + ", age=" + age + "]";
//	}
	
}
