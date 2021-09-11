package com.moviewiki.api.movieNation.domain;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.nation.domain.Nation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MOVIE_NATION")
public class MovieNation implements Serializable {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;

		@ManyToOne(targetEntity = Nation.class)
		@JoinColumn(name = "NATION_ID")
		private Nation nation;

		@ManyToOne(targetEntity = Movie.class)
		@JoinColumn(name = "MOVIE_ID")
		private Movie movie;

}
