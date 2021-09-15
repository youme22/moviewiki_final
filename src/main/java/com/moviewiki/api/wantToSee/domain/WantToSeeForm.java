package com.moviewiki.api.wantToSee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WantToSeeForm {

    private String userId;
    private String movieId;

}
