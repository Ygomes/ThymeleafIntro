package com.example.demo.configuration;


import com.example.demo.entity.Cargo;
import com.example.demo.repository.CargoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CargoConfig {


    @Bean
    CommandLineRunner commandLineRunner(CargoRepository cargoRepository) {
        return args -> {
            List<Cargo> cargos = new ArrayList<>();
            Cargo presidente = new Cargo(1L, "Presidente");
            cargos.add(presidente);
            Cargo gerente = new Cargo(2L, "Gerente");
            cargos.add(gerente);
            Cargo vendedor = new Cargo(3L, "Vendedor");
            cargos.add(vendedor);
            Cargo desenvolvedor = new Cargo(4L, "Desenvolvedor");
            cargos.add(desenvolvedor);
            Cargo recepcionista = new Cargo(5L, "Recepcionista");
            cargos.add(recepcionista);
            cargoRepository.saveAll(cargos);
        };
    }
}
