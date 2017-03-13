package com.nokia.example.security;

import com.nokia.example.JpaRepository.LocalUserRepository;
import com.nokia.example.model.LocalUser;
import com.nokia.example.model.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

@Component
public class CustomizePermission implements PermissionEvaluator{

    @Autowired
    private LocalUserRepository localUserRepository;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomain, Object permission) {

        if(authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        LocalUser localUser = localUserRepository.findByUsername(userDetails.getUsername());

        System.err.println("targetDomain:" + String.valueOf(targetDomain));
        System.err.println("permission:" + String.valueOf(permission));
        String[] permissionArray = localUser.getPermission().split(",");
        for (String perm : permissionArray){
            if(perm.equalsIgnoreCase(targetDomain.toString())){
                return this.hasPermission(authentication , permission);
            }
        }
        return false;
    }

    private boolean hasPermission(Authentication authentication , Object permission){
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(GrantedAuthority authority : authorities){
            if(authority.getAuthority().equals(permission)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
