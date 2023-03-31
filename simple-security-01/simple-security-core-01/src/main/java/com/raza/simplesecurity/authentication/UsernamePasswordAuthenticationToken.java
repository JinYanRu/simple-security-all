package com.raza.simplesecurity.authentication;

import com.raza.simplesecurity.core.GrantedAuthority;
import org.springframework.util.Assert;

import java.util.Collection;


/**
 * to do
 *
 * @author Raza
 * @date 2023/3/27
 */
public class UsernamePasswordAuthenticationToken extends AbstractAuthenticationToken{

    private final Object principal;

    private Object credentials;


    public UsernamePasswordAuthenticationToken( Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }

    public static UsernamePasswordAuthenticationToken unauthenticated(Object principal, Object credentials) {
        return new UsernamePasswordAuthenticationToken(principal, credentials);
    }

    public UsernamePasswordAuthenticationToken(Object principal, Object credentials,
                                               Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        Assert.isTrue(!isAuthenticated,
                "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }

    @Override
    public String toString() {
        return "UsernamePasswordAuthenticationToken{" +
                "principal=" + principal +
                ", credentials=" + credentials +
                '}';
    }
}
