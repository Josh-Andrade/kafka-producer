package com.kafka.producer.services;

import com.kafka.producer.adapters.dto.UsuarioRequest;
import com.kafka.producer.adapters.outbound.producer.objects.UsuarioKafka;
import com.kafka.producer.domain.Usuario;
import com.kafka.producer.ports.KafkaServerOutputPort;
import com.kafka.producer.ports.UsuarioServiceInputPort;
import org.modelmapper.ModelMapper;

public class UsuarioServiceImpl implements UsuarioServiceInputPort {

    private final KafkaServerOutputPort kafkaServerOutputPort;

    private final ModelMapper modelMapper;

    public UsuarioServiceImpl(KafkaServerOutputPort kafkaServerOutputPort, ModelMapper modelMapper) {
        this.kafkaServerOutputPort = kafkaServerOutputPort;
        this.modelMapper = modelMapper;
    }

    @Override
    public void enviarUsuarioParaTopico(UsuarioRequest request) {
        Usuario usuario = modelMapper.map(request, Usuario.class);
        usuario.gerarId();
        kafkaServerOutputPort.sendMessage(modelMapper.map(usuario, UsuarioKafka.class));
    }
}
