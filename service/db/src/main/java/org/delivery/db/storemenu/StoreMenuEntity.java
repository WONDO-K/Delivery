package org.delivery.db.storemenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "store_menu")
public class StoreMenuEntity extends BaseEntity {

    @Column(nullable = false)
    private Long storeId;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(precision = 11,scale = 4,nullable = false)
    private BigDecimal amount;

    @Column(length = 50,nullable = false)
    @Enumerated(EnumType.STRING)
    private StoreMenuStatus status;

    @Column(length = 200,nullable = false)
    private String thumbnailUrl;

    // likeCount가 int인 이유는 디폴트가 0이기 때문, null이 들어간다면 Integer를 사용한다.
    private int likeCount;

    private int sequence;

}
