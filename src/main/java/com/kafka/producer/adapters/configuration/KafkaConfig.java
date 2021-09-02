package com.kafka.producer.adapters.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaConfig {

    private final String kafkaServer;
    private final Integer retry;
    private final String nomeTopico;
    private final Integer partitions;
    private final Integer replicas;

    public KafkaConfig(@Value("${config.kafka.bootstrap.server}") String kafkaServer,
                       @Value("${config.kafka.retries}") Integer retry,
                       @Value("${config.kafka.nomeTopico}") String nomeTopico,
                       @Value("${config.kafka.partitions}") Integer partitions,
                       @Value("${config.kafka.replicas}") Integer replicas) {
        this.kafkaServer = kafkaServer;
        this.retry = retry;
        this.nomeTopico = nomeTopico;
        this.partitions = partitions;
        this.replicas = replicas;
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory(Map.of(
                KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class,
                BOOTSTRAP_SERVERS_CONFIG, kafkaServer,
                RETRIES_CONFIG, retry
        ));
    }

    @Bean
    KafkaTemplate<String, Object> kafkaTemplate(ProducerFactory<String, Object> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public NewTopic createTopic(){
        return TopicBuilder
                .name(nomeTopico)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
