package com.challenge.alkemy;

import com.challenge.alkemy.models.*;
import com.challenge.alkemy.models.Character;
import com.challenge.alkemy.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class AlkemyApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlkemyApplication.class, args);

    }
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData(CharacterRepository characterRepository,
                                      FilmRepository filmRepository,
                                      FimlsCharacterRepositoy fimlsCharacterRepositoy,
                                      GenreRepository genreRepository,
                                      AdminRepository adminRepository) {
        return (args) -> {

            Admin admin = new Admin("Admin@admin.com", passwordEncoder.encode("1234"));

            Character anakin = new Character("anakin.jpg" , "Anakin Skywalker", 23L, 120, "Star wars");
            Character obiWan = new Character("obiWan.jpg" , "Obi-Wan Kenobi", 57L, 80, "Star wars");
            Character Mickey = new Character("obiWan.jpg" , "Mickey Mouse", 12L, 80, "Mickey mouse");

            Film starWars1 = new Film("STARWARS", "Star wars I", LocalDate.of(2002, 7, 8), 3.7);
            Film starWars2 = new Film("STARWARS", "Star wars II", LocalDate.of(2002, 7, 8), 3.7);
            Film starWars3 = new Film("STARWARS", "Star wars III", LocalDate.of(2002, 7, 8), 3.7);
            Film starWars4 = new Film("STARWARS", "Star wars IV", LocalDate.of(2002, 7, 8), 3.7);
            Film starWars5 = new Film("STARWARS", "Star wars V", LocalDate.of(1999, 7, 8), 3.7);
            Film starWars6 = new Film("STARWARS", "Star wars VI", LocalDate.of(2002, 7, 8), 3.7);

            FilmsCharacter filmsCharacterOne = new FilmsCharacter(starWars1, obiWan);
            FilmsCharacter filmsCharacterTwo = new FilmsCharacter(starWars2, obiWan);
            FilmsCharacter filmsCharacterThree = new FilmsCharacter(starWars2, anakin);
            FilmsCharacter filmsCharacterFour = new FilmsCharacter(starWars6, anakin);
            FilmsCharacter filmsCharacterFive = new FilmsCharacter(starWars5, anakin);
            FilmsCharacter filmsCharacterSix = new FilmsCharacter(starWars4, Mickey);

            Genre action = new Genre("action", "action");

            adminRepository.save(admin);

            characterRepository.save(anakin);
            characterRepository.save(obiWan);
            characterRepository.save(Mickey);



            filmRepository.save(starWars1);
            filmRepository.save(starWars2);
            filmRepository.save(starWars3);
            filmRepository.save(starWars4);
            filmRepository.save(starWars5);
            filmRepository.save(starWars6);

            fimlsCharacterRepositoy.save(filmsCharacterOne);
            fimlsCharacterRepositoy.save(filmsCharacterTwo);
            fimlsCharacterRepositoy.save(filmsCharacterThree);
            fimlsCharacterRepositoy.save(filmsCharacterFour);
            fimlsCharacterRepositoy.save(filmsCharacterFive);
            fimlsCharacterRepositoy.save(filmsCharacterSix);

            genreRepository.save(action);

            starWars1.setGenre(action);
            starWars2.setGenre(action);
            starWars3.setGenre(action);
            starWars4.setGenre(action);
            starWars5.setGenre(action);
            starWars6.setGenre(action);

            filmRepository.save(starWars1);
            filmRepository.save(starWars2);
            filmRepository.save(starWars3);
            filmRepository.save(starWars4);
            filmRepository.save(starWars5);
            filmRepository.save(starWars6);




        };

    }

    ;
}
