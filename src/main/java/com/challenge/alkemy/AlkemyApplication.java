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

            Character anakin = new Character("https://i.ibb.co/0Q0RvmS/anakin.webp" , "Anakin Skywalker", 23L, 120, "Anakin Skywalker was a Human male born on the Outer Rim world of Tatooine. He later served the Galactic Republic as a Jedi Knight, and later the Galactic Empire as the Sith Lord Darth Vader.");
            Character obiWan = new Character("https://i.ibb.co/wW9k8Py/Obi-Wan-Kenobi-Perfil.webp" , "Obi-Wan Kenobi", 57L, 80, "Kenobi was born on the planet Stewjon in 57 BBY. He was Force-sensitive, and therefore taken from his family and inducted into the Jedi Order as a child. Raised in the Jedi Temple on the planet Coruscant, Kenobi was assigned to Jedi Master Qui-Gon Jinn.");
            Character yoda  = new Character("https://i.ibb.co/5hfHqHc/Yoda-SWSB.webp" , "Yoda ", 900L, 12, "Yoda was a legendary Jedi Master and stronger than most in his connection with the Force. Small in size but wise and powerful, he trained Jedi for over 800 years, playing integral roles in the Clone Wars, the instruction of Luke Skywalker, and unlocking the path to immortality.");
            Character tarzanCharacter  = new Character("https://i.ibb.co/KFBvSTM/TARZAN-noticia.jpg" , "Tarzan", 18L, 76, "Tarzan is the son of a British lord and lady who were marooned on the coast of Angola by mutineers. When Tarzan was an infant, his mother died, and his father was killed by Kerchak, leader of the ape tribe by whom Tarzan was adopted.");
            Character terk  = new Character("https://i.ibb.co/Nm9WcgP/5ee9d1e3bb8568ece161f09b7efd279c.jpg" , "Terk", 17L, 120, "Terkina, or better known as Terk for short, is the niece of Kala and Kerchak, Tarzan's best friend and adoptive cousin.");
            Character cinderellaCharacter  = new Character("https://i.ibb.co/bQSm465/Clipart-grande-taille2.webp" , "Cinderella", 19L, 46, "The Cinderella that English speakers know and love can be traced to the French story Cendrillon, first published in 1697 by Charles Perrault, though Chinese and Greek versions of this classic tale go back to the 9th century CE and 6th century BCE, respectively.");
            Character fairy   = new Character("https://i.ibb.co/9qHYnB1/Hada-Madrina.webp" , "Fairy Godmother", 600L, 67, "The Fairy Godmother is a supporting character in Disney's 1950 animated feature film, Cinderella. The physical embodiment of hope, she is a kindly fairy that is devoted to making dreams come true for the pure-hearted and noble—an act made possible by proclaiming the magic words, bibbidi-bobbidi-boo.");
            Character pinocchioCharacter  = new Character("https://i.ibb.co/0ZD7SkY/pinocho.webp" , "Pinocchio", 8L, 25, "Pinocchio was carved by a woodcarver named Geppetto in a Tuscan village. He was created as a wooden puppet but he dreams of becoming a real boy. He is known for his long nose, which (on only one occasion in the novel, but more frequently in most adaptations) grows when he lies.");
            Character jiminy  = new Character("https://i.ibb.co/PhsRmTm/Jiminy-Cricket.webp" , "Jiminy Cricket", 1L, 25, "Jiminy Cricket is the Walt Disney version of the \"Talking Cricket\" (Italian: Il Grillo Parlante), a fictional character created by Italian writer Carlo Collodi for his 1883 children's book The Adventures of Pinocchio, which Disney adapted into the animated film Pinocchio in 1940.");
            Character aliceCharacter  = new Character("https://i.ibb.co/G5VC2Vj/Alice.webp" , "Alice Kingsleigh", 7L, 25, "Alice is the main character from the original books Alice's Adventures in Wonderland and its satisfying sequel, Through the Looking-Glass, and What Alice Found There by Lewis Carroll. She is also prominent in most expansions of the  myths.");
            Character chessur  = new Character("https://i.ibb.co/k2vWBvB/Disney-Cheshire-Cat.webp" , "Chessur", 6L, 15, "Chessur is a cheshire cat who possesses the ability to freely appear and disappear. He is always calm, with a seductive grin that masks his slightly cowardice.");
            Character woody  = new Character("https://i.ibb.co/168LHb3/Woody.webp" , "Woody", 70L, 1, "Woody was designed by Bud Luckey, and is based on John Lasseter's Casper pull-string doll he had as a kid, as well as the Howdy Doody puppets from the 1950s show. Woody is named after Woody Strode, a character actor known for many roles in western films.");
            Character buzz  = new Character("https://i.ibb.co/yS95r1p/BUZ-LIGHTYEAR.webp" , "Buzz Ligthyear", 1L, 1, "Buzz was created during a time where astronauts were especially popular amongst children. Because of this, his arrival in the original Toy Story created conflict with Andy's favorite toy, Sheriff Woody, though this rivalry would eventually blossom into a lifelong friendship.");
            Character herculesCharacter  = new Character("https://i.ibb.co/BzZDR9v/Hercules.webp" , "Hercules", 20L, 76, "Hercules, son of Hera and the god Zeus, is stolen from Olympus by the minions of Hades to reach Earth and strip him of his immortality. However, the plan does not turn out as expected and the boy still retains some divine powers. During his adolescence, Hercules must prove that he is worthy of ascending to Olympus with the other gods. With the help of the satyr Philoctetes, Hercules will learn to use his strength to fight against a series of evil creatures.");
            Character megara  = new Character("https://i.ibb.co/vJ8vZws/megara.jpg" , "Hercules", 20L, 56, "Megara (better known as Meg) is the tritagonist of Disney's 1997 animated feature film, Hercules. A snarky \"femme fatale\", Meg once served as a reluctant minion of Hades, to whom she was indebted.");


            Film starWars1 = new Film("https://i.ibb.co/T0b1jPp/starwars1.jpg", "Star wars I", LocalDate.of(1999, 7, 8), 3.8);
            Film starWars2 = new Film("https://i.ibb.co/FHqLp2G/Episode-two.webp", "Star wars II", LocalDate.of(2002, 5, 16), 3.7);
            Film starWars3 = new Film("https://i.ibb.co/tZXZ1kS/Ep3-poster.webp", "Star wars III", LocalDate.of(2005, 5, 19), 4.2);
            Film starWars4 = new Film("https://i.ibb.co/fdbNYvQ/starwars4.jpg", "Star wars IV", LocalDate.of(1977, 12, 25), 4.5);
            Film starWars5 = new Film("https://i.ibb.co/cwB73gr/Star-Wars-Episode-V.webp", "Star wars V", LocalDate.of(1980, 7, 31), 4.5);
            Film starWars6 = new Film("https://i.ibb.co/dpW898z/starwars6.jpg", "Star wars VI", LocalDate.of(1983, 12, 8), 4.7);
            Film pinocchio = new Film("https://i.ibb.co/gmpv2Gn/pinocho.jpg", "Pinocchio", LocalDate.of(1940, 2, 23), 4.4);
            Film cinderella = new Film("https://i.ibb.co/hLk6RrD/cinderella.jpg", "Cinderella", LocalDate.of(1950, 7, 5), 4.3);
            Film alice = new Film("https://i.ibb.co/dJZ6RgV/alice.jpg", "Alice in Wonderland", LocalDate.of(1950, 7, 5), 4.3);
            Film toyStory = new Film("https://i.ibb.co/cJdpdJ1/toy-story.jpg", "Toy Story", LocalDate.of(1996, 3, 14), 4.8);
            Film hercules = new Film("https://i.ibb.co/JcJBq9d/hercules.jpg", "Hercules", LocalDate.of(1997, 7, 3), 4.6);
            Film tarzan = new Film("https://i.ibb.co/gDb3FfG/Tarzan.webp", "Tarzan", LocalDate.of(1999, 7, 8), 4.8);

            characterRepository.save(anakin);
            characterRepository.save(obiWan);
            characterRepository.save(yoda);
            characterRepository.save(tarzanCharacter);
            characterRepository.save(terk);
            characterRepository.save(cinderellaCharacter);
            characterRepository.save(fairy);
            characterRepository.save(pinocchioCharacter);
            characterRepository.save(jiminy);
            characterRepository.save(aliceCharacter);
            characterRepository.save(chessur);
            characterRepository.save(woody);
            characterRepository.save(buzz);
            characterRepository.save(megara);
            characterRepository.save(herculesCharacter);

            filmRepository.save(starWars1);
            filmRepository.save(starWars2);
            filmRepository.save(starWars3);
            filmRepository.save(starWars4);
            filmRepository.save(starWars5);
            filmRepository.save(starWars6);
            filmRepository.save(pinocchio);
            filmRepository.save(cinderella);
            filmRepository.save(alice);
            filmRepository.save(toyStory);
            filmRepository.save(hercules);
            filmRepository.save(tarzan);

            Genre sciencefiction = new Genre("https://i.ibb.co/cTvSMTG/science.jpg", "Science fiction");
            Genre adventure = new Genre("https://i.ibb.co/6PDZZWS/descarga.jpg", "Adventure");
            Genre romantic = new Genre("https://i.ibb.co/ncRB40Y/Romance-Genre.jpg", "Romantic cinema");
            Genre fantasy = new Genre("https://i.ibb.co/swTVXv2/fantasy.jpg", "Fantasy");
            Genre musical = new Genre("https://i.ibb.co/r5K5hQT/musical.webp", "Musical");
            genreRepository.save(sciencefiction);
            genreRepository.save(adventure);
            genreRepository.save(romantic);
            genreRepository.save(fantasy);
            genreRepository.save(musical);

            adminRepository.save(admin);

            starWars1.setGenre(sciencefiction);
            starWars2.setGenre(sciencefiction);
            starWars3.setGenre(sciencefiction);
            starWars4.setGenre(sciencefiction);
            starWars5.setGenre(sciencefiction);
            starWars6.setGenre(sciencefiction);
            pinocchio.setGenre(adventure);
            cinderella.setGenre(romantic);
            alice.setGenre(fantasy);
            toyStory.setGenre(adventure);
            hercules.setGenre(musical);
            tarzan.setGenre(musical);

            filmRepository.save(starWars1);
            filmRepository.save(starWars2);
            filmRepository.save(starWars3);
            filmRepository.save(starWars4);
            filmRepository.save(starWars5);
            filmRepository.save(starWars6);
            filmRepository.save(pinocchio);
            filmRepository.save(cinderella);
            filmRepository.save(alice);
            filmRepository.save(toyStory);
            filmRepository.save(hercules);
            filmRepository.save(tarzan);


            FilmsCharacter filmsCharacterAnakinOne = new FilmsCharacter(starWars1, anakin);
            FilmsCharacter filmsCharacterAnakinTwo = new FilmsCharacter(starWars2, anakin);
            FilmsCharacter filmsCharacterAnakinThree = new FilmsCharacter(starWars3, anakin);
            FilmsCharacter filmsCharacterAnakinFour = new FilmsCharacter(starWars4, anakin);
            FilmsCharacter filmsCharacterAnakinFive = new FilmsCharacter(starWars5, anakin);
            FilmsCharacter filmsCharacterAnakinSix = new FilmsCharacter(starWars6, anakin);
            FilmsCharacter filmsCharacterObiWanOne = new FilmsCharacter(starWars1, obiWan);
            FilmsCharacter filmsCharacterObiWanTwo = new FilmsCharacter(starWars2, obiWan);
            FilmsCharacter filmsCharacterObiWanThree = new FilmsCharacter(starWars3, obiWan);
            FilmsCharacter filmsCharacterObiWanFour = new FilmsCharacter(starWars4, obiWan);
            FilmsCharacter filmsCharacterObiWanFive = new FilmsCharacter(starWars5, obiWan);
            FilmsCharacter filmsCharacterObiWanSix = new FilmsCharacter(starWars6, obiWan);
            FilmsCharacter filmsCharacterPinocchioOne = new FilmsCharacter(pinocchio, pinocchioCharacter);
            FilmsCharacter filmsCharacterPinocchioTwo = new FilmsCharacter(pinocchio, jiminy);
            FilmsCharacter filmsCharacterCinderellaOne = new FilmsCharacter(cinderella, cinderellaCharacter);
            FilmsCharacter filmsCharacterCinderellaTwo = new FilmsCharacter(cinderella, fairy);
            FilmsCharacter filmsCharacterAliceOne = new FilmsCharacter(alice, aliceCharacter);
            FilmsCharacter filmsCharacterAliceTwo = new FilmsCharacter(alice, chessur);
            FilmsCharacter filmsCharacterHerculesOne = new FilmsCharacter(hercules, herculesCharacter);
            FilmsCharacter filmsCharacterHerculesTwo = new FilmsCharacter(hercules, megara);
            FilmsCharacter filmsCharacterToyStoryOne = new FilmsCharacter(toyStory, woody);
            FilmsCharacter filmsCharacterToyStoryTwo = new FilmsCharacter(toyStory, buzz);
            FilmsCharacter filmsCharacterTarzanOne = new FilmsCharacter(tarzan, tarzanCharacter);
            FilmsCharacter filmsCharacterTarzanTwo = new FilmsCharacter(tarzan, terk);


            fimlsCharacterRepositoy.save(filmsCharacterAnakinOne);
            fimlsCharacterRepositoy.save(filmsCharacterAnakinTwo);
            fimlsCharacterRepositoy.save(filmsCharacterAnakinThree);
            fimlsCharacterRepositoy.save(filmsCharacterAnakinFour);
            fimlsCharacterRepositoy.save(filmsCharacterAnakinFive);
            fimlsCharacterRepositoy.save(filmsCharacterAnakinSix);

            fimlsCharacterRepositoy.save(filmsCharacterObiWanOne);
            fimlsCharacterRepositoy.save(filmsCharacterObiWanTwo);
            fimlsCharacterRepositoy.save(filmsCharacterObiWanThree);
            fimlsCharacterRepositoy.save(filmsCharacterObiWanFour);
            fimlsCharacterRepositoy.save(filmsCharacterObiWanFive);
            fimlsCharacterRepositoy.save(filmsCharacterObiWanSix);

            fimlsCharacterRepositoy.save(filmsCharacterPinocchioOne);
            fimlsCharacterRepositoy.save(filmsCharacterPinocchioTwo);
            fimlsCharacterRepositoy.save(filmsCharacterCinderellaOne);
            fimlsCharacterRepositoy.save(filmsCharacterCinderellaTwo);
            fimlsCharacterRepositoy.save(filmsCharacterAliceOne);
            fimlsCharacterRepositoy.save(filmsCharacterAliceTwo);
            fimlsCharacterRepositoy.save(filmsCharacterHerculesOne);
            fimlsCharacterRepositoy.save(filmsCharacterHerculesTwo);
            fimlsCharacterRepositoy.save(filmsCharacterToyStoryOne);
            fimlsCharacterRepositoy.save(filmsCharacterToyStoryTwo);
            fimlsCharacterRepositoy.save(filmsCharacterTarzanOne);
            fimlsCharacterRepositoy.save(filmsCharacterTarzanTwo);





        };

    }

    ;
}
