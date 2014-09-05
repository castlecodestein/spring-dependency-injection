package com.castlecodestein.injection.configuration.imported;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.castlecodestein.injection.post.PostApi;

/**
 * The imported class is resolved before any bean specified here is registered.
 * If imported beans are declared as public they can be directly referenced from
 * the parent configuration.
 * 
 * @author Tomasz Krug
 *
 */
@Configuration
@Import(value = { SpringSubmoduleConfiguration.class })
public class SpringTopAltConfiguration {

	@Inject
	private SpringSubmoduleConfiguration moduleConfiguration;

	@Bean
	public PostApi postApi() {
		return new PostApi(this.moduleConfiguration.postRepository(),
				this.moduleConfiguration.postService());
	}

}
