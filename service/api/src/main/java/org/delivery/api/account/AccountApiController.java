package org.delivery.api.account;

import lombok.RequiredArgsConstructor;
import org.delivery.api.account.model.AccountMeResponse;
import org.delivery.api.common.api.Api;
import org.delivery.db.account.AccountEntity;
import org.delivery.db.account.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    // 모듈을 분리하여 사용하다보니 db에 있는 Repository가 스프링 빈으로 등록이 되지 않았다.
    // 그래서 JpaConfig를 통해 설정을 잡아준다.
    private final AccountRepository accountRepository;

    @GetMapping("/me")
    public Api<AccountMeResponse> me(){
        var response = AccountMeResponse.builder()
                .name("홍길동")
                .email("a@gmail.com")
                .registeredAt(LocalDateTime.now())
                .build();
        return Api.ok(response);
    }
}
