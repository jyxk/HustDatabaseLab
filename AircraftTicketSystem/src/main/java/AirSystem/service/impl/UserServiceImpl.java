package AirSystem.service.impl;

import AirSystem.dao.UserDAO;
import AirSystem.entity.User;
import AirSystem.service.UserService;
import AirSystem.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = DAOFactory.getUserDAOInstance();

    @Override
    public boolean login(String username, String password) {
        boolean flag = false;

        User user = null;

        try {
            user = userDAO.getUserByUsername(username);
        } catch (SQLException e) {
            System.err.println("登录异常");
        }

        if (user != null) {
            if (password.equals(user.getPassword())) {
                flag = true;
            }
        }

        return flag;
    }

    @Override
    public Long addUser(User user) {
        long result = 0;
        try {
            result = userDAO.insertUser(user);
        } catch (SQLException e) {
            System.err.println("增加旅客出现异常");
        }
        return result;
    }

    @Override
    public void deleteUser(int userID) {
        try {
            userDAO.deleteUserById(userID);
        } catch (SQLException e) {
            System.err.println("删除旅客出现异常");
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userDAO.updateUser(user);
        } catch (SQLException e) {
            System.err.println("修改旅客信息出现异常");
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            userList = userDAO.selectUser();
        } catch (SQLException e) {
            System.err.println("查询所有用户出现异常");
        }
        return userList;
    }

    @Override
    public User getUserByUserID(int userID) {
        User user = new User();
        try {
            user = userDAO.getUserByUserID(userID);
        } catch (SQLException e) {
            System.err.println("查询用户出现异常");
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = new User();
        try {
            user = userDAO.getUserByUsername(username);
        } catch (SQLException e) {
            System.err.println("查询用户出现异常");
        }

        return user;
    }

    @Override
    public int countAllUsers() {
        int result = 0;
        try {
            result = userDAO.countUsers();
        } catch (SQLException e) {
            System.err.println("统计用户数量出现异常");
        }
        return result;
    }


}
