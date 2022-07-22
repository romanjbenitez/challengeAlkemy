package com.challenge.alkemy.services.implement;

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
    public void saveFilmsCharacter(FilmsCharacter filmsCharacter) {
        fimlsCharacterRepositoy.save(filmsCharacter);
    }
}
