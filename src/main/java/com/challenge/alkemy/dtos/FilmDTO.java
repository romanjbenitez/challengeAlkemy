package com.challenge.alkemy.dtos;

import com.challenge.alkemy.models.Film;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class FilmDTO {
    private long id;

    private String image;
    private String title;
    private LocalDate starDate;
    private double score;

    private Set<String> characters;
    private String genre;

    public FilmDTO() {

    }

    public FilmDTO(Film film) {
        this.id = film.getId();
        this.image = film.getImage();
        this.starDate = film.getStarDate();
        this.score = film.getScore();
        this.title = film.getTitle();
        this.characters = film.getFilmsCharacters().stream().map(CharacterFilmDTO::new).map(CharacterFilmDTO::getCharacter).collect(Collectors.toSet());
        this.genre = film.getGenre().getName();
    }
}
