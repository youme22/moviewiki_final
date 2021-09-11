package com.moviewiki.api.movieGenre.domain;

import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MOVIE_GENRE")
public class MovieGenre implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;

		@ManyToOne(targetEntity = Genre.class)
		@JoinColumn(name = "GENRE_ID")
		private Genre genre;

		@ManyToOne(targetEntity = Movie.class)
		@JoinColumn(name = "MOVIE_ID")
		private Movie movie;
}
