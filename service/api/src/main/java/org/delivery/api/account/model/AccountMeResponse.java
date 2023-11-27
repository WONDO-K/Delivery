package org.delivery.api.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) // objectMapper를 통해 정의해서 필요 없어짐
public class AccountMeResponse {

    private String email;

    private String name;

    private LocalDateTime registeredAt;
}
