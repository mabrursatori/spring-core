package com.mabrur.intellej;

import com.mabrur.intellej.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DuplicateConfiguration {

    //Ganti nama bean
    //@Bean(value = "fooFirst")
    @Primary
    @Bean
    public Foo foo1(){
        Foo foo = new Foo();
        return  foo;
    }

    @Bean
    public Foo foo2(){
        Foo foo = new Foo();
        return  foo;
    }
}
