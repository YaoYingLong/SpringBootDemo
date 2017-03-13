package com.nokia.example.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomPasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        System.out.println("rawPassword====" + rawPassword);
        System.out.println("encodedPassword====" + encodedPassword);
        try {
            if(encodedPassword.equals(rawPassword.toString())) {
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
}
