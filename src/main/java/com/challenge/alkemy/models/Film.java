package com.challenge.alkemy.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String image;
    private String title;
    private LocalDate starDate;
    private double score ;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy="film", fetch=FetchType.EAGER)
    Set<FilmsCharacter> filmsCharacters;


    public Film() {
    }

    public Film(String image, String title, LocalDate starDate, double score) {
        this.image = image;
        this.title = title;
        this.starDate = starDate;
        this.score = score;
    }

    public void addFilmsCharacters(FilmsCharacter filmsCharacter) {
        filmsCharacter.setFilm(this);
        filmsCharacters.add(filmsCharacter);
    }
}

