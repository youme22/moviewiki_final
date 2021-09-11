package com.moviewiki.api.user.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "USER_ID")
    private String userId;

    private String userPw;
    private String userName;
    private Date userBirth;
    private int userGender;
    private String userMail;
    private String userCellnum;
    private String userMbti;
    private char user_Admin;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public int getUserGender() { return userGender; }

    public void setUserGender(int userGender) { this.userGender = userGender; }

    public String getUserMail() { return userMail; }

    public void setUserMail(String userMail) { this.userMail = userMail; }

    public String getUserCellnum() { return userCellnum; }

    public void setUserCellnum(String userCellnum) { this.userCellnum = userCellnum; }

    public String getUserMbti() { return userMbti; }

    public void setUserMbti(String userMbti) { this.userMbti = userMbti; }

    public char getUser_Admin() { return user_Admin; }

    public void setUser_Admin(char user_Admin) { this.user_Admin = user_Admin; }

}
