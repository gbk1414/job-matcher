package com.example.jobmatcher.Model.Entity;

import com.example.jobmatcher.Model.Dto.SignupRequestDto;
import com.example.jobmatcher.Model.Enum.UserRoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Setter
    private String password;
    private UserRoleEnum role;

    public Member(SignupRequestDto signupRequestDto) {
        this.name = signupRequestDto.getName();
        this.email = signupRequestDto.getEmail();
        this.role = signupRequestDto.getRole();
    }

}