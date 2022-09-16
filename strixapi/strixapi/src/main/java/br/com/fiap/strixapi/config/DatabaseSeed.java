package br.com.fiap.strixapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.strixapi.model.Title;
import br.com.fiap.strixapi.repository.TitleRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TitleRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(List.of( 
            new Title("Game of Thrones", "Finalizado"),
            new Title("Friends", "Em progresso")
        ));
    }
    
}
