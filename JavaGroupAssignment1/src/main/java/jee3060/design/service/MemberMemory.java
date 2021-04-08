package jee3060.design.service;


import jee3060.design.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MemberMemory implements MemberService {
    private static List<Member> members = new ArrayList<>();

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public synchronized void create(Member member) {
        member.setMemberId(nextKey());
        members.add(member);
    }

    @Override
    public void save(Member member) {
        for (Member existingMember : members) {
            if (member.getMemberId() == existingMember.getMemberId()) {
                members.remove(existingMember);
                break;
            }
        }
        members.add(member);
    }

    @Override
    public synchronized int nextKey() {
        int base = 0, nextId = 0;
        if (members.size() > 0) {
            nextId = members.stream().mapToInt(t -> t.getMemberId()).max().getAsInt();
        } else {
            base = 1000;
        }
        nextId += base;
        nextId++;
        log.info("<><><><><><> key = " + nextId);
        return nextId;
    }
}








