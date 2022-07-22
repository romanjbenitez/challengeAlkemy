package com.challenge.alkemy.services;

import com.challenge.alkemy.dtos.GenreDTO;
import com.challenge.alkemy.models.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GenreService {

    List<GenreDTO> getGenres();

    Genre getGenre(String name);
    Genre getGenreById(Long id);
    void saveGenre(Genre genre);
}
