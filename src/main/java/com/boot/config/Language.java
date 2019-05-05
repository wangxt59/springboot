package com.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.stereotype.Component;


//@Component
@Configuration
@PropertySource(value = "classpath:i18n/messages_zh_CN.properties", factory = PropertySourceFactory.class)
@ConfigurationProperties
public class Language {

}
