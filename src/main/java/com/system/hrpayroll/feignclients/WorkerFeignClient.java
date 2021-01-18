package com.system.hrpayroll.feignclients;

//chamando outro microservice, usando a estrutura do spring cloud

import com.system.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//namne = nome do projeto a ser chamado

//hardcode, url

//somente o nome do microservice, o eureka se encarrega de onde saber aonde esta rodando esse serviço
//não precisa da localização no serviço hr-worker

@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

    //mesma assinatura do metodo a ser chamado
    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable(value = "id") Long id);

}
