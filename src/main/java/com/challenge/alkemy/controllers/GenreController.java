package com.challenge.alkemy.controllers;

import com.challenge.alkemy.dtos.GenreDTO;
import com.challenge.alkemy.models.Film;
import com.challenge.alkemy.models.FilmsCharacter;
import com.challenge.alkemy.models.Genre;
import com.challenge.alkemy.services.FilmService;
import com.challenge.alkemy.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    GenreService genreService;

    @Autowired
    FilmService filmService;

    @GetMapping
    public List<GenreDTO> getGenres(){
        return genreService.getGenres();
    }
    @PostMapping
    public ResponseEntity<Object> createGenre(@RequestParam String name,
                                              @RequestParam String image,
                                              @RequestParam(required = false) String title){

        if(name.isEmpty() || image.isEmpty()){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        Film currentFilm = filmService.getFilm(title);

        Genre newGenre = new Genre(image , name);

        genreService.saveGenre(newGenre);

        if(currentFilm != null){
            currentFilm.setGenre(newGenre);
            filmService.saveFilm(currentFilm);
        }



        return new ResponseEntity<>("create" , HttpStatus.CREATED) ;
    }

}
