package com.challenge.alkemy.services.implement;

import com.challenge.alkemy.models.Character;
import com.challenge.alkemy.models.Film;
import com.challenge.alkemy.models.FilmsCharacter;
import com.challenge.alkemy.repositories.FimlsCharacterRepositoy;
import com.challenge.alkemy.services.FilmsCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmsCharacterServiceImpl implements FilmsCharacterService {

    @Autowired
    private FimlsCharacterRepositoy fimlsCharacterRepositoy;

    @Override
    public FilmsCharacter getFilmCharacter(Film film, Character character) {
        return fimlsCharacterRepositoy.findByFilmAndCharacter(film, character);
    }

    @Override
    public void saveFilmsCharacter(FilmsCharacter filmsCharacter) {
        fimlsCharacterRepositoy.save(filmsCharacter);
    }

    @Override
    public void deleteFilmsCharacter(FilmsCharacter filmsCharacter) {
        fimlsCharacterRepositoy.delete(filmsCharacter);
    }
}
