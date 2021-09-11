package com.moviewiki.api.nation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="nations")
public class Nation {

    @Id
    private @Column(name = "nation_id") String nationId;

    private @Column(name = "nation_name") String nationName;
}
