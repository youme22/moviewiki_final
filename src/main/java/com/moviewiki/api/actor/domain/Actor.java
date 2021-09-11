package com.moviewiki.api.actor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "ACTOR_SEQ_GENERATOR",
        sequenceName = "ACTOR_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Table(name="actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "ACTOR_SEQ_GENERATOR")
    @Column(name = "actor_id")
    private Long actorId;

    private @Column(name = "actor_name")String actorName;
    private @Column(name = "actor_profile") String actorProfile;
}
