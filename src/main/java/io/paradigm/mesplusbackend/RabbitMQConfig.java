package io.paradigm.mesplusbackend;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue queue(){
        return new Queue("db_changes_queue",true);
    }

    @Bean
    public Exchange exchange(){
        return new DirectExchange("db_changes_exchange");
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to((DirectExchange) exchange).with("routing-key");
    }
}
