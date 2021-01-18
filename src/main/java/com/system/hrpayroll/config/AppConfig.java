package com.system.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //bean retorna um restTemplate, registra um singlete desse objeto, e fica disponivel para injetar em outros components
    //cria component atraves de uma chamada de metodo
    //padrão de projeto singleton, instancia unica

    @Bean
    public RestTemplate getRestTemplate(){
       return new RestTemplate();
    }


}
