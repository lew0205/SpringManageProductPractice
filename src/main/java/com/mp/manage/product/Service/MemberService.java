package com.mp.manage.product.Service;

import com.mp.manage.product.Repository.MemberRepository;
import com.mp.manage.product.domain.Member;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long joinMember(Member member) {
        memberRepository.save(member);
        return member.getId();
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
