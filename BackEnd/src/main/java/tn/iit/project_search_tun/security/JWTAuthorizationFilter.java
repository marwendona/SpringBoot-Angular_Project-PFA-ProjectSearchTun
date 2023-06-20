package tn.iit.project_search_tun.security;

import tn.iit.project_search_tun.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Optional;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;

    public JWTAuthorizationFilter(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        authenticate(request);
        filterChain.doFilter(request, response);
    }

    private void authenticate(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null) {
            return;
        }
        if (authorizationHeader.startsWith("Basic ")) {
            var authentication = getBasicAuthentication(authorizationHeader);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        if (authorizationHeader.startsWith("Bearer ")) {
            var authentication = getTokenAuthentication(authorizationHeader, request);
            authentication.ifPresent(auth -> SecurityContextHolder.getContext().setAuthentication(auth));
        }
    }

    private static UsernamePasswordAuthenticationToken getBasicAuthentication(String authorizationHeader) {
        var base64Credentials = authorizationHeader.substring("Basic ".length()).trim();
        byte[] decoded = Base64.decode(base64Credentials.getBytes());
        var credentials = new String(decoded, StandardCharsets.UTF_8);
        var parts = credentials.split(":", 2);
        var username = parts[0];
        var password = parts[1];
        return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
    }

    private Optional<UsernamePasswordAuthenticationToken> getTokenAuthentication(String authorizationHeader, HttpServletRequest request) {
        var jwt = authorizationHeader.replace("Bearer ", "");
        var email = jwtService.extractUsername(jwt);
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = userService.findByEmail(email).map(UserDetailsImpl::new).orElseThrow();
            if (jwtService.isTokenValid(jwt, userDetails)) {
                var authToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                return Optional.of(authToken);
            }
        }
        return Optional.empty();
    }


}
