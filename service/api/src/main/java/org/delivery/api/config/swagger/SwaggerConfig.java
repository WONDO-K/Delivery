package org.delivery.api.config.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // 스프링이 ObjectMapper라는 빈을 찾아서 objectMapper에 넣어서 호출해 준다.
    // 이 빈은 우리가 ObjectMapper를 만들 때 넣어 놓았던 것이 SwaggerConfig로 들어오게 된다.
    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper) {
        return new ModelResolver(objectMapper);
    }
}
