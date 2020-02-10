package br.com.project.config;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:twitter-words.properties")
@ConfigurationProperties
public class TwitterWordsProperties {

	@Resource
	private Environment env;

	private String getValue(String key) {
		return env.getProperty(key);
	}

	public String[] getTwitterHashs() {
		return this.getValue("hashes").split(",");
	}
}
