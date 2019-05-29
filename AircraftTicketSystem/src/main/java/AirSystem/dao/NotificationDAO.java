package AirSystem.dao;

import AirSystem.entity.Notification;

import java.sql.SQLException;
import java.util.List;

public interface NotificationDAO {

    List<Notification> selectAllNotifications() throws SQLException;

    Notification getNotificationById(int id) throws SQLException;

    int deleteNotificationById(int id) throws SQLException;

    int countNotifications() throws SQLException;

    Long insertNotification(Notification notification) throws SQLException;
}
