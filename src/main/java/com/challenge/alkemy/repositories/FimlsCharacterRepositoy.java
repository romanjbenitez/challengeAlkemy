package com.challenge.alkemy.repositories;


import com.challenge.alkemy.models.FilmsCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FimlsCharacterRepositoy extends JpaRepository<FilmsCharacter, Long> {
}
