package com.prod.inwise.fe.conf;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.prod.inwise.fe.controller" })
public class WebAppContext extends WebMvcConfigurerAdapter {

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(0);

		return viewResolver;
	}

	@Bean
	public ViewResolver reportViewResolver() {
		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();

		viewResolver.setBasenames(new String[] { "reports" });
		viewResolver.setOrder(1);

		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).favorParameter(false).ignoreAcceptHeader(true).useJaf(false)
				.defaultContentType(MediaType.APPLICATION_XHTML_XML).mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(getStringHttpMessageConverter());

		super.configureMessageConverters(converters);
	}

	private StringHttpMessageConverter getStringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));

		return converter;

	}
}
