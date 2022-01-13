package com.mabrur.intellej.configuration;

import com.mabrur.intellej.data.Bar;
import com.mabrur.intellej.data.Foo;
import com.mabrur.intellej.data.FooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public Bar bar(){
        return  new Bar();
    }

    @Bean
    public  Bar bar1(){
        return  new Bar();
    }

    @Bean
    public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar){
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }
}
