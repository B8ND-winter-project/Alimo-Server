package com.b1nd.alimoserver.domain.auth.adapter.in.api;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignInRequest;
import com.b1nd.alimoserver.domain.auth.application.port.in.SignInUseCase;
import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;
import com.b1nd.alimoserver.global.annotations.WebAdapter;
import com.b1nd.alimoserver.global.response.ResponseData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping(value = "/sign-in")
@RequiredArgsConstructor
public class AuthInController {
    private final SignInUseCase signInUseCase;

    @PostMapping("/dodam")
    public ResponseData<Token> signInWithDodam(
            @RequestBody @Valid SignInRequest request
    ){
        return ResponseData.of(HttpStatus.OK, "login success", signInUseCase.signIn(request));
    }

    @PostMapping("")
    public ResponseData<Token> getSignIn(
            @RequestBody @Valid SignInRequest request
    ){
        return ResponseData.of(HttpStatus.OK, "login success", signInUseCase.signIn(request));
    }
}
