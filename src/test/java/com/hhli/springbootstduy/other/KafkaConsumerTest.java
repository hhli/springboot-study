package com.hhli.springbootstduy.other;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author 李辉辉
 * @date 2019-05-15 20:57
 * @description
 */
public class KafkaConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka01-matrix.zeus.lianjia.com:9092,kafka02-matrix.zeus.lianjia.com:9092,kafka03-matrix.zeus.lianjia.com:9092");
        props.put("group.id", "monitor_core_data_conmuser_group_id");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        //props.put("session.timeout.ms", 50);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        @SuppressWarnings("resource")
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        //consumer.subscribe(Arrays.asList("epx-10x200x12x211-7521-hdic_core_new"));

        TopicPartition p = new TopicPartition("epx-10x200x12x211-7521-hdic_core_new",3);

        consumer.assign(Arrays.asList(p));

        consumer.seek(p, 90000);


        while (true) {
            ConsumerRecords<String, String> c = consumer.poll(100);
            for(ConsumerRecord<String, String> c1: c) {
                System.out.println("Key: " + c1.key() + " Value: " + c1.value() + " Offset: " + c1.offset() + " Partitions: " + c1.partition());
            }
            if(!c.isEmpty()){
                System.out.println("size is:" + c.count());
                Thread.sleep(5000);
                break;
            }
        }

    }
}
