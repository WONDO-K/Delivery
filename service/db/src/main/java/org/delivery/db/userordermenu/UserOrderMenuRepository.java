package org.delivery.db.userordermenu;

import org.delivery.db.userorder.enums.UserOrderStatus;
import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderMenuRepository extends JpaRepository<UserOrderMenuEntity,Long> {

    // select * from user_order_menu where user_order_id = ? status = ?
    List<UserOrderMenuEntity> findAllByUserOrderIdAndStatus(Long userOrderId, UserOrderMenuStatus status); // 주문 아이디에 해당되는 등록된 모든 메뉴 리스트 리턴
}
