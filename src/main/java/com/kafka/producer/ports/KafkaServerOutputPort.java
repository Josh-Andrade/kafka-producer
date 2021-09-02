package com.kafka.producer.ports;

import com.kafka.producer.adapters.outbound.producer.objects.UsuarioKafka;

public interface KafkaServerOutputPort {

    void sendMessage(UsuarioKafka usuarioKafka);
}
