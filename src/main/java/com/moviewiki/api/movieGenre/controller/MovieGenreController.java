package com.moviewiki.api.movieGenre.controller;

import com.moviewiki.api.movieGenre.domain.MovieGenre;
import com.moviewiki.api.movieGenre.service.MovieGenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

;

@Controller
public class MovieGenreController {

    @Autowired
    private MovieGenreServiceImpl movieGenreServiceimpl;

    // Genre
    @GetMapping("/movieGenre/read/genre")
    public String readGenre(){
        return "readMovieGenre";
    }

    @PostMapping("/movieGenre/read/genre")
    public String readGenreId(MovieGenre movieGenre, Model model) {
        List<MovieGenre> genreList2 = movieGenreServiceimpl.findMovieGenreByGenre(movieGenre.getGenre());
        model.addAttribute("genres2",genreList2);
        return "readMovieGenre";
    }

    // Movie
    @GetMapping("/movieGenre/read/movie")
    public String readMovieGenre(){
        return "readMovieGenre";
    }

    @PostMapping("/movieGenre/read/movie")
    public String readMovieGenre(MovieGenre movieGenre, Model model) {
        List<MovieGenre> movieList2 = movieGenreServiceimpl.findMovieGenreByMovie(movieGenre.getMovie());
//        List<MovieGenre> genreList2 = movieGenreServiceimpl.findMovieGenreById(movieGenre.getMovieId());
        model.addAttribute("movies2",movieList2);
//        model.addAttribute("genres2",genreList2);
        return "readMovieGenre";

    }


}
