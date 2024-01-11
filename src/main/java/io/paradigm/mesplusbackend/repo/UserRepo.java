package io.paradigm.mesplusbackend.repo;

import io.paradigm.mesplusbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
