package com.challenge.alkemy.services;

import com.challenge.alkemy.dtos.FilmDTO;
import com.challenge.alkemy.models.Film;
import com.challenge.alkemy.models.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService{

    List<FilmDTO> getFilms();
    List<FilmDTO> getFilmsFilterByName(String name);
    List<FilmDTO> getFilmsFilterByGenre(String genreName);

    List<FilmDTO> getFilmsOrder(Order order);
    Film getFilm(String tittle);

    Film getFilmByID(Long id);



    void saveFilm(Film film);
    void deleteFilm(Film film);
}
