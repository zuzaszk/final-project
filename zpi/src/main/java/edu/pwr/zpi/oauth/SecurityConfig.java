package edu.pwr.zpi.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;

@Configuration
public class SecurityConfig {

    private final CasAuthenticationEntryPoint casAuthenticationEntryPoint;
    private final CasConfig casConfig;

    // Inject beans from CasConfig
    public SecurityConfig(CasAuthenticationEntryPoint casAuthenticationEntryPoint, CasConfig casConfig) {
        this.casAuthenticationEntryPoint = casAuthenticationEntryPoint;
        this.casConfig = casConfig;
    }

    // Define the AuthenticationManager bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // CAS Authentication Filter
    @Bean
    public CasAuthenticationFilter casAuthenticationFilter(AuthenticationManager authenticationManager) {
        CasAuthenticationFilter casFilter = new CasAuthenticationFilter();
        casFilter.setAuthenticationManager(authenticationManager);  // Inject the AuthenticationManager
        return casFilter;
    }

    // Security filter chain for configuring Spring Security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/public/**").permitAll()  // Allow public URLs
                                .anyRequest().authenticated()               // Secure everything else
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/login")
                                .permitAll()
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.authenticationEntryPoint(casAuthenticationEntryPoint)
                )
                .addFilter(casAuthenticationFilter(authenticationManager));  // Inject the AuthenticationManager into casAuthenticationFilter

        return http.build();
    }
}
