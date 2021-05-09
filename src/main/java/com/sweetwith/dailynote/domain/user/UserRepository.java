package com.sweetwith.dailynote.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    // Create
    User save(User user);

    // Read
    Optional<User> findById(Long id);

    // update
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User as p SET p.loginPw =?2 WHERE p.Id =?1")
    boolean updateLoginPw(Long id, String loginPw);

    // delete
    void deleteById(Long id);
}
