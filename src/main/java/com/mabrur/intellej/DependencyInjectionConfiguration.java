package com.mabrur.intellej;

import com.mabrur.intellej.data.Bar;
import com.mabrur.intellej.data.Foo;
import com.mabrur.intellej.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
public class DependencyInjectionConfiguration {

    @Lazy //jika tidak dipanggil, maka tidak akan dibuat
    @Primary
    @Bean
    @DependsOn(value = {"bar"}) //bar dulu, baru foo
    public Foo foo(){
        Foo foo = new Foo();
        return foo;
    }

    @Bean
    public Bar bar(){
        Bar bar = new Bar();
        return  bar;
    }

    @Bean
    public Foo foo2(){
        Foo foo = new Foo();
        return foo;
    }



    @Bean
    public FooBar fooBar(@Qualifier("foo2") Foo foo, Bar bar){
        FooBar fooBar = new FooBar(foo, bar);
        return fooBar;
    }

}
