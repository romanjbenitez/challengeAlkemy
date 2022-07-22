package com.challenge.alkemy.dtos;

import com.challenge.alkemy.models.FilmsCharacter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class FilmsCharacterDTO {
    private String tittle;

    public FilmsCharacterDTO() {
    }
    public FilmsCharacterDTO(FilmsCharacter filmsCharacter) {
        this.tittle = filmsCharacter.getFilm().getTitle();

    }
}
