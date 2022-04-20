package com.atguigu.springcloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/12 12:28
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        String payload = message.getPayload();

        System.out.println("消费者1号，------->接收到的消息：" + payload+"\t port: "+serverPort);
    }


}
