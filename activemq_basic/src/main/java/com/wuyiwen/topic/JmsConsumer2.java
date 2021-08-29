package com.wuyiwen.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


//异步阻塞
public class JmsConsumer2 {
    public static final String ACTIVEMQ_URL = "tcp://8.140.6.130:61616";
    public static final String TOPIC_NAME = "test_01";

    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);
        // 5 创建消息的消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);


        messageConsumer.setMessageListener( (e) ->{
            if (null!= e && e instanceof  TextMessage){
                TextMessage textMessage = (TextMessage)e;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e1) {
                    e1.printStackTrace();
                }
            }
        });
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
