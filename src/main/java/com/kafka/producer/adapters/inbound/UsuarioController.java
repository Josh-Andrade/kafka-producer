package com.kafka.producer.adapters.inbound;

import com.kafka.producer.adapters.dto.UsuarioRequest;
import com.kafka.producer.ports.UsuarioServiceInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServiceInputPort usuarioServiceInputPort;

    public UsuarioController(UsuarioServiceInputPort usuarioServiceInputPort) {
        this.usuarioServiceInputPort = usuarioServiceInputPort;
    }

    @PostMapping
    public ResponseEntity<?> enviarMensagem(@RequestBody @Valid UsuarioRequest usuario) {
        usuarioServiceInputPort.enviarUsuarioParaTopico(usuario);
        return ResponseEntity.ok("Messagem enviada para o tópico");
    }

}
