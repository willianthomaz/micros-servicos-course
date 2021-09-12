package com.willian.thomaz.humanresourcespayroll.services;

import com.willian.thomaz.humanresourcespayroll.entities.Payment;
import com.willian.thomaz.humanresourcespayroll.entities.Worker;
import com.willian.thomaz.humanresourcespayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    // Feito com Rest Template
//    @Value("${hr-worker.host}")
//    private String workerHost;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("id", ""+workerId);
//        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(),worker.getDailyIncome(), days);
    }
}
