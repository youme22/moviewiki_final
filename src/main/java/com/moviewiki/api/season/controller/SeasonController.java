package com.moviewiki.api.season.controller;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movie.service.MovieServiceImpl;
import com.moviewiki.api.season.domain.Season;
import com.moviewiki.api.season.service.SeasonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@Controller
public class SeasonController {

    @Autowired
    SeasonServiceImpl seasonServiceImpl;

    @Autowired
    MovieServiceImpl movieServiceImpl;

    // 계절점수 등록 페이지 이동
    @GetMapping("/season/create")
    public String createSeason(){
        return "member/season_add";
    }

    // 영화에 대한 계절점수 등록
    @PostMapping("/season/create")
    public String createSeason(HttpServletRequest request){
        Long movieId = parseLong(request.getParameter("movieId"));
        String seasonName = request.getParameter("seasonName");
        int seasonPoint = parseInt(request.getParameter("seasonPoint"));

        Movie movie = movieServiceImpl.findByMovieId(movieId);

        seasonServiceImpl.save(movie, seasonName, seasonPoint);

        return "admin_movie";
    }

    // 특정 영화의 계절점수 조회
    @GetMapping("/season/read/{seasonName}")
    @ResponseBody
    public List<Season> readSeason(@PathVariable String seasonName){
        return seasonServiceImpl.findBySeasonNameOrderBySeasonPointDesc(seasonName);
    }

}
