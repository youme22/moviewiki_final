package com.moviewiki.api.actor.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ACTORS")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "ACTOR_ID")
    private String actorId;

    private String actorName;
    private String actorProfile;

    public String getActorId() { return actorId; }

    public void setActorId(String actorId) { this.actorId = actorId; }

    public String getActorName() { return actorName; }

    public void setActorName(String actorName) { this.actorName = actorName; }

    public String getActorProfile() { return actorProfile; }

    public void setActorProfile(String actorProfile) { this.actorProfile = actorProfile; }
}
