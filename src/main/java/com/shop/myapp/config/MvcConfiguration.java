package com.shop.myapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry re) {
		/* '/img/**'로 호출하는 자원은 '/static/img/' 폴더 아래에서 찾는다. */
		re.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
		/* '/video/**'로 호출하는 자원은 '/static/video/' 폴더 아래에서 찾는다. */
		re.addResourceHandler("/video/**").addResourceLocations("classpath:/static/video/");	
		/* '/css/**'로 호출하는 자원은 '/static/css/' 폴더 아래에서 찾는다. */
		re.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		/* '/js/**'로 호출하는 자원은 '/static/js/' 폴더 아래에서 찾는다. */
		re.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		/* '/css/**'로 호출하는 자원은 '/static/css/' 폴더 아래에서 찾는다. */
		re.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		/* '/common/**'로 호출하는 자원은 '/static/common/' 폴더 아래에서 찾는다. */
		re.addResourceHandler("/common/**").addResourceLocations("classpath:/templates/common/");
	
	}
}