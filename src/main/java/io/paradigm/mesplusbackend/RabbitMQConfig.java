package io.paradigm.mesplusbackend;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "db_changes_queue";
    public static final String EXCHANGE_NAME = "db_changes_exchange";
    public static final String ROUTING_KEY = "routing-key";

    @Bean
    public Queue queue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }
    @Bean
    public Exchange exchange(){
        return new DirectExchange(EXCHANGE_NAME,true,false);
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to((DirectExchange) exchange).with(ROUTING_KEY);
    }
}
