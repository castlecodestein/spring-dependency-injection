package com.castlecodestein.injection.configuration.imported;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.castlecodestein.injection.post.PostRepository;
import com.castlecodestein.injection.post.PostService;

/**
 * Beans declared in this class can be imported to another configuration class.
 * @author Tomasz Krug
 *
 */
@Configuration
public class SpringSubmoduleConfiguration {

	@Bean
	public PostRepository postRepository() {
		return new PostRepository();
	}
	
	@Bean
	public PostService postService() {
		return new PostService(this.postRepository());
	}
	
}
