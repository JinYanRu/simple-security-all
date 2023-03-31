package com.raza.simplesecurity.core;


/**
 * 表示授予验证身份的权限
 *
 * @author Raza
 * @date 2023/3/27
 */
public interface GrantedAuthority {

    /**
     * des. 获取授予的权限
     * @return string
     * @author       : RazaJin
     * @date         : 2023/3/28 10:23
     */
    String getAuthority();

}
