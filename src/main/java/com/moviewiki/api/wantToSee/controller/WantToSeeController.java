package com.moviewiki.api.wantToSee.controller;

import com.moviewiki.api.movie.domain.Movie;
import com.moviewiki.api.movie.service.MovieServiceImpl;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementServiceImpl;
import com.moviewiki.api.wantToSee.domain.WantToSee;
import com.moviewiki.api.wantToSee.domain.WantToSeeForm;
import com.moviewiki.api.wantToSee.service.WantToSeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /* [미완성!!!] => 보고 싶은 영화 추가 */
    @PostMapping("/want/create")
    public String createWant(WantToSeeForm wantToSeeForm){
        WantToSee wantToSee = new WantToSee();
        Movie movie = movieServiceImpl.findByMovieId(parseLong(wantToSeeForm.getMovieId()));
        User user = userManagementService.getUser(wantToSeeForm.getUserId());
        wantToSee.setUser(user);
        wantToSee.setMovie(movie);
        wantToSeeServiceImpl.save(wantToSee);
        return "admin/admin_movie";
    }

    /* [미완성!!!] => 특정 사용자의 보고픈 영화 조회 */
    @GetMapping("/want/read")
    @ResponseBody
    public List<WantToSee> readWantByUser(WantToSee wantToSee){
        List<WantToSee> want = wantToSeeServiceImpl.findByUser(wantToSee.getUser().getUserId());
        return want;
    }
}
