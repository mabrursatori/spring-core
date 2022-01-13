package com.mabrur.intellej;

import com.mabrur.intellej.data.Bar;
import com.mabrur.intellej.data.Foo;
import com.mabrur.intellej.scope.DoubletoonScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopeConfiguration {

    @Bean
    @Scope("prototype")
    public Foo foo(){
        Foo foo = new Foo();
        log.info("Create new object");
        return foo;
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("doubleton", new DoubletoonScope());
        return customScopeConfigurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar(){
        Bar bar = new Bar();
        log.info("Create new object");
        return bar;
    }

}
