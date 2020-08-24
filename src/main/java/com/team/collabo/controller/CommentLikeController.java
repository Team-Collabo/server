package com.team.collabo.controller;

import com.team.collabo.team.repository.CommentLikeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentLikeController {

    private final CommentLikeRepository commentLikeRepository;

    public CommentLikeController(CommentLikeRepository commentLikeRepository){
        this.commentLikeRepository =commentLikeRepository;
    }

    @RequestMapping("/commentLikes")
    public String getCommentLikes(Model model){

        model.addAttribute("commentLikes", commentLikeRepository.findAll());

        return "commentLikes";

    }
}
