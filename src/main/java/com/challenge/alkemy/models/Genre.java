package com.challenge.alkemy.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String image;
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    private Set<Film> films;

    public Genre() {
    }

    public Genre(String image,String name) {
        this.image = image;
        this.name = name;
    }

    public void addFilm(Film film) {
        film.setGenre(this);
        films.add(film);
    }

}
