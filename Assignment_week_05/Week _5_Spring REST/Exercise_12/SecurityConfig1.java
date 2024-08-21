@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .cors().and() // Enable CORS support
        .authorizeRequests()
        .antMatchers("/public/**").permitAll() // Allow public access to certain endpoints
        .anyRequest().authenticated() // Require authentication for all other endpoints
        .and()
        .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
}

@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Adjust as necessary
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
}
