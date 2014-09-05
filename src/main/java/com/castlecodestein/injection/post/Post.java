package com.castlecodestein.injection.post;

import com.google.common.base.Objects;

/**
 * Blog post entity in its simplest form.
 * @author edhendil
 *
 */
public class Post {

	private long id;
	private String title;
	private String content;
	
	Post(long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public static Post of(long id, String title, String content) {
		return new Post(id, title, content);
	}

	/* Read */
	
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	/* Utility */
	
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Post)) {
			return false;
		}
		Post other = (Post) obj;
		return other.id == this.id;
	}
	
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
	
}
