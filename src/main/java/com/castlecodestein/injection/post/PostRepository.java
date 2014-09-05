package com.castlecodestein.injection.post;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableSet;

/**
 * Simple in-memory repository.
 * @author edhendil
 *
 */
@Component
public class PostRepository {

	private Set<Post> posts;

	public PostRepository() {
		this.posts = new HashSet<Post>();
	}
	
	public Post findById(long id) {
		for (Post post : posts) {
			if (post.getId() == id) {
				return post;
			}
		}
		return null;
	}
	
	public Post findByTitle(String title) {
		for (Post post : posts) {
			if (post.getTitle().equals(title)) {
				return post;
			}
		}
		return null;
	}
	
	public Collection<Post> findAll() {
		return ImmutableSet.copyOf(this.posts);
	}
	
	public void save(Post post) {
		this.posts.add(post);
	}
	
	public void delete(Post post) {
		this.posts.remove(post);
	}
	
	public void delete(long id) {
		for (Post post : posts) {
			if (post.getId() == id) {
				this.posts.remove(post);
				break;
			}
		}
	}
	
}
