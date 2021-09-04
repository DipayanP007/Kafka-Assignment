package com.knoldus.userMessagingSystem;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {

    public static void main(String[] args)throws InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers" , "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        String topic = "Kafka-Assignment-User-Data";
        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        UserMessage userMessage = new UserMessage(1,"Dipayan Pramanik",22,"B.Tech");

        ProducerRecord producerRecord = new ProducerRecord(topic,userMessage.toString());
        System.out.println("Message\t{ "+userMessage.toString()+" }\t Sent To Consumer");
        kafkaProducer.send(producerRecord);
        kafkaProducer.close();

    }
}


