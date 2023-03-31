package com.raza.simplesecurity.core.userdetails;

import com.raza.simplesecurity.core.GrantedAuthority;

import java.util.Collection;

/**
 * to do
 *
 * @author raza
 * @date 2023/3/25
 */
public interface UserDetails {
    /**
     * des. 获取权限列表
     * @return 返回用户的授权,不能为null
     * @author       : RazaJin
     * @date         : 2023/3/27 14:26
     */
    Collection<? extends GrantedAuthority> getAuthorities();

    /**
     * des. 获取用户密码
     * @return boolean
     * @author       : RazaJin
     * @date         : 2023/3/27 14:26
     */
    String getPassword();

    /**
     * des. 获取用户名
     * @return 用户名
     * @author       : RazaJin
     * @date         : 2023/3/27 14:26
     */
    String getUserName();


    /**
     * des. 检查用户账户是否已过期。如果用户账户已过期，则用户将无法登录。
     * @return boolean
     * @author       : RazaJin
     * @date         : 2023/3/27 14:27
     */
    boolean isAccountNonExpired();

    /**
     * des. 检查账户是否已经锁定
     * @return boolean
     * @author       : RazaJin
     * @date         : 2023/3/27 14:28
     */
    boolean isAccountNonLocked();

    /**
     * des. 检查用户的凭据（密码）是否已过期。如果用户的凭据已过期，则用户可能需要通过重置密码等方式来更新它们
     * @return boolean
     * @author       : RazaJin
     * @date         : 2023/3/27 14:27
     */
    boolean isCredentialsNonExpired();

    /**
     * des. 是否可用
     * @return boolean
     * @author       : RazaJin
     * @date         : 2023/3/27 14:29
     */
    boolean isEnabled();

}
