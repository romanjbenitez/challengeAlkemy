package com.challenge.alkemy.services;

import com.challenge.alkemy.dtos.CharacterDTO;

import com.challenge.alkemy.models.Character;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CharactersService {
    List<CharacterDTO> getCharacters();
    List<CharacterDTO> getCharactersFilterByName(String name);
    List<CharacterDTO> getCharactersFilterByAge(int age);
    List<CharacterDTO> getCharactersFilterById(Long id);

    Character getCharacter(Long id);

    Character getCharacterByName(String name);

    void saveCharacter(Character character);
}
