package com.mabrur.intellej.data;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class Database {

    @PostConstruct
    public void open(){
        log.info("Database opened");
    }

    @PreDestroy
    public void close(){
        log.info("Database closed");
    }

}
