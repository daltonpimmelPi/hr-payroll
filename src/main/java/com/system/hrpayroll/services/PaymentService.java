package com.system.hrpayroll.services;

import com.system.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){

        //chamar no microserviço de worker

        //pagamento mockado
        return new Payment("Bob", 200.0, days);

    }

}
