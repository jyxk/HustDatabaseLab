package AirSystem.dao;

import cn.hutool.db.Entity;
import AirSystem.entity.Admin;

import java.sql.SQLException;
import java.util.List;


/**
 * admin dao interface
 */
public interface AdminDAO {

    /**
     * 查询所有管理员
     *
     * @return List<Admin>
     * @throws SQLException
     */
    List<Admin> selectAdmins() throws SQLException;

    /**
     *  根据账号查询管理员
     *
     * @param username
     * @return Entity
     * @throws SQLException
     */
    Admin getAdminByUsername(String username) throws SQLException;

    /**
     *  统计管理员总数
     *
     *
     * @return
     * @throws SQLException
     */
    int countAdmins() throws SQLException;

    int updateAdmin(Admin admin) throws SQLException;

}
