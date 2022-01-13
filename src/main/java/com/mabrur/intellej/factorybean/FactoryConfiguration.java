package com.mabrur.intellej.factorybean;

import org.springframework.context.annotation.Import;

@Import(value = {PaymentGateweFactory.class})
public class FactoryConfiguration {
}
