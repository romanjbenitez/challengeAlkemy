package com.challenge.alkemy.services;

import com.challenge.alkemy.models.Character;
import com.challenge.alkemy.models.Film;
import com.challenge.alkemy.models.FilmsCharacter;
import org.springframework.stereotype.Service;

@Service
public interface FilmsCharacterService {

    FilmsCharacter getFilmCharacter(Film film , Character character);
    void saveFilmsCharacter(FilmsCharacter filmsCharacter);
    void deleteFilmsCharacter(FilmsCharacter filmsCharacter);
}
