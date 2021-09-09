package com.willian.thomaz.humanresourcesworker.resources;

import com.willian.thomaz.humanresourcesworker.entities.Worker;
import com.willian.thomaz.humanresourcesworker.repositories.Workerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    @Autowired
    private Workerrepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
