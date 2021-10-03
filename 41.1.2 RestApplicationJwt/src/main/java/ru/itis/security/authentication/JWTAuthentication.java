package ru.itis.security.authentication;//package ru.itis.shcedule.security.authentication;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class JWTAuthentication implements Authentication {
//
//    private String jwtValue;
//    private UserDetails userDetails;
//    private boolean isAuthenticated;
//
//    public JWTAuthentication(String jwtValue) {
//        this.jwtValue = jwtValue;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return userDetails.getAuthorities();
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
//
//    @Override
//    public Object getDetails() {
//        return userDetails;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return userDetails;
//    }
//
//    @Override
//    public boolean isAuthenticated() {
//        return isAuthenticated;
//    }
//
//    @Override
//    public void setAuthenticated(boolean b) throws IllegalArgumentException {
//        this.isAuthenticated = isAuthenticated;
//    }
//
//    @Override
//    public String getName() {
//        return jwtValue;
//    }
//
//    @Override
//    public boolean equals(Object another) {
//        return false;
//    }
//
//    public void setUserDetails(UserDetails userDetails) {
//        this.userDetails = userDetails;
//    }
//
//    public void setJwtValue(String jwtValue) {
//        this.jwtValue = jwtValue;
//    }
//}
