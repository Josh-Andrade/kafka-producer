package com.kafka.producer.adapters.configuration;

import com.kafka.producer.ProducerApplication;
import com.kafka.producer.adapters.outbound.producer.KafkaImpl;
import com.kafka.producer.ports.KafkaServerOutputPort;
import com.kafka.producer.services.UsuarioServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
@ComponentScan(basePackageClasses = ProducerApplication.class)
public class BeanConfiguration {

    @Bean
    public UsuarioServiceImpl usuarioServiceImpl(KafkaServerOutputPort kafkaServerOutputPort, ModelMapper modelMapper){
        return new UsuarioServiceImpl(kafkaServerOutputPort, modelMapper);
    }

    @Bean
    public KafkaImpl kafkaImpl(KafkaTemplate<String, Object> kafkaTemplate,@Value("${config.kafka.nomeTopico}") String nomeTopico){
        return new KafkaImpl(kafkaTemplate, nomeTopico);
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
