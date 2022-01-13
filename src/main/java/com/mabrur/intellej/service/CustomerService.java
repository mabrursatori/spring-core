package com.mabrur.intellej.service;

import com.mabrur.intellej.data.Bar;
import com.mabrur.intellej.repository.CustomerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Getter
    @Autowired
    private CustomerRepository customerRepository;

    @Getter
    @Autowired
    @Qualifier("bar")
    private Bar bar;

    @Getter
    @Autowired
    @Qualifier("bar1")
    private  Bar bar1;

}
