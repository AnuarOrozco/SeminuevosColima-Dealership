package com.seminuevos_colima.service;

import com.seminuevos_colima.entity.User;

public interface UserService {

    User findByEmail(String email);

    User createUser(User user);
    User editUser(Long id, User user);
    void deleteUser(Long id);

}
