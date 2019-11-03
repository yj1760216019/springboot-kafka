package com.carlinx.cn.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
public class KafkaProducer {
    private static final Logger logger  = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    /**
     * 异步发送
     * @param topic
     * @param kay
     * @param value
     */
    public void kafkaAsyncProducer(String topic,String kay,String value){
        ListenableFuture<SendResult<String, String>> resultListenableFuture = kafkaTemplate.send(topic, kay, value);
        resultListenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("消息发送失败原因:[{}]",throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                RecordMetadata recordMetadata = result.getRecordMetadata();
                logger.info("消息发送成功，发送到[{}]分区",recordMetadata.partition());
                logger.info("消息发送成功偏移量[{}]",recordMetadata.offset());
            }
        });
    }


    /**
     * 同步发送
     * @param topic
     * @param key
     * @param value
     */
    public void kafkaProducer(String topic,String key,String value){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, value);

    }


}
