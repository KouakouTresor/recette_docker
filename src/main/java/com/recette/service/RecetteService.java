package com.recette.service;

import com.recette.exception.ResourceNotFoundException;
import com.recette.model.Recette;
import com.recette.repository.RecetteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RecetteService {
    @Autowired
    RecetteRepository recetteRepository;

    public void addRecette(Recette recette) {
        recetteRepository.insert(recette);
    }

    public void updateRecette(Recette recette) {
        Recette savedrecette = recetteRepository.findById(recette.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find recette by ID %s", recette.getId())));
        savedrecette.setName(recette.getName());
        savedrecette.setLarecette(recette.getLarecette());
        savedrecette.setIngredients(recette.getIngredients());

        recetteRepository.save(recette);
    }

    public Recette getRecette(String id) {
        return recetteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by id - %s", id)));
    }
    public List<Recette> getAllRecette() {
        return recetteRepository.findAll();
    }

    public void deleteRecette(String id) {
        recetteRepository.deleteById(id);
    }
}
