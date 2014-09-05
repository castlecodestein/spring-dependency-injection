package com.castlecodestein.injection.configuration.direct;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.castlecodestein.injection.configuration.direct.SpringDirectBeanAltConfiguration;
import com.castlecodestein.injection.configuration.scan.SpringBeanScanConfiguration;
import com.castlecodestein.injection.post.Post;
import com.castlecodestein.injection.post.PostApi;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDirectBeanAltConfiguration.class, loader = AnnotationConfigContextLoader.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DirectAltConfigurationIT {

	@Inject
	private PostApi api;
	
	@Test
	public void repositorySave() {
		api.createPost(1l, "Test title", "Test content");
		assertEquals(1, api.findAllPosts().size());
	}
	
	@Test
	public void findById() {
		api.createPost(1l, "Test title", "Test content");
		Post post = api.findPost(1l);
		assertNotNull(post);
	}
	
	@Test
	public void delete() {
		api.createPost(1l, "Test title", "Test content");
		api.deletePost(1l);
		assertEquals(0, api.findAllPosts().size());
	}
	
}
