package com.knoldus.userMessagingSystem;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.io.*;

public class Producer {

    public static void main(String[] args) throws InterruptedException, IOException {

        String topic = "Kafka-Assignment-User-Data";
        int id, age;
        String name, course;

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        Thread.sleep(1000);
        while (true){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Press ! to exit or anything else to continue");
            char choice = bufferedReader.readLine().charAt(0);
            if (choice == '!')
                break;
            System.out.println("Enter ID");
            id = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter Name");
            name = (bufferedReader.readLine());
            System.out.println("Enter Age");
            age = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter Course");
            course = (bufferedReader.readLine());

            UserMessage userMessage = new UserMessage(id, name, age, course);
            ProducerRecord producerRecord = new ProducerRecord(topic, userMessage.toString());
            kafkaProducer.send(producerRecord);
            System.out.println("Message\t{ " + userMessage.toString() + " }\t Sent To Consumer");
            Thread.sleep(500);
        }
        kafkaProducer.close();

    }
}


