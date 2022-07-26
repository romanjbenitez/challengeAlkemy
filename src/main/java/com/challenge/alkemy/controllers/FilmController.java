package com.challenge.alkemy.controllers;

import com.challenge.alkemy.dtos.FilmDTO;
import com.challenge.alkemy.models.Character;
import com.challenge.alkemy.models.Film;
import com.challenge.alkemy.models.FilmsCharacter;
import com.challenge.alkemy.models.Genre;
import com.challenge.alkemy.models.Order;
import com.challenge.alkemy.services.CharactersService;
import com.challenge.alkemy.services.FilmService;
import com.challenge.alkemy.services.FilmsCharacterService;
import com.challenge.alkemy.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class FilmController {
    @Autowired
    FilmService filmService;

    @Autowired
    CharactersService charactersService;
    @Autowired
    FilmsCharacterService filmsCharacterService;
    @Autowired
    GenreService genreService;

    @GetMapping
    public List<FilmDTO> getFilms(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) Long genre,
                                  @RequestParam(required = false) Order order) {

        if(genre != null && genre > 0) {
           Genre currentGenre =  genreService.getGenreById(genre);
           return filmService.getFilmsFilterByGenre(currentGenre.getName());
        }
        if(name != null && !name.isEmpty()){
            return filmService.getFilmsFilterByName(name);
        }
        if(order != null){
            return filmService.getFilmsOrder(order);
        }
            return filmService.getFilms();
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Object> createFilm(@RequestParam String title,
                                             @RequestParam String image,
                                             @RequestParam String starDate,
                                             @RequestParam Double score,
                                             @RequestParam String genre,
                                             @RequestParam(required = false) String character) {

        if (title.isEmpty() || image.isEmpty() || starDate.isEmpty() || score < 0 || genre.isEmpty()) {
            return new ResponseEntity<>("Missing Data", HttpStatus.FORBIDDEN);
        }
        LocalDate localDate = LocalDate.parse(starDate);

        Film newFilm = new Film(image, title, localDate, score);

        filmService.saveFilm(newFilm);
        Genre genreFilm= genreService.getGenre(genre);
        if (character != null && !character.isEmpty()) {
            filmsCharacterService.saveFilmsCharacter(new FilmsCharacter(newFilm, charactersService.getCharacterByName(character)));
        }
        if(genreFilm == null){
            return new ResponseEntity<>("Invalid Genre", HttpStatus.FORBIDDEN);
        }
        newFilm.setGenre(genreFilm);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    @Transactional
    @PatchMapping
    public ResponseEntity<Object> updateFilm(@RequestParam Long id,
                                             @RequestParam(required = false) String title,
                                             @RequestParam(required = false) String image,
                                             @RequestParam(required = false) String starDate,
                                             @RequestParam(required = false) Double score,
                                             @RequestParam(required = false) String genre){
        Film currentFilm = filmService.getFilmByID(id);

        if(currentFilm == null){
            return new ResponseEntity<>("Invalid Id", HttpStatus.FORBIDDEN);
        }

        if(title != null && !title.isEmpty()) {
            currentFilm.setTitle(title);
        }
        if(image != null && !image.isEmpty()) {
            currentFilm.setImage(image);
        }
        if(starDate != null && !starDate.isEmpty()) {
            LocalDate localDate = LocalDate.parse(starDate);
            currentFilm.setStarDate(localDate);
        }
        if(score != null && score > 0){
            currentFilm.setScore(score);
        }
        if(genre != null && !genre.isEmpty()) {
            currentFilm.setGenre(genreService.getGenre(genre));
        }

        return new ResponseEntity<>("Updated", HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Object> deleteFilm(@RequestParam Long idFilm ){

        if(idFilm < 0){
            return new ResponseEntity<>("Missing data" , HttpStatus.FORBIDDEN);
        }

        Film currentFilm = filmService.getFilmByID(idFilm);

        if(currentFilm == null){
            return new ResponseEntity<>("Please insert a valid id" , HttpStatus.FORBIDDEN);
        }
        filmService.deleteFilm(currentFilm);

        return new ResponseEntity<>("Deleted" ,HttpStatus.ACCEPTED);
    }

    @PostMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Object> addCharacterToFilm(@PathVariable Long idMovie, @PathVariable Long idCharacter ){
        if(idCharacter < 0 || idMovie < 0 ){
            return new ResponseEntity<>("Invalid id" , HttpStatus.FORBIDDEN);
        }
        Character currentCharacter = charactersService.getCharacter(idCharacter);
        Film currentFilm = filmService.getFilmByID(idMovie);

        if(currentFilm == null){
            return new ResponseEntity<>("Please insert a valid idMovie" , HttpStatus.FORBIDDEN);
        }
        if(currentCharacter == null){
            return new ResponseEntity<>("Please insert a valid idCharacter" , HttpStatus.FORBIDDEN);
        }

        FilmsCharacter filmsCharacter = new FilmsCharacter(currentFilm, currentCharacter);
        filmsCharacterService.saveFilmsCharacter(filmsCharacter);

        return new ResponseEntity<>("Added", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Object> removeMovieCharacter(@PathVariable Long idMovie, @PathVariable Long idCharacter){

        if(idCharacter < 0 || idMovie < 0 ){
            return new ResponseEntity<>("Invalid id" , HttpStatus.FORBIDDEN);
        }
        Character currentCharacter = charactersService.getCharacter(idCharacter);
        Film currentFilm = filmService.getFilmByID(idMovie);
        if(currentFilm == null){
            return new ResponseEntity<>("Please insert a valid idMovie" , HttpStatus.FORBIDDEN);
        }
        if(currentCharacter == null){
            return new ResponseEntity<>("Please insert a valid idCharacter" , HttpStatus.FORBIDDEN);
        }

        FilmsCharacter currentFilmCharacter = filmsCharacterService.getFilmCharacter(currentFilm, currentCharacter);
        filmsCharacterService.deleteFilmsCharacter(currentFilmCharacter);

        return new ResponseEntity<>("Removed", HttpStatus.ACCEPTED);
    }
}
