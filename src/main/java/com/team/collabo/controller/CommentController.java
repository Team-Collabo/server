package com.team.collabo.controller;

import com.team.collabo.team.repository.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository){
        this.commentRepository =commentRepository;
    }

    @RequestMapping("/comments")
    public String getComments(Model model){

        model.addAttribute("comments", commentRepository.findAll());

        return "comments";

    }
}
