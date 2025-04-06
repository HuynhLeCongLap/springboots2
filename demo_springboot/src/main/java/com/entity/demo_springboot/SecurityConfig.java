package com.entity.demo_springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt CSRF nếu không cần thiết
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/logon", "/register", "/assets/**").permitAll() // Cho phép truy cập các trang này
                        .requestMatchers("/admin/**").hasAuthority("ADMIN") // Chỉ ADMIN mới được vào trang quản trị
                        .anyRequest().authenticated() // Các request khác đều yêu cầu đăng nhập
                )
                .formLogin(form -> form
                        .loginPage("/logon") // Trang đăng nhập tùy chỉnh
                        .loginProcessingUrl("/logon") // Xử lý đăng nhập
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true) // Đăng nhập thành công chuyển về trang chủ
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL thực hiện đăng xuất
                        .logoutSuccessUrl("/") // Chuyển hướng về trang index sau khi đăng xuất
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID") // Xóa session khi đăng xuất
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
