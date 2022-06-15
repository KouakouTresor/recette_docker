package com.recette.repository;

import com.recette.model.Recette;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RecetteRepository extends MongoRepository<Recette, String> {


}
