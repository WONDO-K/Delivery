package org.delivery.api.domain.userordermenu.service;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.userorder.UserOrderEntity;
import org.delivery.db.userorder.enums.UserOrderStatus;
import org.delivery.db.userordermenu.UserOrderMenuEntity;
import org.delivery.db.userordermenu.UserOrderMenuRepository;
import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserOrderMenuService {

    private final UserOrderMenuRepository userOrderMenuRepository;

    public List<UserOrderMenuEntity> getUserOrderMenu(Long userOrderId){
        // null 체크를 굳이 안한다
        // DB에 컬럼이 null이 있을 수 있고 null이면 select가 안될 것이기 때문
        return userOrderMenuRepository.findAllByUserOrderIdAndStatus(userOrderId, UserOrderMenuStatus.REGISTERED);
    }

    public UserOrderMenuEntity order(UserOrderMenuEntity userOrderMenuEntity){
        return Optional.ofNullable(userOrderMenuEntity)
                .map(it -> {
                    it.setStatus(UserOrderMenuStatus.REGISTERED);
                    return userOrderMenuRepository.save(it);
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
