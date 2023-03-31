package com.raza.simplesecurity.authentication;

import com.raza.simplesecurity.core.Authentication;
import com.raza.simplesecurity.core.CredentialsContainer;
import com.raza.simplesecurity.core.GrantedAuthority;
import com.raza.simplesecurity.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * to do
 *
 * @author Raza
 * @date 2023/3/27
 */
public abstract class AbstractAuthenticationToken implements Authentication , CredentialsContainer {

    private final Collection<GrantedAuthority> authorities;

    private Object details;

    private boolean authenticated = false;

    public AbstractAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        if (authorities == null){
            this.authorities = Collections.emptyList();
            return;
        }
        for (GrantedAuthority authority : authorities) {
            Assert.notNull(authority, "Authorities collection cannot contain any null elements");
        }
        this.authorities = List.copyOf(authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }





    @Override
    public Object getDetails() {
        return this.details;
    }

    public void setDetails(Object details){
       this.details = details;
    }



    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public void eraseCredentials() {

    }

    @Override
    public boolean equals(Object another) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getName() {
        if (this.getPrincipal() instanceof UserDetails) {
             ((UserDetails) this.getPrincipal()).getUserName();
        }
        if (this.getPrincipal() instanceof Principal) {
            return ((Principal) this.getPrincipal()).getName();
        }
        return (this.getPrincipal() == null) ? "" : this.getPrincipal().toString();
    }

    private void eraseSecret(Object secret){
        if (secret instanceof CredentialsContainer){
            ((CredentialsContainer) secret).eraseCredentials();
        }
    }
}
