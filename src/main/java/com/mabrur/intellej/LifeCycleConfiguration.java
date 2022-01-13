package com.mabrur.intellej;

import com.mabrur.intellej.data.Connection;
import com.mabrur.intellej.data.Database;
import com.mabrur.intellej.data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;

@Configuration
public class LifeCycleConfiguration {

    @Bean
    public Connection connection(){
        return new Connection();
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server server(){
        return new Server();
    }

    @Bean
    public Database database(){
        return new Database();
    }
}
