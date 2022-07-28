package com.challenge.alkemy.models;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Getter
@Setter
@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String image;
    private String name;
    private long age;
    private int weight;

    @Column(length=1000)
    private String story;

    @OneToMany(mappedBy="character", fetch=FetchType.EAGER)
    Set<FilmsCharacter> filmsCharacters;

    public Character() {
    }

    public Character(String image, String name, long age, int weight, String story) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.story = story;
    }

    public void addFilmsCharacters(FilmsCharacter filmsCharacter) {
        filmsCharacter.setCharacter(this);
        filmsCharacters.add(filmsCharacter);
    }
    public List<Film> getFilms() {
        return filmsCharacters.stream().map(FilmsCharacter::getFilm).collect(toList());
    }
}
