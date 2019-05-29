package AirSystem.entity;


import java.util.Date;

//管理员实体类
public class Admin {

    private int adminID;
    private String username;
    private String password;
    private String sex;
    private int age;
    private String email;
    private String phone;
    private Date joinTime;

    public int getAdminID() {
        return adminID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}

