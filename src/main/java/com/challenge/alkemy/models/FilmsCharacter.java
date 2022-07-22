package com.challenge.alkemy.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity

public class FilmsCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="film_id")
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="character_id")
    private Character character;

    public FilmsCharacter() {
    }

    public FilmsCharacter(Film film, Character character) {
        this.film = film;
        this.character = character;
    }

}
