package com.seminuevos_colima.service.impl;

import com.seminuevos_colima.entity.Role;
import com.seminuevos_colima.entity.User;
import com.seminuevos_colima.repository.UserRepository;
import com.seminuevos_colima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado."));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        if (!user.getPassword().equals(existingUser.getPassword())) {
            existingUser.setPassword(user.getPassword());
        }

        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
        userRepository.deleteById(id);
    }
}



