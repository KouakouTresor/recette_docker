package com.recette.rest;

import com.recette.exception.ResourceNotFoundException;
import com.recette.model.Recette;
import com.recette.repository.RecetteRepository;


import com.recette.service.RecetteService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/api/v1")
@RestController
public class RecetteController {
    @Autowired
    RecetteService recetteService;

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Recette recette) {
        recetteService.addRecette(recette);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateExpense(@RequestBody Recette recette) {
        recetteService.updateRecette(recette);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Recette>> getAllRecette() {
        return ResponseEntity.ok(recetteService.getAllRecette());
    }

    @GetMapping("/{id}")
    public ResponseEntity getRecetteById(@PathVariable String id) {
        return ResponseEntity.ok(recetteService.getRecette(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        recetteService.deleteRecette(id);
        return ResponseEntity.noContent().build();
    }

}
