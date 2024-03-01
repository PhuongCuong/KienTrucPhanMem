package com.example.compareredis.responsitoryRedis;

import com.example.compareredis.moduleRedis.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponsitoryRedis extends CrudRepository<User,Long> {
}
