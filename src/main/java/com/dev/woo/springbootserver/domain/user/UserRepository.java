package com.dev.woo.springbootserver.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByPk(Long pk);

    @Query("SELECT u FROM User u WHERE u.id= :id")
    public User findById(@Param("id") String id);
}
