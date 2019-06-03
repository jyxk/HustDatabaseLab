package AirSystem.dao;

import AirSystem.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> selectUser() throws SQLException;

    int deleteUserById(int id) throws SQLException;

    Long insertUser(User user) throws SQLException;

    User getUserByUsername(String username) throws SQLException;

    User getUserByUserID(int userID) throws SQLException;

    int countUsers() throws SQLException;

    int updateUser(User user) throws SQLException;

}
