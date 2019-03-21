package com.springcloud.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description: 若@ConfigurationProperties提示告警 则再pom.xml中
 * 				添加spring-boot-configuration-processor
 * 
 * @author zx
 * @date 2019年3月21日
 */
@Component
@PropertySource(value = "classpath:swagger2.properties")
@ConfigurationProperties(prefix = "swagger2")
public class SwaggerConfigration {

	private String scanPackage;
	private String title;
	private String description;
	private String url;
	private String version;
	
	public String getScanPackage() {
		return scanPackage;
	}

	public void setScanPackage(String scanPackage) {
		this.scanPackage = scanPackage;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return "SwaggerConfigration [scanPackage=" + scanPackage + ", title="
				+ title + ", description=" + description + ", url=" + url
				+ ", version=" + version + "]";
	}

}
