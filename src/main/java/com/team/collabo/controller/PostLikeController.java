package com.team.collabo.controller;

import com.team.collabo.team.repository.PostLikeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostLikeController {

    private final PostLikeRepository postLikeRepository;

    public PostLikeController(PostLikeRepository postLikeRepository){
        this.postLikeRepository =postLikeRepository;
    }

    @RequestMapping("/postLikes")
    public String getPostLikes(Model model){

        model.addAttribute("postLikes", postLikeRepository.findAll());

        return "postLikes";

    }
}
