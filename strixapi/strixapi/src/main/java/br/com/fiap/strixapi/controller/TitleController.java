package br.com.fiap.strixapi.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.strixapi.model.Title;
import br.com.fiap.strixapi.service.TitleService;

@RestController
@RequestMapping("/api/task")
public class TitleController {

    @Autowired
    private TitleService service;
    
    @GetMapping
    public List<Title> index(){
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Title> create(@RequestBody @Valid Title task){
        service.save(task);
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(task);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        var optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Title> show(@PathVariable Long id){
        return ResponseEntity.of(service.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Title> update(@PathVariable Long id, @RequestBody @Valid Title newTask){
        var optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        var task = optional.get();
        BeanUtils.copyProperties(newTask, task);
        task.setId(id);

        service.save(task);
        return ResponseEntity.ok(task);
    }




}
