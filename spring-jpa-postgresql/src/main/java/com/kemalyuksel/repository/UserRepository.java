package com.kemalyuksel.repository;

import com.kemalyuksel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
