package com.mabrur.intellej;

import com.mabrur.intellej.factorybean.FactoryConfiguration;
import com.mabrur.intellej.factorybean.PaymentGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(FactoryConfiguration.class);

    }

    @Test
    void testFactory() {
        PaymentGateway paymentGateway = applicationContext.getBean(PaymentGateway.class);

        Assertions.assertSame("Mabrur", paymentGateway.getOwner());
        Assertions.assertSame("www.malon.com", paymentGateway.getUrl());
    }
}
