package com.mp.manage.product.domain.dto;

import com.mp.manage.product.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private String name;
    private String address;
    private String phoneNum;

    public Member toEntity(){
        return Member.builder()
                .name(this.name)
                .address(this.address)
                .phoneNum(this.phoneNum)
                .build();
    }
}
