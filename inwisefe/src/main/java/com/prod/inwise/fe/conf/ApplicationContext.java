package com.prod.inwise.fe.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import net.sf.ehcache.config.DiskStoreConfiguration;

@Configuration
@EnableCaching
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = { "com.prod.inwise.fe" })
@PropertySource("classpath:application.properties")
@EnableSpringConfigured
@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
public class ApplicationContext {

	@Value("${ehcache.disk.store.dir:java.io.tmpdir}")
	private String diskstoreDir;

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		messageSource.setBasename("messages");
		messageSource.setUseCodeAsDefaultMessage(true);

		return messageSource;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(destroyMethod = "shutdown")
	public net.sf.ehcache.CacheManager ehCacheManager() {
		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();

		DiskStoreConfiguration store = new DiskStoreConfiguration();
		store.setPath(diskstoreDir);
		config.addDiskStore(store);

		return net.sf.ehcache.CacheManager.newInstance(config);
	}

	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}

	@Bean
	public InstrumentationLoadTimeWeaver loadTimeWeaver() {
		return new InstrumentationLoadTimeWeaver();
	}
}