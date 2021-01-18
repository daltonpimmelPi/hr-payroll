package com.system.hrpayroll.services;

import com.system.hrpayroll.entities.Payment;
import com.system.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.host}") //pegando dp application,properies
    private String workerHost;

    public Payment getPayment(Long workerId, int days){

        Map<String, String> uriVariables = new HashMap<>(); //map é uma interface, para intanciar tem que usar classe concreta
        uriVariables.put("id", workerId.toString());

        //chamar no microserviço de worker
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);

        //pagamento mockado
        //return new Payment("Bob", 200.0, days);

    }

}
