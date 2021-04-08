package jee3060.design.service;


import jee3060.design.model.Member;

import java.util.List;

public interface MemberService {
    public List<Member> findAll();

    public void create(Member member);

    public void save(Member member);

    public int nextKey();
}
