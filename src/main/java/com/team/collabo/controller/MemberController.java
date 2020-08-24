package com.team.collabo.controller;

import com.team.collabo.team.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository){
        this.memberRepository =memberRepository;
    }

    @RequestMapping("/members")
    public String getMembers(Model model){

        model.addAttribute("members", memberRepository.findAll());

        return "members";

    }
}
