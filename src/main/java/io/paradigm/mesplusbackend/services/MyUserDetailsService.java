package io.paradigm.mesplusbackend.services;

import io.paradigm.mesplusbackend.models.mesUserDetails;
import io.paradigm.mesplusbackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import io.paradigm.mesplusbackend.models.User;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    /// AuthenticationProvider
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /// Checks if the username is in your list/database
        Optional<User> user = userRepo.findByUserName(username);
        user.orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username));

        /// Convert your User entity to UserDetails and return to client
        return user.map(mesUserDetails::new).get();
    }
}