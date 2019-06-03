package AirSystem.service.impl;

import AirSystem.dao.AdminDAO;
import AirSystem.entity.Admin;
import AirSystem.service.AdminService;
import AirSystem.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> adminList = new ArrayList<>();

        try {
            adminList = adminDAO.selectAdmins();
        } catch (SQLException e) {
            System.err.println("查询所有管理员出现异常！");
        }
        return adminList;
    }

    @Override
    public boolean login(String username, String password) {
        boolean flag = false;

        Admin admin = null;

        try {
            admin = adminDAO.getAdminByUsername(username);
        } catch (SQLException e) {
            System.err.println("根据账号查找管理员出现异常");
        }

        if (admin != null) {
            if (password.equals(admin.getPassword())) {
                flag = true;
            }
        }

        return flag;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        Admin admin = new Admin();

        try {
            admin = adminDAO.getAdminByUsername(username);
        } catch (SQLException e) {
            System.err.println("根据账号查找管理员信息出现异常");
        }
        return admin;
    }

    @Override
    public void updateAdminPassword(Admin admin) {
        try {
            Admin admin1 = adminDAO.getAdminByUsername(admin.getUsername());
            admin1.setPassword(admin.getPassword());
            adminDAO.updateAdmin(admin1);
        } catch (SQLException e) {
            System.err.println("更新管理员信息出现异常");
        }
    }
}
