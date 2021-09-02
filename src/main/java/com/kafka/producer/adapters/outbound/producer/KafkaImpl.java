package com.kafka.producer.adapters.outbound.producer;

import com.kafka.producer.adapters.outbound.producer.objects.UsuarioKafka;
import com.kafka.producer.ports.KafkaServerOutputPort;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaImpl implements KafkaServerOutputPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final String nomeTopico;

    public KafkaImpl(KafkaTemplate<String, Object> kafkaTemplate, String nomeTopico) {
        this.kafkaTemplate = kafkaTemplate;
        this.nomeTopico = nomeTopico;
    }

    @Override
    public void sendMessage(UsuarioKafka usuarioKafka) {
        kafkaTemplate.send(nomeTopico, usuarioKafka);
    }
}
