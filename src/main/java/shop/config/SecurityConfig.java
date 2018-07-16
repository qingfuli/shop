package shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity // 获得了springSecurityFilterChain组件
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启方法级别权限检查支持（@PreAuthorize）
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    // 默认所有请求都需要登录，对于这个后台管理系统来说，可以不改
    
    @Bean
    public UserDetailsService userDetailsService() {
        // 提供用户详情，用于检查登录的用户名和密码
        InMemoryUserDetailsManager um = new InMemoryUserDetailsManager();
        um.createUser(User
                .withUsername("zs")
                .password("$2a$10$pyhoz7k3QLux1jrJmuE.ZOenAbfrGpa8cSMYa4xs9reYaDsUyXsfG")
                .authorities("图书管理员").build());

        return um;
    }
}
