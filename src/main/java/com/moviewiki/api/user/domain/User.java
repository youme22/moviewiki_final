package com.moviewiki.api.user.domain;

        import java.util.Date;

        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import javax.persistence.Table;
        import javax.persistence.Temporal;
        import javax.persistence.TemporalType;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Table(name="Users")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_PW")
    private String userPw;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_BIRTH")
    @DateTimeFormat(pattern = "yyMMdd")
    private Date userBirth;

    @Column(name = "USER_GENDER", columnDefinition = "number")
    private int userGender;

    @Column(name = "USER_MAIL")
    private String userMail;

    @Column(name = "USER_CELLNUM")
    private String userCellNum;

    @Column(name = "USER_MBTI")
    private String userMbti;

    @Column(name = "USER_ADMIN", columnDefinition = "char(1)")
    private boolean userAdmin;

}