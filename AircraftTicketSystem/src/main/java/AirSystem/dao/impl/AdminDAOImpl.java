package AirSystem.dao.impl;

import AirSystem.dao.AdminDAO;
import AirSystem.entity.Admin;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    @Override
    public List<Admin> selectAdmins() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM AdminTable");
        List<Admin> adminList = new ArrayList<>();
        for (Entity entity : entityList) {
            adminList.add(convertAdmin(entity));
        }
        return adminList;
    }

    @Override
    public Admin getAdminByUsername(String username) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM AdminTable WHERE Username = ?", username);
        return convertAdmin(entity);
    }

    @Override
    public int countAdmins() throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM AdminTable").intValue();
    }

    @Override
    public int updateAdmin(Admin admin) throws SQLException {
        return Db.use().update(
                Entity.create().set("Password", admin.getPassword()),
                Entity.create("AdminTable").set("AdminID", admin.getAdminID())
        );
    }

    private Admin convertAdmin(Entity entity) {
        Admin admin = new Admin();
        admin.setAdminID(entity.getInt("AdminID"));
        admin.setUsername(entity.getStr("Username"));
        admin.setPassword(entity.getStr("Password"));
        admin.setSex(entity.getStr("AdminSex"));
        admin.setAge(entity.getInt("Age"));
        admin.setEmail(entity.getStr("Email"));
        admin.setPhone(entity.getStr("Phone"));
        return admin;
    }
}
