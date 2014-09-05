package com.castlecodestein.injection.configuration.profile;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.castlecodestein.injection.configuration.profile.SpringProfileConfiguration;
import com.castlecodestein.injection.configuration.qualifier.SpringQualifierConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringProfileConfiguration.class, loader = AnnotationConfigContextLoader.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class NoProfileConfigurationIT {

	@Inject
	private Integer injectedInteger;

	@Test
	public void luck() {
		assertEquals(0, injectedInteger.intValue());
	}

}
