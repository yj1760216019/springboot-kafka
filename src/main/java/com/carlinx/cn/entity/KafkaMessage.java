package com.carlinx.cn.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("kafka消息模型")
public class KafkaMessage {
    @ApiModelProperty(value = "主题",dataType = "String")
    private String topic;
    @ApiModelProperty(value = "消息键",dataType = "String")
    private String key;
    @ApiModelProperty(value = "消息值",dataType = "String")
    private String value;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
