package AirSystem.dao;

import AirSystem.entity.FlightReserve;

import java.sql.SQLException;
import java.util.List;

public interface FlightReserveDAO {

    List<FlightReserve> selectAllTickets() throws SQLException;

    FlightReserve getTicketById(int id) throws SQLException;

    int deleteTicketById(int id) throws SQLException;

    int countTickets() throws SQLException;

    Long insertTicket(FlightReserve ticket) throws SQLException;

    int updateTicket(FlightReserve flightReserve) throws SQLException;
}
