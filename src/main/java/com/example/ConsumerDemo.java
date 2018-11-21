package com.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;



public class ConsumerDemo {
	public static void main(String[] args) {
		String bootstrapserver ="127.0.0.1:9091";
		String groupId = "first";
		String topic ="test_topic";
		
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,groupId);
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		List<String> list = new ArrayList<>();
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(properties);
		list.add(topic);
		
		consumer.subscribe(list);
		while(true) {
			ConsumerRecords<String,String> records = consumer.poll(Duration.ofSeconds(30));
			for(ConsumerRecord<String,String>record :records) {
				System.out.println("record key "+record.hashCode() +" record value "+record.value());
				System.out.println("record partition = "+record.partition()+ " record offset "+record.offset());
			}
		}
		
	}
}
