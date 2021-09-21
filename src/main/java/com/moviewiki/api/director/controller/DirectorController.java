package com.moviewiki.api.director.controller;

import com.moviewiki.api.director.domain.Director;
import com.moviewiki.api.director.service.DirectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DirectorController {

    @Autowired
    private DirectorServiceImpl directorServiceImpl;

    /* 감독 등록 페이지 이동*/
    @GetMapping("/movie/create/director")
    public String directorForm(){
        return "admin/popup_add_director";
    }


    /* 감독 정보 저장 */
    @PostMapping("/movie/create/director")
    public String createDirector(Director director){
        directorServiceImpl.save(director);
        return "admin/popup_dc_director";
    }

    /* 감독 중복체크 페이지 이동 */
    @GetMapping("/movie/read/director")
    public String readDirector(){
        return "admin/popup_dc_director";
    }


    /* 특정 이름의 감독 목록 조회 */
    @PostMapping("/movie/read/director")
    public String readDirector(Director director, Model model){
        List<Director> directorList = directorServiceImpl.findByDirectorName(director.getDirectorName());
        model.addAttribute("directors", directorList);
        return "admin/popup_dc_director";
    }
}
