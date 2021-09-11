package com.moviewiki.api.movie.controller;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movie.domain.MovieForm;
import com.moviewiki.api.movie.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Controller
public class MovieController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    /* 영화 등록 페이지 이동 */
    @GetMapping("/movie/create")
    public String movieForm(){
        return "createMovie";
    }

    /* 영화 정보 저장 */
    @PostMapping("/movie/create")
    public String createMovie(MovieForm form){
        Movie movie = new Movie(form.getFilmRating(), form.getMovieName(), form.getMovieOgName(), form.getMovieProfile(), Date.valueOf(form.getReleaseDate())
                                , parseInt(form.getRunningTime()), form.getSummary(), 0, 0, 0);

        movieServiceImpl.save(movie);
        return "redirect:/";
    }

    /* 영화 목록 조회 */
    @GetMapping("/movie/read/{movieId}")
    @ResponseBody
    public Optional<Movie> readMovie(@PathVariable(name = "movieId") Long movieId){
        Optional<Movie> movie = movieServiceImpl.findById(movieId);
        return movie;
    }

    /* 모든 영화 조회 */
    @GetMapping("/movie/read")
    @ResponseBody
    public List<Movie> readAllMovie(){
        List<Movie> movieList = movieServiceImpl.findAll();
        return movieList;
    }

}
