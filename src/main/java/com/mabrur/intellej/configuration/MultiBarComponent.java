package com.mabrur.intellej.configuration;

import com.mabrur.intellej.data.Bar;
import lombok.Data;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
public class MultiBarComponent {

    List<Bar> bars;

    public  MultiBarComponent(ObjectProvider<Bar> objectProvider){
        bars = objectProvider.stream().collect(Collectors.toList());
    }
}
