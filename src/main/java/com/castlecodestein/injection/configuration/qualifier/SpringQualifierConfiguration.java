package com.castlecodestein.injection.configuration.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Most of the time autowiring by the class is sufficient. However if you happen
 * to require two different implementations at the same time you can tag them using
 * the @Qualifier annotation.
 * 
 * @author Tomasz Krug
 *
 */
@Configuration
public class SpringQualifierConfiguration {

	@Bean
	@Qualifier("lucky")
	public Integer luckyNumber() {
		return 24;
	}

	@Bean
	@Qualifier("badLuck")
	public Integer badLuckNumber() {
		return 11;
	}

}
