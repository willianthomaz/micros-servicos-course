package com.willian.thomaz.humanresourcespayroll.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.willian.thomaz.humanresourcespayroll.entities.Payment;
import com.willian.thomaz.humanresourcespayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        Payment payment = service.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
        Payment payment = new Payment("Brann", 400.0, days);
        return ResponseEntity.ok(payment);
    }
}
