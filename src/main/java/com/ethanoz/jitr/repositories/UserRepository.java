package com.ethanoz.jitr.repositories;

import com.ethanoz.jitr.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
