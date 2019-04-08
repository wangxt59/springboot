package com.boot.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="people")
@PropertySource("classpath:myconfig.properties")
public class PropertiesSourceFactory {
	
}
