package jee3060.design.service;

import jee3060.design.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MemberInitialization {
    @Autowired
    MemberService memberService;

    int[] ids = {101, 102, 103};
    String[] firstNames = {"Kat", "Win", "Alex"};
    String[] lastNames = {"Schmidt", "Chhor", "Steinberg"};
    String[] emails = {"kschmidt1305@conestogac.on.ca", "wchhor9294@conestogac.on.ca", "asteinberg5935@conestogac.on.ca"};


    @PostConstruct
    public void initialize() {
        for (int i = 0; i < ids.length; i++) {
            Member member = new Member();
            member.setMemberId(ids[i]);
            member.setFirstName(firstNames[i]);
            member.setLastName(lastNames[i]);
            member.setEmail(emails[i]);

            memberService.create(member);
        }
    }
}
