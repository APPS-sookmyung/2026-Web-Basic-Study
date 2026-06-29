package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Member join(@RequestBody Member member) {
        return memberService.join(member);
    }

    @GetMapping
    public List<Member> findAll() {
        return memberService.findMembers();
    }

    @GetMapping("/{id}")
    public Member findOne(@PathVariable Long id) {
        return memberService.findOne(id);
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member member) {
        return memberService.update(id, member);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        memberService.delete(id);
        return "삭제 완료: id=" + id;
    }

}