package com.willian.thomaz.hruser.repositories;

import com.willian.thomaz.hruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}