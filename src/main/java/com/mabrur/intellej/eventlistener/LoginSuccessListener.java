package com.mabrur.intellej.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginSuccessListener implements ApplicationListener<LoginSuccesEvent> {
    @Override
    public void onApplicationEvent(LoginSuccesEvent event) {
       log.info("Success login user for {}", event.getUser());
    }
}
