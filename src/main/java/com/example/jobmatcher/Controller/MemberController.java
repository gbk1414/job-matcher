package com.example.jobmatcher.Controller;

import com.example.jobmatcher.Model.Dto.SignupRequestDto;
import com.example.jobmatcher.Model.Entity.SuccessResult;
import com.example.jobmatcher.Service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@Tag(name = "회원 관리")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "회원가입 할 때 사용하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "회원가입 성공",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"message\": \"회원가입이 성공적으로 완료되었습니다.\"}"))),
            @ApiResponse(responseCode = "400", description = "충돌 - 이미 존재하는 이메일",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"error\": \"해당 이메일은 이미 등록되어 있습니다.\"}")))
    })
    public ResponseEntity<String> signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
        SuccessResult signupResult = memberService.signup(signupRequestDto);
        if (signupResult.isSuccess()) {
            return ResponseEntity.ok().body(signupResult.getMessage());
        } else {
            return ResponseEntity.badRequest().body(signupResult.getMessage());
        }
    }
}
