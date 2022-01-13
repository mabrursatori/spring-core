package com.mabrur.intellej.postprocessor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {Car.class, IdGenerator.class, PrefixGenerator.class})
public class PostProcessorConfiguration {
}
