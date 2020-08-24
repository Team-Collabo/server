package com.team.collabo.controller;

import com.team.collabo.team.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository){
        this.teamRepository =teamRepository;
    }

    @RequestMapping("/teams")
    public String getTeams(Model model){

        model.addAttribute("teams", teamRepository.findAll());

        return "teams";

    }
}
