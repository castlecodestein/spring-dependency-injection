package com.castlecodestein.injection.configuration.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

/**
 * Declaring all of the bean directly in the configuration class would be a bit
 * troublesome. Instead of providing definitions manually you can tell Spring to
 * search for components on the classpath.<br/>
 * 
 * Here all classes in package com.castlecodestein.injection.post are examined
 * and if annotated by @Component they are automatically added to the context.<br/>
 * 
 * Not only @Component classes are registered but @Configuration classes are
 * resolved as well. However I prefer to specify configuration classes
 * dependencies/imports myself to keep track of them. For that I'm using the excludeFilters parameter.
 * 
 * @author Tomasz Krug
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.castlecodestein.injection.post" }, excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Configuration.class))
public class SpringBeanScanConfiguration {

}
