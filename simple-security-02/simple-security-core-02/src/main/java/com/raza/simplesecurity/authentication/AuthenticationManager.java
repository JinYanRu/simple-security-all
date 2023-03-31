package com.raza.simplesecurity.authentication;

import com.raza.simplesecurity.core.Authentication;
import com.raza.simplesecurity.core.AuthenticationException;

/**
 *
 * 是Spring Security框架中的一个核心接口,用于对用户进行身份认证。
 * 定义了一个authenticate(Authentication authentication)方法
 * 该方法接受一个Authentication对象作为参数，然后对该对象中的用户身份信息进行认证。
 * AuthenticationManager的实现类可以使用多种身份认证方式
 *
 *
 * @author Raza
 * @date 2023/3/27
 */
public interface AuthenticationManager {

    /**
     * des.
     * @author       : RazaJin
     * @param authentication 认证
     * @date         : 2023/3/27 17:34
     * @exception AuthenticationException 异常
     */
    Authentication authenticate(Authentication authentication) throws AuthenticationException;
}
