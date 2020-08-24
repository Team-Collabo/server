package com.team.collabo.controller;

import com.team.collabo.team.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository =postRepository;
    }

    @RequestMapping("/posts")
    public String getPosts(Model model){

        model.addAttribute("posts", postRepository.findAll());

        return "posts";

    }
}
