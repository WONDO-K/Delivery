package org.delivery.api.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service // 이 어노테이션을 통해 Spring에서 자동적으로 이 어노테이션을 감지할 수 있다.
public @interface Business { // @Business가 달린 클래스는 비즈니스 로직을 처리한다는 것을 명시하기 위한 어노테이션

    @AliasFor(annotation = Service.class)
    String value() default "";
}
