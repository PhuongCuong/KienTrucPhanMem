package com.example.dataredis.responsitoryRedis;

import com.example.dataredis.moduleRedis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserResponsitoryRedis{

    private static final String KEY_PREFIX = "user:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public void save(User user) {
        String key = KEY_PREFIX + user.getId();
        redisTemplate.opsForValue().set(key, user);
    }

    public User findById(Long id) {
        String key = KEY_PREFIX + id;
        return (User) redisTemplate.opsForValue().get(key);
    }



    public void deleteById(Long id) {
        String key = KEY_PREFIX + id;
        redisTemplate.delete(key);
    }

    public boolean existsById(Long id) {
        String key = KEY_PREFIX + id;
        return redisTemplate.hasKey(key);
    }

    public void update(User user) {
        String key = KEY_PREFIX + user.getId();
        redisTemplate.opsForValue().set(key, user);
    }
}
