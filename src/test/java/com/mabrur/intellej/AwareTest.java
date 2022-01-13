package com.mabrur.intellej;

import com.mabrur.intellej.data.Bar;
import com.mabrur.intellej.interfacebean.ChocoConfiguration;
import com.mabrur.intellej.postprocessor.AuthService;
import com.mabrur.intellej.postprocessor.FooBeanFactoryPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class AwareTest {

    @Configuration
    @Import(value = {AuthService.class, FooBeanFactoryPostProcessor.class})
    public static class TestConfiguration{}

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
    }


    @Test
    void testAware() {

        AuthService authService = applicationContext.getBean(AuthService.class);

        Assertions.assertSame(applicationContext, authService.getApplicationContext());
        System.out.println(authService.getBeanName());
    }

    @Test
    void customizeBeanFactory() {

        Bar bar = applicationContext.getBean("bar", Bar.class);
        Assertions.assertNotNull(bar);
    }
}
