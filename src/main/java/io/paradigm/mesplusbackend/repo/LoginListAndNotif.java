package io.paradigm.mesplusbackend.repo;

import io.paradigm.mesplusbackend.models.LoginParamType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginListAndNotif extends JpaRepository<LoginParamType, Long> {

}
