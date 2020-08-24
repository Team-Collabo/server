package com.team.collabo.controller;

import com.team.collabo.team.model.DashBoardBookmark;
import com.team.collabo.team.repository.DashBoardBookmarkRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashBoardBookmarkController {

    private final DashBoardBookmarkRepository dashBoardBookmarkRepository;

    public DashBoardBookmarkController(DashBoardBookmarkRepository dashBoardbookmarkRepository){
        this.dashBoardBookmarkRepository =dashBoardbookmarkRepository;
    }

    @RequestMapping("/dashBoardBookmarks")
    public String getDashBoardBookmarks(Model model){

        model.addAttribute("dashBoardBookmarks", dashBoardBookmarkRepository.findAll());

        return "dashBoardBookmarks";

    }
}
