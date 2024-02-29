package elamri.effyis.transaction.rmq.entity;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    @Value("${demande.queue}")
    private String QUEUE;

    @Value("${demande.exchange}")
    private String EXCHANGE ;

    @Value("${demande.route_key}")
    private String ROUTING_KEY ;

    @Bean
    public Queue demandeQueue() {
        return new Queue(QUEUE);
    }


    @Bean
    public TopicExchange Exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding Binding(Queue demandeQueue, TopicExchange demandeExchange) {
        return BindingBuilder
                .bind(demandeQueue)
                .to(demandeExchange)
                .with(ROUTING_KEY);
    }
    @Bean
    public TopicExchange demandeExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding demandeBinding(Queue demandeQueue, TopicExchange demandeExchange) {
        return BindingBuilder
                .bind(demandeQueue)
                .to(demandeExchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public Binding reponseBinding(Queue reponseQueue, TopicExchange demandeExchange) {
        return BindingBuilder
                .bind(reponseQueue)
                .to(demandeExchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter demandeMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("rabbitmq");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    @Bean
    public AmqpTemplate demandeTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(demandeMessageConverter());
        return template;
    }
}