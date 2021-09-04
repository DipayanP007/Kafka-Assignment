package com.knoldus.userMessagingSystem;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.FileWriter;
import java.util.*;

public class Consumer {

    public static void main(String[] args) {

        Properties properties = new Properties();
        String groupId = "Kafka-Assignment-User-Data-Consumer";
        String topic = "Kafka-Assignment-User-Data";
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", groupId);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);


        kafkaConsumer.subscribe(Arrays.asList(topic));
        try {
            while (true) {

                ConsumerRecords<String, String> consumerRecord = kafkaConsumer.poll(1000);
                FileWriter fileWriter = new FileWriter("UserData.txt", true);

                for (ConsumerRecord record : consumerRecord) {

                    String records = (record.value()).toString();
                    System.out.println("\nMessage\t{ "+records+" }\tReceived\n");
                    fileWriter.write(records + "\n");

                }
                fileWriter.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}


