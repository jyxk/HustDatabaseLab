package AirSystem.service;

import AirSystem.entity.Admin;

import java.util.List;

public interface AdminService {

    /**
     * 查询所有管理员
     * @return List<Admin>
     */
    List<Admin> getAllAdmins();


    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    boolean login(String username, String password);

    /**
     * 根据账号查询管理员信息
     * @param username
     * @return
     */
    Admin getAdminByUsername(String username);

    /**
     * 修改管理员密码
     * @param admin
     */
    void updateAdminPassword(Admin admin);
}
