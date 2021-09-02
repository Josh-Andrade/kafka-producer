package com.kafka.producer.ports;

import com.kafka.producer.adapters.dto.UsuarioRequest;

public interface UsuarioServiceInputPort {

    void enviarUsuarioParaTopico(UsuarioRequest request);
}
