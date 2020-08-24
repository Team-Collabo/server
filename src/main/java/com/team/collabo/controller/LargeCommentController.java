package com.team.collabo.controller;

import com.team.collabo.team.repository.LargeCommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LargeCommentController {

    private final LargeCommentRepository largeCommentRepository;

    public LargeCommentController(LargeCommentRepository largeCommentRepository){
        this.largeCommentRepository = largeCommentRepository;
    }

    @RequestMapping("/largeComments")
    public String getLargeComments(Model model){

        model.addAttribute("largeComments", largeCommentRepository.findAll());

        return "largeComments";

    }
}
