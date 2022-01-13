package com.mabrur.intellej;

import com.mabrur.intellej.data.Connection;
import com.mabrur.intellej.data.Database;
import com.mabrur.intellej.data.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.crypto.Data;

public class LifeCycleTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
    }

    @AfterEach
    void tearDown(){
        applicationContext.close();
    }

    @Test
    void testIntializingbeanDisposable() {
        Connection connection = applicationContext.getBean(Connection.class);
    }

    @Test
    void testInitmethodDestroymethod() {
        Server server = applicationContext.getBean(Server.class);
    }

    @Test
    void testPostconstructPredestroy() {
        Database database = applicationContext.getBean(Database.class);
    }
}
