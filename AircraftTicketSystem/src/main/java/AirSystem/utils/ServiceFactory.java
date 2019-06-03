package AirSystem.utils;

import AirSystem.service.*;
import AirSystem.service.impl.*;

public class ServiceFactory {

    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }

    public static FlightService getFlightServiceInstance() {
        return new FlightServiceImpl();
    }

    public static BillService getBillServiceInstance() { return new BillServiceImpl(); }

    public static FlightReserveService getFlightReserveServiceInstance() { return new FlightReserveServiceImpl(); }

    public static UserService getUserServiceInstance() { return new UserServiceImpl(); }
}
