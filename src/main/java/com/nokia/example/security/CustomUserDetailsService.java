package com.nokia.example.security;

import com.nokia.example.JpaRepository.LocalUserRepository;
import com.nokia.example.model.LocalUser;
import com.nokia.example.model.MyUserDetail;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger(CustomUserDetailsService.class);

    @Autowired
    private LocalUserRepository localUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("username==="+username);

        LocalUser localUser = localUserRepository.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        MyUserDetail userDetail = null;

        if(localUser == null){
            throw new UsernameNotFoundException("username not find.");
        }else{
            String[] userAuthArray = localUser.getRole().split(",");
            for (String userAuth : userAuthArray){
                authorities.add(new SimpleGrantedAuthority(userAuth));
            }
            userDetail = new MyUserDetail(localUser.getUsername() , localUser.getPassword(), authorities);
            userDetail.setAddress(localUser.getAddress());
            userDetail.setAge(localUser.getAge());
            userDetail.setSex(localUser.getSex());
        }
        return userDetail;
    }
}
