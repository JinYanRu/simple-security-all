package com.raza.simplesecurity.core.userdetails;

import com.raza.simplesecurity.core.CredentialsContainer;
import com.raza.simplesecurity.core.GrantedAuthority;
import org.springframework.util.Assert;

import java.util.*;

/**
 * to do
 *
 * @author Raza
 * @date 2023/3/28
 */
public class User implements UserDetails , CredentialsContainer {

    private String password;

    private final String username;

    private final Set<GrantedAuthority> authorities;

    private final boolean accountNonExpired;

    private final boolean accountNonLocked;

    private final boolean credentialsNonExpired;

    private final boolean enabled;

    public User(String username, String password ,Collection < ? extends GrantedAuthority> authorities) {
        this(password,username,true,true,authorities,true,true);
    }

    public User(String password, String username, boolean enabled , boolean accountNonExpired ,Collection< ?  extends GrantedAuthority > authorities, boolean accountNonLocked, boolean credentialsNonExpired) {
        this.password = password;
        this.username = username;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities)) ;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUserName() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * des. 这个方法要根据权限级别进行排序,
     * TODO: 这里先不排了,以后在做
     * @author       : RazaJin
     */
    private Set<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> collection){
      /*  Assert.notNull(authorities,"权限不能为空");
        SortedSet<GrantedAuthority> sortedSet = new TreeSet<>();
        for (GrantedAuthority grantedAuthority : collection) {
            Assert.notNull(grantedAuthority,"权限集合中不能包含空元素");
            sortedSet.add(grantedAuthority);
        }
        return sortedSet;*/

        Set<GrantedAuthority> sets = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            Assert.notNull(authority,"权限集合中不能包含空元素");
            sets.add(authority);
        }
        return sets;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", authorities=" + authorities +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }
}
