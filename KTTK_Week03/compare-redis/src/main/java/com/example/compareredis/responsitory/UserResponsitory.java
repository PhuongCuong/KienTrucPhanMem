package com.example.compareredis.responsitory;

import com.example.compareredis.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponsitory extends JpaRepository<User,Long> {
}
