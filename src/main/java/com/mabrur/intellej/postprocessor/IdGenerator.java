package com.mabrur.intellej.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class IdGenerator implements BeanPostProcessor, Ordered {

@Override
public  Object postProcessAfterInitialization(Object bean, String beanName){
   log.info("Id Generator Processor for Bean {}", beanName);
   if(bean instanceof  IdAware){
       log.info("set Id Generator for Bean {}", beanName);
       IdAware idAware = (IdAware) bean;
       idAware.setId(UUID.randomUUID().toString());
   }

   return bean;
}

    @Override
    public int getOrder() {
        return 1;
    }
}
