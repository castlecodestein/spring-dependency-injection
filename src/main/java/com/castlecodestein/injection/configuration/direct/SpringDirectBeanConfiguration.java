package com.castlecodestein.injection.configuration.direct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.castlecodestein.injection.post.PostApi;
import com.castlecodestein.injection.post.PostRepository;
import com.castlecodestein.injection.post.PostService;

/**
 * Configures the context by directly declaring beans. Each method is a single
 * bean and each bean is a singleton. Spring tries to find suitable components
 * to autowire required parameters when encountered.
 * 
 * @author Tomasz Krug
 *
 */
@Configuration
public class SpringDirectBeanConfiguration {

	@Bean
	public PostRepository postRepository() {
		return new PostRepository();
	}

	@Bean
	public PostService postService(PostRepository repository) {
		return new PostService(repository);
	}

	@Bean
	public PostApi postApi(PostService service, PostRepository repository) {
		return new PostApi(repository, service);
	}

}
