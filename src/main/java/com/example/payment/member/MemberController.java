package com.example.payment.member;

import static com.example.payment.global.error.ErrorCode.CHANE_PASSWORD_SUCCESS;

import com.example.payment.member.dto.MemberDto;
import com.example.payment.member.dto.request.MemberCreateRequest;
import com.example.payment.member.dto.request.PasswordUpdateRequest;
import com.example.payment.member.dto.response.MemberCreateResponse;
import com.example.payment.member.dto.response.PasswordUpdateResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/members")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberCreateResponse> createMember(@Valid @RequestBody MemberCreateRequest request) {
        MemberCreateResponse response = new MemberCreateResponse(memberService.createMember(request));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> findMember(@PathVariable Long id) {
        MemberDto response = memberService.findMember(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/password")
    public ResponseEntity<PasswordUpdateResponse> updatePassword(@Valid @RequestBody PasswordUpdateRequest request) {
        memberService.changePassword(request);
        return ResponseEntity.ok(new PasswordUpdateResponse(CHANE_PASSWORD_SUCCESS.getMessage()));
    }
}