package com.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class BonjourController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    public Client save(@RequestBody Client client) {
        return repository.save(client);
    }

    @PutMapping
    public Client update(@RequestBody Client client) {
        return repository.save(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable long id) {
        Optional<Client> client = repository.findById(id);
        return client.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}