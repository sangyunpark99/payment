package com.example.payment.member.dto.response;

public record MemberCreateResponse(Long id) {

    public MemberCreateResponse(final Long id) {
        this.id = id;
    }
}
