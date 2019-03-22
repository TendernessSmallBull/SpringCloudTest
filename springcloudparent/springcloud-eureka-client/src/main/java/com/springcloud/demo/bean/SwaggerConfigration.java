package com.springcloud.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description: swagger2.properties配置文件对应bean类
 * 				若@ConfigurationProperties提示告警 则再pom.xml中
 * 				添加spring-boot-configuration-processor
 * 
 * @author zx
 * @date 2019年3月21日
 */
@Component
@PropertySource(value = "classpath:swagger2.properties")
@ConfigurationProperties(prefix = "swagger2")
public class SwaggerConfigration {
	/**
	 * 被swagger扫描的包（模糊匹配）
	 */
	private String scanPackage;
	/**
	 * 页面展示标题
	 */
	private String title;
	/**
	 * 页面展示描述信息
	 */
	private String description;
	private String url;
	/**
	 * 版本
	 */
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
