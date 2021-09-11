package com.moviewiki.api.director.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
		name = "DIRECTOR_SEQ_GENERATOR",
		sequenceName = "DIRECTOR_SEQ",
		initialValue = 1,
		allocationSize = 1)
@Table(name="DIRECTORS")
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE
			, generator = "DIRECTOR_SEQ_GENERATOR")
	private @Column(name = "DIRECTOR_ID") Long directorId;

	private @Column(name = "director_name") String directorName;
	private @Column(name = "director_profile") String directorProfile;
}