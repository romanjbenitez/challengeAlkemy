package com.challenge.alkemy.dtos;

import com.challenge.alkemy.models.Film;
import com.challenge.alkemy.models.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class GenreDTO {
    private Long id;
    private String image;
    private String name;

    private List<String> films;
    public GenreDTO() {
    }

    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
        this.image = genre.getImage();
        this.films = genre.getFilms().stream().map(Film::getTitle).collect(Collectors.toList());
    }
}
