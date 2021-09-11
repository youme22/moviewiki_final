package com.moviewiki.api.actorFilmography.domain;

import com.moviewiki.api.actor.domain.Actor;
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
		name = "AF_SEQ_GENERATOR",
		sequenceName = "AF_SEQ",
		initialValue = 1,
		allocationSize = 1)
@Table(name = "ACTOR_FILMOGRAPHY")
public class ActorFilmography implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "AF_SEQ_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@ManyToOne(targetEntity = Actor.class)
	@JoinColumn(name = "ACTOR_ID")
	private Actor actor;

	@ManyToOne(targetEntity = Movie.class)
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "CHARACTERS")
	private String characters;

}