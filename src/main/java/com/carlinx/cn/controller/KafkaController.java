package com.carlinx.cn.controller;


import com.carlinx.cn.common.JsonResult;
import com.carlinx.cn.entity.KafkaMessage;
import com.carlinx.cn.kafka.KafkaProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@Api("kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;


    @PostMapping("/send")
    @ApiOperation("发送消息")
    public JsonResult sendMessage(@RequestBody KafkaMessage kafkaMessage){
        kafkaProducer.kafkaAsyncProducer(kafkaMessage.getTopic(),kafkaMessage.getKey(),kafkaMessage.getValue());
        return JsonResult.success(true);
    }



}
