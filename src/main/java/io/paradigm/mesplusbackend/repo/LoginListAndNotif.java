package io.paradigm.mesplusbackend.repo;

import io.paradigm.mesplusbackend.models.LoginListType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginListAndNotif extends JpaRepository<LoginListType, Long> {



}
