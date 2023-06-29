package fr.studi.promoweb.security.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    static final String[] AUTH_WHITE_LIST = {
            "/api/auth",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/v2/api-docs/**",
            "/swagger-resources/**"
    };
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final LogoutHandler logoutHandler;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(AUTH_WHITE_LIST).permitAll()
                .requestMatchers("/swagger-ui/*").permitAll()
                .requestMatchers("/v3/**").permitAll()
                //.requestMatchers("/api/**").authenticated()
                .anyRequest().authenticated()
                //.anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)

                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/api/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext()));
        return httpSecurity.build();
              /*  .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/v2/api-docs").permitAll()
                .pathMatchers("/configuration/ui").permitAll()
                .pathMatchers("/swagger-resources/**").permitAll()
                .pathMatchers("/configuration/security").permitAll()
                .pathMatchers("/swagger-ui.html").permitAll()
                .pathMatchers("/swagger-ui/*").permitAll()
                .pathMatchers("/webjars/**").permitAll()
                .pathMatchers("/v2/**").permitAll()
                .and().cors()
                .and().oauth2ResourceServer()
                .jwt().and().and()
        return httpSecurity.build();*/
    }
}
