package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Query("select u.id from User  u where u.email = ?1")
    Optional<Long> getIdByEmail(String email);
}
