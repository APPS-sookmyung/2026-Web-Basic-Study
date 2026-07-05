package com.example.demo.Service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member join (Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findMembers () {
        return memberRepository.findAll();
    }

    public Member findOne(Long id) {
        return memberRepository.findById(id).orElseThrow(()->new RuntimeException("회원이 없습니다. id="+id));
    }

    public Member update(Long id, Member newData) {
        Member member = findOne(id);
        member.setName(newData.getName());
        member.setEmail(newData.getEmail());
        return memberRepository.save(member);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
