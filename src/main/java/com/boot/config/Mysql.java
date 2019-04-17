package com.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.boot.utils.YamlPropertySourceFactory;

@Component
@PropertySource(value = "classpath:mysql.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix="mysql.server.saas")
public class Mysql {
	   
	    private String url;
	    private String username;
	    private String password;
		private String driverClassName;
	    private int initialSize;
	    private int minIdle;
	    private int maxActive;
	    public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getDriverClassName() {
			return driverClassName;
		}
		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}
		public int getInitialSize() {
			return initialSize;
		}
		public void setInitialSize(int initialSize) {
			this.initialSize = initialSize;
		}
		public int getMinIdle() {
			return minIdle;
		}
		public void setMinIdle(int minIdle) {
			this.minIdle = minIdle;
		}
		public int getMaxActive() {
			return maxActive;
		}
		public void setMaxActive(int maxActive) {
			this.maxActive = maxActive;
		}
		@Override
		public String toString() {
			return "Mysql [url=" + url + ", username=" + username + ", password=" + password + ", driverClassName="
					+ driverClassName + ", initialSize=" + initialSize + ", minIdle=" + minIdle + ", maxActive="
					+ maxActive + "]";
		}
	    
}
