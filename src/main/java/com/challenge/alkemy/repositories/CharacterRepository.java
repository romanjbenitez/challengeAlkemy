package com.challenge.alkemy.repositories;

import com.challenge.alkemy.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findByName(String name);
}
