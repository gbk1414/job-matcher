package com.example.jobmatcher.Service;

import com.example.jobmatcher.Model.Dto.SignupRequestDto;
import com.example.jobmatcher.Model.Entity.Member;
import com.example.jobmatcher.Model.Entity.SuccessResult;
import com.example.jobmatcher.Model.Repository.MemberRepository;
import com.example.jobmatcher.Security.JwtUtil.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SuccessResult signup(SignupRequestDto signupRequestDto) {
        String email = signupRequestDto.getEmail();
        String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());

        Optional<Member> checkEmail = memberRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            return new SuccessResult(false, "중복된 Email 입니다.");
        }

        Member member = new Member(signupRequestDto);
        member.setPassword(encodedPassword);
        memberRepository.save(member);

        return new SuccessResult(true, "회원 가입 성공");
    }
}