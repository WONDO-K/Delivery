package org.delivery.api.domain.userorder.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderRequest {
    
    // 주문
    // 특정 사용자가, 특정 메뉴를 주문
    // 특정 사용자 = 로그인된 세션에 들어있는 사용자
    // 특정 메뉴 id

    // 사용자는 로그인된 사용자를 쓰기 때문에 별도로 받아올 필요가 없다.
    // 어떠한 메뉴를 주문하겠다 정도만 있으면 된다.
    @NotNull
    private List<Long> storeMenuIdList;
    
}
