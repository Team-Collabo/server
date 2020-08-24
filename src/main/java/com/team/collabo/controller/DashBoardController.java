package com.team.collabo.controller;

import com.team.collabo.team.repository.DashBoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashBoardController {

    private final DashBoardRepository dashBoardRepository;

    public DashBoardController(DashBoardRepository dashBoardRepository){
        this.dashBoardRepository =dashBoardRepository;
    }

    @RequestMapping("/dashBoards")
    public String getDashBoards(Model model){

        model.addAttribute("dashBoards", dashBoardRepository.findAll());

        return "dashBoards";

    }
}
