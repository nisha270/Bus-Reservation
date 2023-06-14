package com.masai.Services;

import java.util.List;

import com.masai.models.User;

interface UserService {
    User addUser(User user);
    User updateUser(User user);
    User deleteUser(int userId);
    User viewUser(int userId);
    List<User> viewAllUsers();
}
