package org.delivery.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        // run이라는 static 메서드를 생성하고 이를 호출하여 사용한다.
        SpringApplication.run(ApiApplication.class,args);
    }
}
