package AirSystem.service.impl;

import AirSystem.dao.FlightReserveDAO;
import AirSystem.entity.FlightReserve;
import AirSystem.service.FlightReserveService;
import AirSystem.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightReserveServiceImpl implements FlightReserveService {
    private FlightReserveDAO flightReserveDAO = DAOFactory.getFlightReserceDAOInstance();

    @Override
    public Long addReserve(FlightReserve flightReserve) {
        long result = 0;
        try {
            result = flightReserveDAO.insertTicket(flightReserve);
        } catch (SQLException e) {
            System.err.println("增加订票出现异常");
        }
        return result;
    }

    @Override
    public void deleteReserve(int reserveID) {
        try {
            flightReserveDAO.deleteTicketById(reserveID);
        } catch (SQLException e) {
            System.err.println("删除订票出现异常");
        }
    }

    @Override
    public void updateReserve(FlightReserve flightReserve) {
        try {
            flightReserveDAO.updateTicket(flightReserve);
        } catch (SQLException e) {
            System.err.println("修改订票出现异常");
        }
    }

    @Override
    public List<FlightReserve> getAllReserves() {
        List<FlightReserve> flightReserveList = new ArrayList<>();
        try {
            flightReserveList = flightReserveDAO.selectAllTickets();
        } catch (SQLException e) {
            System.err.println("查询所有订票信息出现异常");
        }
        return flightReserveList;
    }

    @Override
    public FlightReserve getReserve(int reserveID) {
        FlightReserve flightReserve = new FlightReserve();
        try {
            flightReserve = flightReserveDAO.getTicketById(reserveID);
        } catch (SQLException e) {
            System.err.println("根据Id查询出现异常");
        }
        return flightReserve;
    }

    @Override
    public int countAllReserves() {
        int result = 0;
        try {
            result = flightReserveDAO.countTickets();
        } catch (SQLException e) {
            System.err.println("统计机票出现异常");
        }
        return result;
    }
}
