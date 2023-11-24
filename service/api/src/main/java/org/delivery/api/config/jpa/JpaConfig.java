package org.delivery.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "org.delivery.db") // .entity 파일을 해당 경로에서 탐색
@EnableJpaRepositories(basePackages = "org.delivery.db") // 해당 경로 하위의 Repository를 사용하겠다는 의미
public class JpaConfig {
}
