package com.mabrur.intellej.service;

import com.mabrur.intellej.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//@Component(value = "namaBean")
@Component
public class Service {

    @Getter
    private ProductRepository productRepository;

    @Autowired
    public Service(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public Service(ProductRepository productRepository, String name){
        this.productRepository = productRepository;
    }
}
