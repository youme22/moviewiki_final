package com.moviewiki.api.prefGenre.controller;

import com.moviewiki.api.prefGenre.domain.PrefGenre;
import com.moviewiki.api.prefGenre.service.PrefGenreServiceImpl;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PrefGenreController {

    @Autowired
    PrefGenreServiceImpl prefGenreServiceImpl;
    @Autowired
    UserManagementServiceImpl userManagementService;

    // 추천 Test1
//    @GetMapping("/prefGenre")
//    public String prefGenreList(Model model){
//        List<PrefGenre> prefGenreList = prefGenreServiceImpl.findByUser();
//        model.addAttribute("prefGenres", prefGenreList);
//        return "readPrefGenre";
//    }

    // 추천 Test2
    @GetMapping("prefGenre/{userId}")
    @ResponseBody
    public List<PrefGenre> readPrefGenreByUser(@PathVariable(name = "userId") String userId){
        User user = userManagementService.getUser(userId);
        List<PrefGenre> prefGenre = prefGenreServiceImpl.findByUser(user);
        return prefGenre;
    }

}
