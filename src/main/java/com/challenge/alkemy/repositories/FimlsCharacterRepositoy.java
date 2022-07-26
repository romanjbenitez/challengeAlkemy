package com.challenge.alkemy.repositories;


import com.challenge.alkemy.models.Character;
import com.challenge.alkemy.models.Film;
import com.challenge.alkemy.models.FilmsCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FimlsCharacterRepositoy extends JpaRepository<FilmsCharacter, Long> {
    FilmsCharacter findByFilmAndCharacter(Film film, Character character);
}
