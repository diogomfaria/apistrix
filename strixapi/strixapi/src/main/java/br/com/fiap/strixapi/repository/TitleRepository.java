package br.com.fiap.strixapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.strixapi.model.Title;

public interface TitleRepository extends JpaRepository<Title, Long>{
    

}
