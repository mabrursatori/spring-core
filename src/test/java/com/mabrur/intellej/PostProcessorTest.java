package com.mabrur.intellej;

import com.mabrur.intellej.postprocessor.Car;
import com.mabrur.intellej.postprocessor.PostProcessorConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PostProcessorTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(PostProcessorConfiguration.class);
    }

    @Test
    void name() {

        Car car = applicationContext.getBean(Car.class);

        System.out.println(car.getId());


    }
}
