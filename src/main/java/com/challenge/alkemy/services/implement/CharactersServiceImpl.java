package com.challenge.alkemy.services.implement;

import com.challenge.alkemy.dtos.CharacterDTO;
import com.challenge.alkemy.models.Character;
import com.challenge.alkemy.repositories.CharacterRepository;
import com.challenge.alkemy.services.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharactersServiceImpl implements CharactersService {
    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getCharacters() {
        return characterRepository.findAll().stream().map(CharacterDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CharacterDTO> getCharactersFilterByName(String name) {
        return characterRepository.findAll().stream().filter(character -> character.getName().toLowerCase().contains(name.toLowerCase())).map(CharacterDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CharacterDTO> getCharactersFilterByAge(int age) {
        return characterRepository.findAll().stream().filter(character -> character.getAge() == age).map(CharacterDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CharacterDTO> getCharactersFilterById(Long id) {
        return characterRepository.findAll().stream().filter(character -> character.getFilmsCharacters().stream().map(filmsCharacter -> filmsCharacter.getFilm().getId()).collect(Collectors.toList()).contains(id)).map(CharacterDTO::new).collect(Collectors.toList());
    }

    @Override
    public Character getCharacter(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    @Override
    public Character getCharacterByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public void saveCharacter(Character character) {
        characterRepository.save(character);
    }

}
