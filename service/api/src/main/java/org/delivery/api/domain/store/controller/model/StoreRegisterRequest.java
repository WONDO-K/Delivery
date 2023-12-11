package org.delivery.api.domain.store.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.store.enums.StoreCategory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreRegisterRequest {

    @NotBlank // 문자열 -> "". " " , null, 빈문자,블랭크,널값 모두 불가능
    private String name;

    @NotBlank
    private String address;

    @NotNull // enum 타입이기 때문에 null이 들어오면 안된다. // enum으로 맵핑해서 문자로 볼 수 없기 떄문에 NotNull 사용
    private StoreCategory storeCategory;

    @NotBlank
    private String thumbnailUrl;

    @NotNull
    private BigDecimal minimumAmount;

    @NotNull
    private BigDecimal minimumDeliveryAmount;

    @NotBlank
    private String phoneNumber;

}
