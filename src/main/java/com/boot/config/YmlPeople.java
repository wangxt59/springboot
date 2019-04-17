package com.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.boot.utils.YamlPropertySourceFactory;
 
@Component
@PropertySource(value = "classpath:myconfig.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix="system.user")
public class YmlPeople {
 
   
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
//		return "YmlPeople [name=" + name + ", password=" + password + ", age=" + age + "]";
//	}
}