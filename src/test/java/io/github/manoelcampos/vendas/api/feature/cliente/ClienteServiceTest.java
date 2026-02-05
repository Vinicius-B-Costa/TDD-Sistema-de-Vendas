package io.github.manoelcampos.vendas.api.feature.cliente;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
    @InjectMocks
    private ClienteService service;
    @Mock
    private ClienteRepository repository;

    @Test
    void findByCPF() {
        final var cpfComSimbolos = "445.787.720-47";
        final var cpfSemSimolos = "44578772047";
        var caixa = Optional.of(new Cliente("Manoel",cpfSemSimolos,null));

        Mockito.when(repository.findByCpf(cpfSemSimolos))
                .thenReturn(caixa);

       // assertTrue(service.findByCpf(cpfComSimbolos).isPresent());
      //  assertTrue(service.findByCpf(cpfSemSimolos).isPresent());

        var cliente1 = service.findByCpf(cpfComSimbolos).orElseThrow();
        var cliente2 = service.findByCpf(cpfComSimbolos).orElseThrow();

        assertEquals(cpfSemSimolos, cliente1.getCpf());
        assertEquals(cpfSemSimolos, cliente1.getCpf());
    }
}