package com.challenge.alkemy.dtos;

import com.challenge.alkemy.models.Character;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class CharacterDTO {
    long id;
    private String image;
    private String name;
    private long age;
    private int weight;
    private String story;
    private Set<String> films;


    public CharacterDTO() {

    }

    ;

    public CharacterDTO(Character character) {
        this.id = character.getId();
        this.image = character.getImage();
        this.name = character.getName();
        this.films = character.getFilmsCharacters().stream().map(FilmsCharacterDTO::new).map(FilmsCharacterDTO::getTittle).collect(Collectors.toSet());
        this.age = character.getAge();
        this.weight = character.getWeight();
        this.story = character.getStory();
    }

    ;


}
