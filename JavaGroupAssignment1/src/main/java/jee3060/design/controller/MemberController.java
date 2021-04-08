package jee3060.design.controller;


import jee3060.design.model.Member;
import jee3060.design.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;


    @GetMapping("/members")
    public String showAllMembers(Model model) {
        log.info(" GetMapping showAllMembers");
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    @GetMapping("/add")
    public String addMember(Model model) {
        log.info(" GetMapping addMember");
        Member member = new Member();
        member.setMemberId(memberService.nextKey());
        model.addAttribute("member", member);
        return "addMember";
    }

    @PostMapping("/add")
    public String addNewMember(@ModelAttribute("") Member member) {
        log.info(" GetMapping addNewMember");
        memberService.create(member);
        return "redirect:/member/members";
    }
}
