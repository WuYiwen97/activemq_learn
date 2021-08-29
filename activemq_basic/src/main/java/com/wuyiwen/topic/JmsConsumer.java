package com.wuyiwen.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

//同步阻塞
public class JmsConsumer {
    public static final String ACTIVEMQ_URL = "tcp://8.140.6.130:61616";
    public static final String TOPIC = "test_01";

    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        javax.jms.Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC);
        // 5 创建消息的消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);
        while(true){
            // reveive() 一直等待接收消息，在能够接收到消息之前将一直阻塞。 是同步阻塞方式 。和socket的accept方法类似的。
// reveive(Long time) : 等待n毫秒之后还没有收到消息，就是结束阻塞。
            // 因为消息发送者是 TextMessage，所以消息接受者也要是TextMessage
            TextMessage message = (TextMessage)messageConsumer.receive();
            if (null != message){
                System.out.println("****消费者的消息："+message.getText());
            }else {
                break;
            }
        }
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
