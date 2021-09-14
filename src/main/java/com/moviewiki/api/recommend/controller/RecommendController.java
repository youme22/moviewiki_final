package com.moviewiki.api.recommend.controller;

import com.moviewiki.api.recommend.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RecommendController {

    private RecommendService recommendService;

    @Autowired
    public RecommendController(RecommendService recommendService) {

        this.recommendService = recommendService;

    }

}
