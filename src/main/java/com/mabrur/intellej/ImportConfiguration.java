package com.mabrur.intellej;

import com.mabrur.intellej.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        BeanConfiguration.class,
        HelloWorldConfiguration.class
})
public class ImportConfiguration {
}
