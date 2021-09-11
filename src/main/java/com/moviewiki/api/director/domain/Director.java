package com.moviewiki.api.director.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DIRECTORS")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "DIRECTOR_ID")
    private String directorId;

    private String directorName;
    private String directorProfile;

    public String getDirectorId() { return directorId; }

    public void setDirectorId(String directorId) { this.directorId = directorId; }

    public String getDirectorName() { return directorName; }

    public void setDirectorName(String directorName) { this.directorName = directorName; }

    public String getDirectorProfile() { return directorProfile; }

    public void setDirectorProfile(String directorProfile) { this.directorProfile = directorProfile; }
}
