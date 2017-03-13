package com.nokia.example.security;

import com.nokia.example.model.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Component
public class CustomizeAuthCodeService implements AuthenticationProvider{

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    HttpServletRequest request;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        MyUserDetail user = (MyUserDetail) userDetailsService.loadUserByUsername(username);

        String rand = (String) request.getSession().getAttribute("rand");
        String authcode = request.getParameter("authcode");

        System.out.println("当前产生的Auth Code是：" + rand);
        System.out.println("当前输入的Auth Code是：" + authcode);
        System.out.println("当前输入的Password是：" + password);
        System.out.println("当前数据库中的密码是：" + user.getPassword());

        if(!rand.equals(authcode)){
            throw new BadCredentialsException("Wrong auth code.");
        }

        if(user == null){
            throw new BadCredentialsException("Username not found.");
        }

        //加密过程在这里体现
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Username not found.");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
