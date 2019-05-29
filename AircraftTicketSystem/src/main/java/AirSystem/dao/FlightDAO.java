package AirSystem.dao;

import AirSystem.entity.Flight;

import java.sql.SQLException;
import java.util.List;

public interface FlightDAO {

    List<Flight> selectAllFlights() throws SQLException;

    int deleteFlightById(int id) throws SQLException;

    Flight getFlightById(int id) throws SQLException;

    int countFlights() throws SQLException;

    Long insertFlight(Flight flight) throws SQLException;

}
