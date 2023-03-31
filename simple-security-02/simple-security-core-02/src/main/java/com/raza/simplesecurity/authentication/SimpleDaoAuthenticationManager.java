package com.raza.simplesecurity.authentication;

import com.raza.simplesecurity.core.Authentication;
import com.raza.simplesecurity.core.AuthenticationException;
import com.raza.simplesecurity.core.GrantedAuthority;
import com.raza.simplesecurity.core.authority.SimpleGrantedAuthority;
import com.raza.simplesecurity.core.userdetails.User;
import com.raza.simplesecurity.core.userdetails.UserDetails;

import java.util.ArrayList;

/**
 * to do
 *
 * @author Raza
 * @date 2023/3/28
 */
public class SimpleDaoAuthenticationManager implements AuthenticationManager{


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String  principal = authentication.getPrincipal().toString();
        String credentials = authentication.getCredentials().toString();
        UserDetails userDetails = getUserDetails(principal);
        if (userDetails.getPassword().equals(credentials)){
            return new UsernamePasswordAuthenticationToken(principal,credentials,userDetails.getAuthorities());
        }
        throw new AuthenticationException("用户名和密码不匹配");
    }

    private UserDetails getUserDetails(String loginName){
        //模拟数据库中的 用户信息
        String account = "root";
        String grantedAuthority = "role_user";
        String pwd = "pwd";

        if (!account.equals(loginName)){
            throw new AuthenticationException("未查询到用户信息");
        }
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(grantedAuthority));
        return new User(account, pwd,grantedAuthorities);
    }
}
