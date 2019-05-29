package AirSystem.dao.impl;

import AirSystem.dao.FlightSeatsDAO;
import AirSystem.entity.FlightSeats;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightSeatsDAOImpl implements FlightSeatsDAO {

    @Override
    public List<FlightSeats> selectAllSeats() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM FlightSeats");
        List<FlightSeats> flightSeatsList = new ArrayList<>();
        for (Entity entity : entityList) {
            flightSeatsList.add(convertFlightSeats(entity));
        }
        return flightSeatsList;
    }

    @Override
    public FlightSeats getSeatById(int flightId, int seatId) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM FlightSeats WHERE SeatID = ? AND FlightID = ?", seatId, flightId);
        return convertFlightSeats(entity);
    }

    @Override
    public int deleteSeatById(int flightId, int seatId) throws SQLException {
        return Db.use().del(
                Entity.create("FlightSeats")
                        .set("FlightID", flightId)
                        .set("SeatID", seatId)
        );
    }

    @Override
    public int countSeatsByFlight(int flightId) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM FlightSeats WHERE FlightID = ?", flightId).intValue();
    }

    @Override
    public Long insertSeat(FlightSeats seat) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("FlightSeats")
                        .set("FlightID", seat.getFlightID())
                        .set("SeatType", seat.getSeatType())
                        .set("SeatID", seat.getSeatID())
                        .set("SeatStatus", seat.getSeatStatus())
        );
    }

    private FlightSeats convertFlightSeats(Entity entity) {
        FlightSeats flightSeats = new FlightSeats();
        flightSeats.setFlightID(entity.getInt("FlightID"));
        flightSeats.setSeatType(entity.getStr("SeatType"));
        flightSeats.setSeatID(entity.getInt("SeatID"));
        flightSeats.setSeatStatus(entity.getInt("SeatStatus"));
        return flightSeats;
    }
}
