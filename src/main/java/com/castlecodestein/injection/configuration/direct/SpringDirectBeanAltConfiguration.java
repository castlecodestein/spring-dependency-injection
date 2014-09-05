package com.castlecodestein.injection.configuration.direct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.castlecodestein.injection.post.PostApi;
import com.castlecodestein.injection.post.PostRepository;
import com.castlecodestein.injection.post.PostService;

/**
 * Configures the context by directly declaring beans. Each method is a single
 * bean and each bean is a singleton.
 * 
 * Instead of leaving the autowiring to the Spring one can directly link
 * dependencies.<br/>
 * Important: even though postRepository() method is invoked twice it returns
 * the same object due to Spring's internal magic.
 * 
 * @author Tomasz Krug
 *
 */
@Configuration
public class SpringDirectBeanAltConfiguration {

	@Bean
	public PostRepository postRepository() {
		return new PostRepository();
	}

	@Bean
	public PostService postService() {
		return new PostService(this.postRepository());
	}

	@Bean
	public PostApi postApi() {
		return new PostApi(this.postRepository(), this.postService());
	}

}
