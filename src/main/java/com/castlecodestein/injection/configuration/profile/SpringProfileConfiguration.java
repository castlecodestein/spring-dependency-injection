package com.castlecodestein.injection.configuration.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Profiles are used to group alternate bean definitions together. "Default"
 * profile is a special one. It is active if no other is specified at
 * application startup.<br/>
 * 
 * Very useful when performing integration tests. This way you can define
 * another database ConnectionFactory pointing at an embedded H2DB instead of a
 * standalone one.
 * 
 * @author Tomasz Krug
 *
 */
@Configuration
public class SpringProfileConfiguration {

	@Bean
	@Profile("default")
	public Integer defaultNumber() {
		return 0;
	}

	@Bean
	@Profile("production")
	public Integer luckyNumber() {
		return 24;
	}

	@Bean
	@Profile("dev")
	public Integer badLuckNumber() {
		return 11;
	}

}
