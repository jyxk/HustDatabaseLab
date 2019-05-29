package AirSystem.dao.impl;

import AirSystem.dao.NotificationDAO;
import AirSystem.entity.Notification;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAOImpl implements NotificationDAO {

    @Override
    public List<Notification> selectAllNotifications() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM Notification");
        List<Notification> notificationList = new ArrayList<>();
        for (Entity entity : entityList) {
            notificationList.add(convertNotification(entity));
        }
        return notificationList;
    }

    @Override
    public Notification getNotificationById(int id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM Notification WHERE NotificationID = ?", id);
        return convertNotification(entity);
    }

    @Override
    public int deleteNotificationById(int id) throws SQLException {
        return Db.use().del(
                Entity.create("Notification").set("NotificationID", id)
        );
    }

    @Override
    public int countNotifications() throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM Notification").intValue();
    }

    @Override
    public Long insertNotification(Notification notification) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("Notification")
                        .set("NotificationID", notification.getNotificationID())
                        .set("UserID", notification.getUserID())
                        .set("FlightID", notification.getFlightID())
                        .set("SeatType", notification.getSeatType())
                        .set("SeatID", notification.getSeatID())
                        .set("Price", notification.getPrice())
                        .set("LeaveTime", notification.getLeaveTime())
                        .set("ArriveTime", notification.getArriveTime())
        );
    }


    private Notification convertNotification(Entity entity) {
        Notification notification = new Notification();
        notification.setUserID(entity.getInt("UserID"));
        notification.setFlightID(entity.getInt("FlightID"));
        notification.setSeatType(entity.getStr("SeatType"));
        notification.setSeatID(entity.getInt("SeatID"));
        notification.setPrice(entity.getInt("Price"));
        notification.setLeaveTime(entity.getStr("LeaveTime"));
        notification.setArriveTime(entity.getStr("ArriveTime"));
        return notification;
    }
}
