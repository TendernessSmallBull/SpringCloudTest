package com.springcloud.demo.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcloud.demo.bean.SwaggerConfigration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description: swagger2配置类 从swagger2.properties中获取配置信息，若没有则使用默认值
 * 
 * @author zx
 * @date 2019年3月21日
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 *   默认扫描包
	 */
	public static final String SWAGGER_DEFAULT_BASEPACKAGE = "com.springcloud.demo";
	/**
	 * 版本
	 */
	public static final String SWAGGER_DEFAULT_VERSION = "1.0";
	/**
	 *标题
	 */
	public static final String SWAGGER_DEFAULT_TITLE = "swagger接口说明文档";
	/**
	 * 描述信息
	 */
	public static final String SWAGGER_DEFAULT_DESCRIPTION = "Spring Boot中使用Swagger2构建RESTful APIs";
	/**
	 * url
	 */
	public static final String SWAGGER_DEFAULT_URL = "www.baidu.com";
	@Autowired
	private SwaggerConfigration swaggerConfigration;

	@Bean
	public Docket createRestApi() {
		String basePackage = swaggerConfigration.getScanPackage();
		if (StringUtils.isEmpty(basePackage)) {
			basePackage = SWAGGER_DEFAULT_BASEPACKAGE;
		}
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				// api接口包扫描路径
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				// 可以根据url路径设置哪些请求加入文档，忽略哪些请求
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		String version = swaggerConfigration.getVersion();
		String description = swaggerConfigration.getDescription();
		String title = swaggerConfigration.getTitle();
		String url = swaggerConfigration.getUrl();
		if(StringUtils.isEmpty(version)) {
			version = SWAGGER_DEFAULT_VERSION;
		}
		if(StringUtils.isEmpty(description)) {
			description = SWAGGER_DEFAULT_DESCRIPTION;
		}
		if(StringUtils.isEmpty(title)) {
			title = SWAGGER_DEFAULT_TITLE;
		}
		if(StringUtils.isEmpty(url)) {
			url = SWAGGER_DEFAULT_URL;
		}
		return new ApiInfoBuilder()
				// 设置文档的标题
				.title(title)
				// 设置文档的描述->1.Overview
				.description(description)
				// 设置文档的版本信息-> 1.1 Version information
				.version(version)
				// 设置文档的License信息->1.3 License
//				.termsOfServiceUrl(url)
				.build();
	}

}
