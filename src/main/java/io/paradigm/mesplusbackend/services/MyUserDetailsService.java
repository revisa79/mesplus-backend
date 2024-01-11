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
    UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /// Check if the username is in your list/database
        Optional<User> user = userRepo.findByUserName(username);

        user.orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username));
        return user.map(mesUserDetails::new).get();

    }
}
        //        if (!username.equals("alvin")) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//
//        return new User("alvin","foo", new ArrayList<>());



/*
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user details from your data source (e.g., database)
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Convert your User entity to UserDetails
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        // Convert your Role entities to GrantedAuthorities
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
* */