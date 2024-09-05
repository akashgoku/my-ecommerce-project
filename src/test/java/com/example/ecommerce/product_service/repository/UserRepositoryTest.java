package com.example.ecommerce.product_service.repository;


import com.example.ecommerce.product_service.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testServer()
    {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        User savedUser = userRepository.save(user);
        assertEquals("testuser", savedUser.getUsername());
    }

    @Test
    public void testFindByUsername() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        userRepository.save(user);
        User foundUser = userRepository.findByUsername("testuser");
        assertEquals("testuser", foundUser.getUsername());
    }

}
