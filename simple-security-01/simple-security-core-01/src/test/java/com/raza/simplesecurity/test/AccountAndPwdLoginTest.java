package com.raza.simplesecurity.test;

import com.raza.simplesecurity.authentication.AuthenticationManager;
import com.raza.simplesecurity.authentication.SimpleDaoAuthenticationManager;
import com.raza.simplesecurity.authentication.UsernamePasswordAuthenticationToken;
import com.raza.simplesecurity.core.Authentication;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 * to do
 *
 * @author Raza
 * @date 2023/3/28
 */
public class AccountAndPwdLoginTest {

    @Test
    public void test(){
        String account = "root";
        String pwd = "pwd";
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(account, pwd);
        AuthenticationManager authenticationManager = new SimpleDaoAuthenticationManager();
        Authentication authenticate = authenticationManager.authenticate(authentication);
    }
}
