package com.example.jobmatcher.Model.Dto;


import com.example.jobmatcher.Model.Enum.UserRoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class SignupRequestDto {

    @Email
    @Schema(description = "이메일", example = "admin123@naver.com")
    private String email;

    @Schema(description = "이름", example = "steeve")
    private String name;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}$",
            message = "대문자, 소문자, 특수문자, 숫자 포함 8~15자리.")
    @Schema(description = "8자~15자 이내의 비밀번호", example = "StrongP@ss123")
    private String password;

    @Schema(description = "사용자 역할", example = "ADMIN")
    private UserRoleEnum role;
}