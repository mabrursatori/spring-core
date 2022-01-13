package com.mabrur.intellej;

import com.mabrur.intellej.eventlistener.LoginSuccessListener;
import com.mabrur.intellej.eventlistener.User;
import com.mabrur.intellej.eventlistener.UserService;
import com.mabrur.intellej.postprocessor.PostProcessorConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {
    
    @Configuration
    @Import(value = {UserService.class, LoginSuccessListener.class})
    public static class TestConfiguration{}
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
    }

    @Test
    void testEventListener() {
        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("mabrur", "satori");
        userService.login("mabrur", "ganteng");
        userService.login("mabrur", "mantap");
        Assertions.assertNotNull(userService);

    }
}
