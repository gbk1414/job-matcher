package com.example.jobmatcher.Model.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    @Schema(description = "이메일", example = "admin123@naver.com")
    private String email;

    @Schema(description = "비밀번호", example = "StrongP@ss123")
    private String password;
}
