package com.mp.manage.product.controller.Member;

import com.mp.manage.product.domain.member.Member;
import com.mp.manage.product.domain.dto.MemberDto;
import com.mp.manage.product.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor// final 붙은 애들을 매변수로 가지는 생성자
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public List<Member> memberList() {
        List<Member> members = memberService.findMembers();
        return members;
    }

    @GetMapping("/member/{id}")
    public Member findMemberId(@PathVariable Long id) {
        Member member = memberService.findById(id);
        return member;
    }

    @PostMapping("/member/join")
    public ResponseEntity memberJoin(@RequestBody MemberDto memberDto) {
        memberService.join(memberDto);
        return ResponseEntity.ok().build();
    }
}