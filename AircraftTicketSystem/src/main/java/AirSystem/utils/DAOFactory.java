package AirSystem.utils;

import AirSystem.dao.*;
import AirSystem.dao.impl.*;

public class DAOFactory {

    public static AdminDAO getAdminDAOInstance() {
        return new AdminDAOImpl();
    }

    public static BillDAO getBillDAOInstance() {
        return new BillDAOImpl();
    }

    public static FlightDAO getFlightDAOInstance() {
        return new FlightDAOImpl();
    }

    public static FlightReserveDAO getFlightReserceDAOInstance() {
        return new FlightReserveDAOImpl();
    }

    public static FlightSeatsDAO getFlightSeatsDAOInstance() {
        return new FlightSeatsDAOImpl();
    }

    public static NotificationDAO getNotificationDAOInstance() {
        return new NotificationDAOImpl();
    }

    public static UserDAO getUserDAOInstance() {
        return new UserDAOImpl();
    }
}
