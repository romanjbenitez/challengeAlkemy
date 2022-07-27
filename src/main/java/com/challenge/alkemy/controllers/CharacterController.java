package com.challenge.alkemy.controllers;

import com.challenge.alkemy.dtos.CharacterDTO;
import com.challenge.alkemy.models.Character;
import com.challenge.alkemy.models.Film;
import com.challenge.alkemy.models.FilmsCharacter;
import com.challenge.alkemy.services.CharactersService;
import com.challenge.alkemy.services.FilmService;
import com.challenge.alkemy.services.FilmsCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private CharactersService charactersService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmsCharacterService filmsCharacterService;

    @GetMapping
    public List<CharacterDTO> getCharacters(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) Integer age,
                                            @RequestParam(required = false) Long idMovie) {

        if (name != null && !name.isEmpty()) {
            return charactersService.getCharactersFilterByName(name);
        }
        if (age != null && age > 0) {
            return charactersService.getCharactersFilterByAge(age);
        }
        if (idMovie != null && idMovie > 0) {
            return charactersService.getCharactersFilterById(idMovie);
        }


        return charactersService.getCharacters();
    }

    @PostMapping
    public ResponseEntity<Object> createCharacter(@RequestParam String name,
                                                  @RequestParam String image,
                                                  @RequestParam long age,
                                                  @RequestParam int weigth,
                                                  @RequestParam String story,
                                                  @RequestParam(required = false) String tittle) {


        if (name.isEmpty() || image.isEmpty() || age < 0 || weigth < 0 || story.isEmpty()) {
            return new ResponseEntity<>("missing data", HttpStatus.FORBIDDEN);
        }


        Character newCharater = new Character(name, image, age, weigth, story);
        Film film = filmService.getFilm(tittle);

        charactersService.saveCharacter(newCharater);

        if (film != null) {
            filmsCharacterService.saveFilmsCharacter(new FilmsCharacter(film, newCharater));
        }


        return new ResponseEntity<>("created", HttpStatus.CREATED);

    }

    @PatchMapping
    public ResponseEntity<Object> updateCharacter(@RequestParam Long id,
                                                  @RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String image,
                                                  @RequestParam(required = false) Long age,
                                                  @RequestParam(required = false) Integer weigth,
                                                  @RequestParam(required = false) String story,
                                                  @RequestParam(required = false) String tittle) {

        if (id.toString().isEmpty()) {
            return new ResponseEntity<>("missing character ID", HttpStatus.FORBIDDEN);
        }
        Character currentCharacter = charactersService.getCharacter(id);

        if (name != null && !name.isEmpty()) {
            currentCharacter.setName(name);
        }
        if (image != null && !image.isEmpty()) {
            currentCharacter.setImage(image);
        }
        if (age != null && age > 0) {
            currentCharacter.setAge(age);
        }
        if (weigth != null && weigth > 0) {
            currentCharacter.setWeight(weigth);
        }
        if (story != null && !story.isEmpty()) {
            currentCharacter.setStory(story);
        }

        Film film = filmService.getFilm(tittle);
        if (film != null) {
            filmsCharacterService.saveFilmsCharacter(new FilmsCharacter(film, currentCharacter));
        }


        charactersService.saveCharacter(currentCharacter);


        return new ResponseEntity<>("updated", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCharacter(@RequestParam Long idCharacter){

        if(idCharacter < 0){
            return new ResponseEntity<>("Missing data" , HttpStatus.FORBIDDEN);
        }

        Character currentCharacter = charactersService.getCharacter(idCharacter);

        if(currentCharacter == null){
            return new ResponseEntity<>("Please insert a valid id" , HttpStatus.FORBIDDEN);
        }

        charactersService.deleteCharacter(currentCharacter);
        return new ResponseEntity<>("Deleted" ,HttpStatus.ACCEPTED);
    }
}
