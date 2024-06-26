package com.shaibal.meetings.security.repository;

import com.shaibal.meetings.security.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
    public boolean existsByEmail(String email);
    public boolean existsByDisplayName(String displayName);
}
