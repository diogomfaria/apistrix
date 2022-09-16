package br.com.fiap.strixapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.strixapi.model.Title;
import br.com.fiap.strixapi.repository.TitleRepository;

@Service
public class TitleService {
    
    @Autowired
    TitleRepository repository;

    public List<Title> listAll(){
        return repository.findAll();
    }

    public void save(Title task) {
        repository.save(task);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public Optional<Title> getById(Long id) {
        return repository.findById(id);
    }

}
