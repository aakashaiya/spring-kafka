package com.myapp.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topic.topic-name}")
    private String topicName;

    public void send(ProducerRecord<String,String> record) {

        //Send data to 3 partitions of the same topic. The last data could not be read since the concurrency factor of consumer is 2
        kafkaTemplate.send(topicName, 0 , record.key(), record.value());
        kafkaTemplate.send(topicName, 1 , record.key(), "Random");
        kafkaTemplate.send(topicName, 2 , record.key(), "Data");
    }
}
