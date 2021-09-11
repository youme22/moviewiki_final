package com.moviewiki.api.nation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "NATIONS")
public class Nation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "NATION_ID")
    private String nationId;

    private String nationName;

    public String getNationId() { return nationId; }

    public void setNationId(String nationId) { this.nationId = nationId; }

    public String getNationName() { return nationName; }

    public void setNationName(String nationName) { this.nationName = nationName; }

}
