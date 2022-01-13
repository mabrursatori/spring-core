package com.mabrur.intellej;

import com.mabrur.intellej.interfacebean.Choco;
import com.mabrur.intellej.interfacebean.ChocoConfiguration;
import com.mabrur.intellej.interfacebean.ChocoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InharetanceTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ChocoConfiguration.class);
    }

    @Test
    void testInharitance() {
        Choco choco = applicationContext.getBean(ChocoImpl.class);
        ChocoImpl choco1 = applicationContext.getBean(ChocoImpl.class);

        Assertions.assertSame(choco, choco1);
    }
}
