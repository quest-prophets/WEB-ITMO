package lab4.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.sql.DataSource
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.config.annotation.web.builders.WebSecurity


@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private var dataSource: DataSource? = null

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
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
                .antMatchers("/index*", "/auth/login", "/auth/register", "/", "/*.ico").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/auth/login")
                .successHandler { request, response, authentication -> response.status = 200  }
                .failureHandler { request, response, exception -> response.status = 401 }
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
            .and()
                .logout().logoutSuccessHandler { request, response, authentication -> response.status = 200 }.permitAll()
            .and()
            .exceptionHandling().authenticationEntryPoint { request, response, authException -> response.status = 401 }
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