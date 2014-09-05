package com.castlecodestein.injection.post;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

/**
 * Class acting as a facade. Deals mostly with primitive types.
 * 
 * @author edhendil
 *
 */
@Component
public class PostApi {

	private final PostRepository repository;
	private final PostService service;
	
	@Inject
	public PostApi(PostRepository repository, PostService service) {
		super();
		this.repository = repository;
		this.service = service;
	}

	/* Read */
	
	public Collection<Post> findAllPosts() {
		return this.repository.findAll();
	}
	
	public Post findPost(long id) {
		return this.repository.findById(id);
	}
	
	/* Command */
	
	public void createPost(long id, String title, String content) {
		Post post = Post.of(id, title, content);
		this.service.createPost(post);
	}
	
	public void deletePost(long id) {
		this.service.deletePost(id);
	}
	
}
