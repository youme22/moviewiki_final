package com.moviewiki.api.genre.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="genres")
public class Genre {
    @Id
    private @Column(name = "genre_id") String genreId;

    private @Column(name = "genre_name") String genreName;
}
