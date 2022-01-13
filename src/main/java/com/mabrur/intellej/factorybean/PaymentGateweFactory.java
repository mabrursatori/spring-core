package com.mabrur.intellej.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateweFactory implements FactoryBean<PaymentGateway> {
    @Override
    public PaymentGateway getObject() throws Exception {
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.setUrl("www.malon.com");
        paymentGateway.setOwner("Mabrur");
        return paymentGateway;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGateway.class;
    }
}
