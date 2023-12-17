package org.delivery.db.userordermenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;
import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "user_order_menu")
public class UserOrderMenuEntity extends BaseEntity {

    @Column(nullable = false)
    // 이렇게 사이즈나 속성을 표기하는 이유는 H2 DB를 로컬 혹은 개발 검증 또는 테스트하는 쪽에서 사용할 때에 하이버네이트가
    // 자동으로 테이블을 만들고 드랍하는데 이때 컬럼의 사이즈나 속성을 보고 테이블을 생성하게 된다.
    // 그래서 실제로 운영 환경의 DB 테이블의 속성과 동일하게 맞춰나야 테스트 할 때 특정 상황을 예측할 수 있다.
    private Long userOrderId; // 1:n

    @Column(nullable = false)
    private Long storeMenuId; // 1:n

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private UserOrderMenuStatus status;
}
