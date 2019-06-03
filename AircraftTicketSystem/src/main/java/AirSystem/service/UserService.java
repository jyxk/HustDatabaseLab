package AirSystem.service;

import AirSystem.entity.User;

import java.util.List;

public interface UserService {

    boolean login(String username, String password);

    Long addUser(User user);

    void deleteUser(int userID);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserByUserID(int userID);

    User getUserByUsername(String username);

    int countAllUsers();
}
