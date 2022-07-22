package com.challenge.alkemy.dtos;

import com.challenge.alkemy.models.FilmsCharacter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterFilmDTO {
    private String character;

    public CharacterFilmDTO() {
    }
    public CharacterFilmDTO(FilmsCharacter filmsCharacter) {
        this.character = filmsCharacter.getCharacter().getName();
    }
}
