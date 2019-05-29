package AirSystem.dao;

import AirSystem.entity.FlightSeats;

import java.sql.SQLException;
import java.util.List;

public interface FlightSeatsDAO {

    List<FlightSeats> selectAllSeats() throws SQLException;

    FlightSeats getSeatById(int flightId, int seatId) throws SQLException;

    int deleteSeatById(int flightId, int seatId) throws SQLException;

    int countSeatsByFlight(int flightId) throws SQLException;

    Long insertSeat(FlightSeats seat) throws SQLException;
}
