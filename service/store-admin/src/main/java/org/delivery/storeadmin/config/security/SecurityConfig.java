package org.delivery.storeadmin.config.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity // security 활성화
public class SecurityConfig {

    private List<String> SWAGGER = List.of(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    );

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()// 디폴트가 활성화임
                .authorizeHttpRequests(it->{
                    it.requestMatchers(
                            // static resource 대하여 permit all(모두 허용)
                            PathRequest.toStaticResources().atCommonLocations()).permitAll()

                            // swagger는 인증 없이 통과
                            .mvcMatchers(SWAGGER.toArray(new String[0])).permitAll()

                            // open-api /** 하위 모든 주소는 인증 없이 통과
                            .mvcMatchers("/open-api/**").permitAll()

                            // 이외의 모든 요청은 인증을 거친다.
                            .anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
