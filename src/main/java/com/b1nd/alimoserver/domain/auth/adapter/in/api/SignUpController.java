package com.b1nd.alimoserver.domain.auth.adapter.in.api;

import com.b1nd.alimoserver.domain.auth.adapter.in.api.dto.request.SignUpRequest;
import com.b1nd.alimoserver.domain.auth.application.domain.model.Token;
import com.b1nd.alimoserver.domain.auth.application.port.in.SignUpUseCase;
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
@RequestMapping(value = "/sign-up")
@RequiredArgsConstructor
public class SignUpController {
    private final SignUpUseCase signUpUseCase;

    @PostMapping
    public ResponseData<Token> signUpParent(
            @RequestBody @Valid SignUpRequest request
    ){
        return ResponseData.of(HttpStatus.OK, "login success", signUpUseCase.signUp(request));
    }
}
