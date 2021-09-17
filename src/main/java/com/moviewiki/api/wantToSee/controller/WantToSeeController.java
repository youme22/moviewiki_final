package com.moviewiki.api.wantToSee.controller;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movie.service.MovieServiceImpl;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementServiceImpl;
import com.moviewiki.api.wantToSee.domain.WantToSee;
import com.moviewiki.api.wantToSee.service.WantToSeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.lang.Long.parseLong;

@Controller
public class WantToSeeController {

    @Autowired
    private WantToSeeServiceImpl wantToSeeServiceImpl;
    @Autowired
    private MovieServiceImpl movieServiceImpl;
    @Autowired
    private UserManagementServiceImpl userManagementService;


    /* 보고 싶은 영화 등록 */
    @GetMapping("/want/create")
    public String wantForm(){
        return "member/want_add";
    }

    /* 보고 싶은 영화 추가 */
    @PostMapping("/want/create")
    public String createWant(HttpServletRequest request){
        String userId = request.getParameter("userId");
        Long movieId = parseLong(request.getParameter("movieId"));

        Movie movie = movieServiceImpl.findByMovieId(movieId);
        User user = userManagementService.getUser(userId);

        wantToSeeServiceImpl.save(user, movie);
        return "admin_movie";
    }

    /* 특정 사용자의 보고픈 영화 조회 */
    @GetMapping("/want/read/{userId}")
    @ResponseBody
    public List<WantToSee> readWantByUser(@PathVariable(name = "userId") String userId){

        User user = userManagementService.getUser(userId);
        List<WantToSee> want = wantToSeeServiceImpl.findByUser(user);
        return want;
    }

    /* 보고픈 영화 삭제 */
    @GetMapping("/want/delete")
    public String deleteWant(@RequestParam("userId") String userId, @RequestParam("movieId") Long movieId) {

        User user = userManagementService.getUser(userId);
        Movie movie = movieServiceImpl.findByMovieId(movieId);

        wantToSeeServiceImpl.deleteWantToSee(user, movie);

        return "redirect:/want/read/" + userId;
    }
}
