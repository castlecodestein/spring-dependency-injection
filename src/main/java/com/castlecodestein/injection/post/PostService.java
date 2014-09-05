package com.castlecodestein.injection.post;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author Tomasz Krug
 *
 */
@Component
public class PostService {

	private final PostRepository repository;

	@Inject
	public PostService(PostRepository repository) {
		this.repository = repository;
	}
	
	public void createPost(Post post) {
		this.repository.save(post);
	}
	
	public void deletePost(long id) {
		this.repository.delete(id);
	}
	
}
