package com.example.ecommerce.product_service.service;


import com.example.ecommerce.product_service.entity.User;
import com.example.ecommerce.product_service.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser()
    {
        User user= new User();

        user.setUsername("testuser");
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);

        User result=userService.saveUser(user);
        assertEquals("testuser",result.getUsername());

    }

}
