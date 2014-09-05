package com.castlecodestein.injection.configuration.qualifier;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.castlecodestein.injection.configuration.qualifier.SpringQualifierConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringQualifierConfiguration.class, loader = AnnotationConfigContextLoader.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class QualifierConfigurationIT {

	@Inject
	@Qualifier("lucky")
	private Integer luckyNumber;
	
	@Inject
	@Qualifier("badLuckNumber")
	private Integer theOtherOne;
	
	@Test
	public void luck() {
		assertEquals(24, luckyNumber.intValue());
	}
	
	@Test
	public void noLuck() {
		assertEquals(11, theOtherOne.intValue());
	}
	
	
}
