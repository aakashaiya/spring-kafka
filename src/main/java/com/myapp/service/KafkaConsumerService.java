package com.myapp.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "#{'${topic.topic-name}'}", groupId = "#{'${spring.kafka.consumer.group-id}'}", topicPartitions =
            @TopicPartition(topic = "#{'${topic.topic-name}'}", partitions = {"0","1","2"}) )
    public void listen(ConsumerRecord<String,String> record) {

        System.out.println("Offset : "+ record.offset());
        System.out.println("Partition : "+ record.partition());
        System.out.println("Received Message : " + record.value());
    }

}
