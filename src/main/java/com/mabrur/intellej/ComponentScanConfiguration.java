package com.mabrur.intellej;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.mabrur.intellej.configuration",
        "com.mabrur.intellej.service",
        "com.mabrur.intellej.repository"
})
public class ComponentScanConfiguration {
}
