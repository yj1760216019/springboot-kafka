package com.carlinx.cn.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ConsumerListener {


    private Logger logger = LoggerFactory.getLogger(ConsumerListener.class);


    @KafkaListener(topics = {"carlinx"})
    public void consumerListener(ConsumerRecord<?,?> record){
        Optional<? > kafkaMessage = Optional.ofNullable(record);
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            logger.info("record:{}",record);
            logger.info("message:{}",message);
        }

    }

}
