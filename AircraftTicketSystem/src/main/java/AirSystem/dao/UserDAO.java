package AirSystem.dao;

import AirSystem.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> selectUser() throws SQLException;

    int deleteUserById(int id) throws SQLException;

    Long insertUser(User user) throws SQLException;

    User getUserByUsername(String username) throws SQLException;

    int countUsers() throws SQLException;

    int updateUserPassword(User user) throws SQLException;

}
