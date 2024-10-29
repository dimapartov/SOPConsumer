package com.example.sopconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SopConsumerApplication {

    public static final String ORDERS_QUEUE_NAME = "ordersQueue";

    private final MessageProcessor messageProcessor;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    public SopConsumerApplication(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }


    @Bean
    public Queue ordersQueue() {
        return new Queue(ORDERS_QUEUE_NAME, true);
    }


    @RabbitListener(queues = ORDERS_QUEUE_NAME)
    public void listenOrdersQueue(String message) throws JsonProcessingException {
        OrderStatusMessage msg = objectMapper.readValue(message, OrderStatusMessage.class);
        messageProcessor.processMessage(msg.getCustomerEmail(), msg.getOrderStatus());
    }


    public static void main(String[] args) {
        SpringApplication.run(SopConsumerApplication.class, args);
    }

}