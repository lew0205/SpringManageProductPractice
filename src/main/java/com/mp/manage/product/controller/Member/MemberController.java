package com.mp.manage.product.controller.Member;

import com.mp.manage.product.domain.member.Member;
import com.mp.manage.product.domain.member.MemberForm;
import com.mp.manage.product.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor// final 붙은 애들을 매변수로 가지는 생성자
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/list")
    @ResponseBody
    public List<Member> memberList(Model model) {
        List<Member> members = memberService.findMembers();
        return members;
    }

    @GetMapping("/member/join")
    public String memberForm() {
        return "member/memberForm";
    }

    @PostMapping("/member/join")
    public String memberJoin(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(form.getAddress());
        member.setPhoneNum(form.getPhoneNum());

        memberService.joinMember(member);

        return "redirect:/";
    }
}