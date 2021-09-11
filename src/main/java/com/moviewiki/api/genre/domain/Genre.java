package com.moviewiki.api.genre.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "GENRES")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "GENRE_ID")
    private String genreId;

    private String genreName;

    public String getGenreId() { return genreId; }

    public void setGenreId(String genreId) { this.genreId = genreId; }

    public String getGenreName() { return genreName; }

    public void setGenreName(String genreName) { this.genreName = genreName; }
}
