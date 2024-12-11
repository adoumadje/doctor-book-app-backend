package com.example.doctor_book_app_backend.config;

import com.example.doctor_book_app_backend.error.CustomAuthenticationFailureHandler;
import com.example.doctor_book_app_backend.service.utils.MyUserDetailsService;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final RsaKeyProperties rsaKeys;
    private final MyUserDetailsService userDetailsService;
    private final CustomAuthenticationFailureHandler failureHandler;

    public SecurityConfig(RsaKeyProperties rsaKeys,
                          MyUserDetailsService userDetailsService,
                          CustomAuthenticationFailureHandler failureHandler) {
        this.rsaKeys = rsaKeys;
        this.userDetailsService = userDetailsService;
        this.failureHandler = failureHandler;
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails userDetails = User.builder()
//                .username("admin")
//                .password("$2a$10$SxLk9ahzQdHA54o9i6pI/OWoMi07dHH1zLYf2MQeO3XRMc2gt7KRq")
//                .authorities("create", "read", "update", "delete")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/api/v1/patient/register-patient",
                                        "/api/v1/doctor/register-doctor",
                                        "/api/v1/general/upload-profile-pic",
                                        "/uploads/**").permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults()))
                .httpBasic(Customizer.withDefaults())
                .formLogin(login -> login.failureHandler(failureHandler));
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return  NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
    }

    @Bean
    public JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).
                privateKey(rsaKeys.privateKey()).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }
}
