package AirSystem.service.impl;

import AirSystem.dao.FlightDAO;
import AirSystem.entity.Flight;
import AirSystem.service.FlightService;
import AirSystem.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightServiceImpl implements FlightService {
    private FlightDAO flightDAO = DAOFactory.getFlightDAOInstance();

    @Override
    public Long addFlight(Flight flight) {
        long result = 0;
        try {
            result = flightDAO.insertFlight(flight);
        } catch (SQLException e) {
            System.err.println("增加航班出现异常");
        }
        return result;
    }

    @Override
    public void deleteFlight(int id) {
        try {
            flightDAO.deleteFlightById(id);
        } catch (SQLException e) {
            System.err.println("删除航班出现异常");
        }
    }

    @Override
    public void updateFlight(Flight flight) {
        try {
            flightDAO.updateFlight(flight);
        } catch (SQLException e) {
            System.err.println("修改航班出现异常");
        }
    }

    @Override
    public List<Flight> getAllFlights() {
        List<Flight> flightList = new ArrayList<>();
        try {
            flightList = flightDAO.selectAllFlights();
        } catch (SQLException e) {
            System.err.println("查询所有航班信息出现异常");
        }
        return flightList;
    }

    @Override
    public Flight getFlight(int id) {
        Flight flight = new Flight();
        try {
            flight = flightDAO.getFlightById(id);
        } catch (SQLException e) {
            System.err.println("根据Id查询出现异常");
        }
        return flight;
    }

    @Override
    public List<Flight> getFlightBySrc(String srcStation) {
        List<Flight> flightList = new ArrayList<>();
        try {
            flightList = flightDAO.getFlightBySrc(srcStation);
        } catch (SQLException e) {
            System.err.println("按出发地查询航班信息出现异常");
        }
        return flightList;
    }

    @Override
    public List<Flight> getFlightByDst(String dstStation) {
        List<Flight> flightList = new ArrayList<>();
        try {
            flightList = flightDAO.getFlightByDst(dstStation);
        } catch (SQLException e) {
            System.err.println("按目的地查询航班信息出现异常");
        }
        return flightList;
    }

    @Override
    public int countAllFlights() {
        int result = 0;
        try {
            result = flightDAO.countFlights();
        } catch (SQLException e) {
            System.err.println("统计航班出现异常");
        }
        return result;
    }

}
