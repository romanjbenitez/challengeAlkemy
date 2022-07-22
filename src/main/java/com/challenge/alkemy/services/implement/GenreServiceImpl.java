package com.challenge.alkemy.services.implement;

import com.challenge.alkemy.dtos.GenreDTO;
import com.challenge.alkemy.models.Genre;
import com.challenge.alkemy.repositories.GenreRepository;
import com.challenge.alkemy.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    GenreRepository genreRepository;

    @Override
    public List<GenreDTO> getGenres() {
        return genreRepository.findAll().stream().map(GenreDTO::new).collect(Collectors.toList());
    }

    @Override
    public Genre getGenre(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }
}
