package com.programmers.cat_picture_search.breed.repository;

import com.programmers.cat_picture_search.breed.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed, String> {


}
