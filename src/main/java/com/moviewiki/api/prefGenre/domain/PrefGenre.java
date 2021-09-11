package com.moviewiki.api.prefGenre.domain;

import com.moviewiki.api.genre.domain.Genre;
import com.moviewiki.api.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PREF_GENRES")
@IdClass(PrefGenrePK.class)
public class PrefGenre {

    @ManyToOne
    @JoinColumn(name ="USER_ID")
    @Id
    private User user;

    @ManyToOne
    @JoinColumn(name ="GENRE_ID")
    @Id
    private Genre genre;

    private double genrePoint;
    private int genreReviewCount;
    private Date genreReviewDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getGenrePoint() {
        return genrePoint;
    }

    public void setGenrePoint(double genrePoint) {
        this.genrePoint = genrePoint;
    }

    public int getGenreReviewCount() {
        return genreReviewCount;
    }

    public void setGenreReviewCount(int genreReviewCount) {
        this.genreReviewCount = genreReviewCount;
    }

    public Date getGenreReviewDate() {
        return genreReviewDate;
    }

    public void setGenreReviewDate(Date genreReviewDate) {
        this.genreReviewDate = genreReviewDate;
    }
}
