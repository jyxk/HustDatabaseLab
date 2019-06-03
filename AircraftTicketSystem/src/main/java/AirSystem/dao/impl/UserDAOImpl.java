package AirSystem.dao.impl;

import AirSystem.dao.UserDAO;
import AirSystem.entity.User;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> selectUser() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM UserTable");
        List<User> userList = new ArrayList<>();
        for (Entity entity : entityList) {
            userList.add(convertUser(entity));
        }
        return userList;
    }

    @Override
    public int deleteUserById(int id) throws SQLException {
        return Db.use().del(
                Entity.create("UserTable").set("UserID", id)
        );
    }

    @Override
    public Long insertUser(User user) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("UserTable")
                        .set("UserID", user.getUserID())
                        .set("Username", user.getUsername())
                        .set("Password", user.getPassword())
                        .set("Sex", user.getSex())
                        .set("Age", user.getAge())
                        .set("Email", user.getEmail())
                        .set("Phone", user.getPhone())
                        .set("IDcard", user.getIdCard())
        );
    }

    @Override
    public User getUserByUsername(String username) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM UserTable WHERE Username = ?", username);
        return convertUser(entity);
    }

    @Override
    public User getUserByUserID(int userID) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM UserTable WHERE UserID = ?", userID);
        return convertUser(entity);
    }

    @Override
    public int countUsers() throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM UserTable").intValue();
    }

    @Override
    public int updateUser(User user) throws SQLException {
        return Db.use().update(
                Entity.create()
                        .set("Password", user.getPassword())
                        .set("Username", user.getUsername())
                        .set("Sex", user.getSex())
                        .set("IDcard", user.getIdCard())
                        .set("Email", user.getEmail())
                        .set("Phone", user.getPhone())
                        .set("Age", user.getAge()),
                Entity.create("UserTable").set("UserID", user.getUserID())
        );
    }

    private User convertUser(Entity entity) {
        User user = new User();
        user.setUserID(entity.getInt("UserID"));
        user.setUsername(entity.getStr("Username"));
        user.setPassword(entity.getStr("Password"));
        user.setSex(entity.getStr("Sex"));
        user.setAge(entity.getInt("Age"));
        user.setEmail(entity.getStr("Email"));
        user.setPhone(entity.getStr("Phone"));
        user.setIdCard(entity.getStr("IDcard"));
        return user;
    }
}
