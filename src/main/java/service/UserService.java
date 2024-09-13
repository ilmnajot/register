package service;

import entity.User;

import java.util.List;

public interface UserService {
    User findUser(Long userId);

    List<User> getUsers();

    User addUser(User user);

    User deleteUserById(Long userId);

    User updateUser(Long userId, User user);
}
