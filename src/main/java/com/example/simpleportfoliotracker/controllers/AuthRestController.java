package com.example.simpleportfoliotracker.controllers;

import com.example.simpleportfoliotracker.models.AuthRequest;
import com.example.simpleportfoliotracker.models.AuthResponse;
import com.example.simpleportfoliotracker.security.MyUserDetailsService;
import com.example.simpleportfoliotracker.util.JwtUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

// login user
@RestController
@RequestMapping(path = "/api/v1/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthRestController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    // only when user login
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthToken(
            @RequestBody AuthRequest authRequest) throws Exception {
        System.out.println("Auth receive");
        Gson gson = new Gson();
        String msg = gson.toJson(authRequest);
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getLoginUsername(),
                            authRequest.getLoginPassword())
            );
        } catch (BadCredentialsException bce) {
            throw new Exception("Incorrect username or password", bce);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authRequest.getLoginUsername());
        
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @GetMapping("/portfolio")
    public String portfolio() { return "Welcome to your portfolio"; }
}
