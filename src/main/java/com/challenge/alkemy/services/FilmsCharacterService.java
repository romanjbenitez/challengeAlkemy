package com.challenge.alkemy.services;

import com.challenge.alkemy.models.FilmsCharacter;
import org.springframework.stereotype.Service;

@Service
public interface FilmsCharacterService {

    void saveFilmsCharacter(FilmsCharacter filmsCharacter);
}
