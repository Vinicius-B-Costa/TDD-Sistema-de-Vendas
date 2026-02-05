package io.github.manoelcampos.vendas.api.feature.cliente;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClienteControllerTest {
    //enviar requisições http
    @Autowired
    private WebTestClient client;

    @Test
    void finByCpfInvalido() {
        var cpf = "000"; //invalido
        client.get()
                .uri("clientes/cpf/{cpf}", cpf)
                .exchange()
                .expectStatus()
                .isBadRequest();
    }

    @Test
    void finByCpfInexistente() {
        var cpf = "318.578.150-33"; //inexistente
        client.get()
                .uri("clientes/cpf/{cpf}", cpf)
                .exchange()
                .expectStatus()
                .isNotFound();
    }
}