package com.myapp.controller;

import com.myapp.service.KafkaProducerService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KafkaController {

        @Autowired
        KafkaProducerService kafkaProducerService;

        @GetMapping(value = "/producer")
        public String sendMessage(@RequestParam("message") String message)
        {
            ProducerRecord<String,String> record = new ProducerRecord<>("1",message);
            kafkaProducerService.send(record);
            return "Message sent Successfully to the Kafka topic";
        }


}
