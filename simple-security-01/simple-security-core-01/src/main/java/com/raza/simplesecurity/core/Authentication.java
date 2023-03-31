package com.raza.simplesecurity.core;

import java.security.Principal;
import java.util.Collection;

/**
 * to do
 *
 * @author zhoukaifang
 * @date 2023/3/25
 */
public interface Authentication extends Principal {

    /**
     * des. 获取权限列表
     * @return 返回用户的授权,不能为null
     * @author       : RazaJin
     * @date         : 2023/3/27 14:26
     */
    Collection<? extends GrantedAuthority> getAuthorities();

    /**
     * des. 认证凭证,通常是一个密码
     * 也可以是其他认证令牌
     * @return 认证凭证
     * @author       : RazaJin
     * @date         : 2023/3/27 14:58
     */
    Object getCredentials();

    /**
     * des. 存放用户用于认证的详细信息
     * @author       : RazaJin
     * @return user details
     * @date         : 2023/3/27 15:01
     */
    Object getDetails();

    /**
     * des. 用户名
     * @return 用户名
     * @author       : RazaJin
     * @date         : 2023/3/27 15:02
     */
    Object getPrincipal();


    /**
     * des.
     * @return boolean
     * @author       : RazaJin
     * @date         : 2023/3/27 14:29
     */
    boolean isAuthenticated();

    /**
     * des. 设置用户认证状态
     * @author       : RazaJin
     * @param isAuthenticated 是否认证
     * @date         : 2023/3/27 15:02
     * @exception IllegalArgumentException 注释
     */
    void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException;
}
