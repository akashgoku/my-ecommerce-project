package com.example.ecommerce.product_service.service;

import com.example.ecommerce.product_service.entity.Role;
import com.example.ecommerce.product_service.entity.User;
import com.example.ecommerce.product_service.repository.RoleRepository;
import com.example.ecommerce.product_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles=new HashSet<>();
        Role defaultRole= roleRepository.findByName("Role_USER");
        if(defaultRole!=null)
            roles.add(defaultRole);

        user.setRoles(roles);
        return userRepository.save(user);

    }
    public User findByUserName(String username)
    {
        return userRepository.findByUsername(username);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

}
