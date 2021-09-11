package com.moviewiki.api.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR",
        sequenceName = "USER_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "USER_SEQ_GENERATOR")
    private @Column(name = "user_id") String userId;

    private @Column(name = "user_pw") String userPw;
    private @Column(name = "user_name") String userName;
    private @Column(name = "user_birth") Date userBirth;
    private @Column(name = "user_gender") int userGender;
    private @Column(name = "user_mail") String userMail;
    private @Column(name = "user_cellnum") String userCellNum;
    private @Column(name = "user_mbti") String userMbti;
    private @Column(name = "user_admin") int userAdmin;
}
