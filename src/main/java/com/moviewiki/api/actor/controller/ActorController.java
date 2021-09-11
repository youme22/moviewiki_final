package com.moviewiki.api.actor.controller;

import com.moviewiki.api.actor.domain.Actor;
import com.moviewiki.api.actor.service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ActorController {

    @Autowired
    private ActorServiceImpl actorServiceImpl;

    @GetMapping("/movie/create/actor")
    public String ActorForm(){
        return "createActor";
    }

    @PostMapping("/movie/create/actor")
    public String createActor(Actor actor){
        actorServiceImpl.save(actor);
        return "redirect:/";
    }

   /* @GetMapping("/movie/read/actor/{actorName}")
    public String findByActorName(@PathVariable(name="actorName") String actorName, Model model){
        List<Actor> actorList = actorServiceImpl.findByActorName(actorName);
        model.addAttribute("actors", actorList);
        return "readActor";
    }*/

    @GetMapping("/movie/read/actor")
    public String readActor(){
        return "readActor";
    }

    @PostMapping("/movie/read/actor")
    public String readActor(Actor actor, Model model){
        List<Actor> actorList = actorServiceImpl.findByActorName(actor.getActorName());
        model.addAttribute("actors", actorList);
        return "readActor";
    }
}