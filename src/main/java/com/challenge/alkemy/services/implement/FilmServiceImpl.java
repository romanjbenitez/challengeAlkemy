package com.challenge.alkemy.services.implement;

import com.challenge.alkemy.dtos.FilmDTO;
import com.challenge.alkemy.models.Film;
import com.challenge.alkemy.models.Order;
import com.challenge.alkemy.repositories.FilmRepository;
import com.challenge.alkemy.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Override
    public List<FilmDTO> getFilms() {
        return filmRepository.findAll().stream().map(FilmDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<FilmDTO> getFilmsFilterByName(String name) {
        return filmRepository.findAll().stream().filter(film -> film.getTitle().contains(name)).map(FilmDTO::new).collect(Collectors.toList());
    }
    @Override
    public List<FilmDTO> getFilmsFilterByGenre(String genreName) {
        return filmRepository.findAll().stream().filter(film -> film.getGenre().getName().equals(genreName)).map(FilmDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<FilmDTO> getFilmsOrder(Order order) {
        if(order.equals(Order.DESC)){
            return filmRepository.findAll().stream().map(FilmDTO::new).sorted(Comparator.comparingLong(FilmDTO::getId).reversed()).collect(Collectors.toList());
        }
        return filmRepository.findAll().stream().map(FilmDTO::new).sorted(Comparator.comparingLong(FilmDTO::getId)).collect(Collectors.toList());
    }


    @Override
    public Film getFilm(String tittle) {
        return filmRepository.findByTitle(tittle);
    }

    @Override
    public Film getFilmByID(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public void saveFilm(Film film) {
        filmRepository.save(film);
    }

    @Override
    public void deleteFilm(Film film) {
        filmRepository.delete(film);
    }
}
