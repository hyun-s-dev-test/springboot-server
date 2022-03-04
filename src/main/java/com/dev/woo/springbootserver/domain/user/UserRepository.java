package com.dev.woo.springbootserver.domain.user;

import com.dev.woo.springbootserver.controller.dto.UserLoginRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByPk(Long pk);

    @Query("SELECT u FROM User u WHERE u.id= :id")
    public User findById(@Param("id") String id);

    public void deleteAllById(String id);

    @Query("SELECT u FROM User u WHERE u.id= :id AND u.password= :password")
    public User findByIdAndPassword(@Param("id") String id, @Param("password") String password);
}
