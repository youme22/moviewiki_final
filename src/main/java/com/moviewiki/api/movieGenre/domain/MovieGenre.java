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
@SequenceGenerator(
		name = "MG_SEQ_GENERATOR",
		sequenceName = "MG_SEQ",
		initialValue = 1,
		allocationSize = 1)
@Table(name = "MOVIE_GENRE")
public class MovieGenre implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "MG_SEQ_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@ManyToOne(targetEntity = Genre.class)
	@JoinColumn(name = "GENRE_ID")
	private Genre genre;

	@ManyToOne(targetEntity = Movie.class)
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;
}
