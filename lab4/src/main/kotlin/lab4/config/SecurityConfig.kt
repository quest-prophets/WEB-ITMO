package lab4.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.sql.DataSource
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.context.request.RequestContextListener
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.servlet.config.annotation.CorsRegistry


@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private var dataSource: DataSource? = null

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun requestContextListener(): RequestContextListener {
        return RequestContextListener()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("*")
        configuration.allowedMethods = listOf("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH")
        configuration.allowCredentials = true
        configuration.allowedHeaders = listOf("*")
        configuration.exposedHeaders = listOf("Access-Control-Allow-Origin", "Access-Control-Allow-Methods",
            "Access-Control-Allow-Headers", "Access-Control-Max-Age",
            "Access-Control-Request-Headers", "Access-Control-Request-Method")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

    override fun configure(web: WebSecurity) {
        web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/pics/**")
    }

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers( "/auth/login", "/auth/register", "/", "/*.ico", "/img/**", "/*.js", "/index.html").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/auth/login")
                .successHandler { request, response, authentication -> run {
                    val cookies = request.cookies
                    if (cookies != null)
                        for (i in 0..cookies.size) {
                            if (cookies[i].name == "JSESSIONID")
                                response.setHeader("Set-Cookie", "JSESSIONID=${cookies[i].value}")

                        }

                    response.status = 200
                    response.contentType = MediaType.APPLICATION_JSON_VALUE
                    response.outputStream.print("{\"username\":\"" + request.getParameter("username") + "\"}")
                }}
                .failureHandler { request, response, exception -> response.status = 401 }
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
            .and()
                .logout().logoutSuccessHandler { request, response, authentication -> response.status = 200 }.permitAll()
            .and()
                .exceptionHandling().authenticationEntryPoint { request, response, authException -> run {
                response.outputStream.print("Not authorized")
                response.status = 401
            }}
            .and()
                .cors()
    }


    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(passwordEncoder())
            .usersByUsernameQuery("select username, password, active from users where username=?")
            .authoritiesByUsernameQuery("select u.username, " +
                    "ur.roles from users u inner join user_role ur on u.id = ur.user_id where u.username=?")
    }


}

