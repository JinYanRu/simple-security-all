package com.raza.simplesecurity.core.authority;


import com.raza.simplesecurity.core.GrantedAuthority;
import org.springframework.util.Assert;

/**
 *
 * 创建一个包含权限信息的对象，该对象可以用于表示用户所具有的权限
 *
 * 在 Spring Security 中，权限信息通常被封装在 Authentication 对象中，而 Authentication 对象则被封装在 SecurityContext 中。
 *
 * @author Raza
 * @date 2023/3/27
 */
public final class SimpleGrantedAuthority implements GrantedAuthority {

    private final String role;

    public SimpleGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
