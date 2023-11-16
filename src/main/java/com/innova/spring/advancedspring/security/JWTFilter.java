package com.innova.spring.advancedspring.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.*;

public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    private JWTService            jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailService detailService;
    private List<String>        pathsToCont = Arrays.asList("/sec", "/actuator", "/h2-console");

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
        String servletPathLoc = request.getServletPath();
        if (servletPathLoc != null && (pathsToCont.stream().anyMatch(s -> servletPathLoc.startsWith(s)))) {
            filterChain.doFilter(request,
                                 response);
            return;
        }
        String authorizationLoc = request.getHeader("Authorization");
        if (authorizationLoc == null || !authorizationLoc.startsWith("Bearer")) {
            response.setStatus(401);
            response.addHeader("Content-Type",
                               "text/plain;charset=UTF-8");
            response.getWriter()
                    .println("Token gerekiyor");
            return;
        }
        String      token     = authorizationLoc.substring(7);
        Jws<Claims> claimsLoc = jwtService.validate(token);
        if (claimsLoc == null) {
            response.setStatus(401);
            response.addHeader("Content-Type",
                               "text/plain;charset=UTF-8");
            response.getWriter()
                    .println("Token validate edilemedi");
            return;
        }

        Claims      payloadLoc     = claimsLoc.getPayload();
        String      username       = payloadLoc.getSubject();
        UserDetails userDetailsLoc = null;
        try {
            userDetailsLoc = detailService.loadUserByUsername(username);
        } catch (UsernameNotFoundException eParam) {
        }
        if (userDetailsLoc == null) {
            response.setStatus(401);
            response.addHeader("Content-Type",
                               "text/plain;charset=UTF-8");
            response.getWriter()
                    .println("Böyle bir user yok");
            return;
        }
        Authentication authenticateLoc = new UsernamePasswordAuthenticationToken(userDetailsLoc.getUsername(),
                                                                                 userDetailsLoc.getPassword(),
                                                                                 userDetailsLoc.getAuthorities());
        SecurityContextHolder.getContext()
                             .setAuthentication(authenticateLoc);
        filterChain.doFilter(request,
                             response);

    }

}
