package com.mabrur.intellej.interfacebean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ChocoImpl.class})
public class ChocoConfiguration {
}
