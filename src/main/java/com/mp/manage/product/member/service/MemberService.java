package com.mp.manage.product.member.service;

import com.mp.manage.product.member.dto.MemberDto;
import com.mp.manage.product.member.repository.MemberRepository;
import com.mp.manage.product.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(MemberDto memberDto) {
        Member member = memberDto.toEntity();
        return memberRepository.save(member).getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    public List<Member> findAllByName(String name) {
        return memberRepository.findAllByName(name);
    }
}
