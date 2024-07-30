package io.paradigm.mesplusbackend;

import io.paradigm.mesplusbackend.models.AuthenticationRequest;
import io.paradigm.mesplusbackend.models.AuthenticationResponse;
import io.paradigm.mesplusbackend.services.MyUserDetailsService;
import io.paradigm.mesplusbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "Hello Admin";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        /// Authentication of username and password from client happened in try-catch below
        try {
            System.out.println("===============>  /authenticate " +  authenticationRequest.getUsername() + " : " + authenticationRequest.getPassword());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            System.out.println("===============>  /authenticate caught a BadCredentialException ");
            throw new Exception("Incorrect username or password", e);
        }

        /// We only get the UserDetail here because generating the token accepts UserDetails object
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());
        System.out.println("===============>  /authenticate got the UserDetails");
            final String jwt = jwtTokenUtil.generateToken(userDetails);
        System.out.println("===============>  /authenticate generateToken " + jwt);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
