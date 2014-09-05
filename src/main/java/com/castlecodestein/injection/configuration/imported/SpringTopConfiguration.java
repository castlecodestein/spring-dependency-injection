package com.castlecodestein.injection.configuration.imported;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.castlecodestein.injection.post.PostApi;
import com.castlecodestein.injection.post.PostRepository;
import com.castlecodestein.injection.post.PostService;

/**
 * The imported class is resolved before any bean specified here is registered. Thanks to that postApi dependencies can be autowired. 
 * 
 * @author Tomasz Krug
 *
 */
@Configuration
@Import(value={SpringSubmoduleConfiguration.class})
public class SpringTopConfiguration {

	@Bean
	public PostApi postApi(PostService service, PostRepository repository) {
		return new PostApi(repository, service);
	}
	
}
