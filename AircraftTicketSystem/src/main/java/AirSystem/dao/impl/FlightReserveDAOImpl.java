package AirSystem.dao.impl;

import AirSystem.dao.FlightReserveDAO;
import AirSystem.entity.FlightReserve;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightReserveDAOImpl implements FlightReserveDAO {

    @Override
    public List<FlightReserve> selectAllTickets() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM FlightReserve");
        List<FlightReserve> flightReserveList = new ArrayList<>();
        for (Entity entity : entityList) {
            flightReserveList.add(convertFlightReserve(entity));
        }
        return flightReserveList;
    }

    @Override
    public FlightReserve getTicketById(int id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM FlightReserve WHERE ReserveID = ?", id);
        return convertFlightReserve(entity);
    }

    @Override
    public int deleteTicketById(int id) throws SQLException  {
        return Db.use().del(
                Entity.create("Flight").set("FlightID", id)
        );
    }

    @Override
    public int countTickets() throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM FlightReserve").intValue();
    }

    @Override
    public Long insertTicket(FlightReserve ticket) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("FlightReserve")
                        .set("ReserveID", ticket.getReserveID())
                        .set("UserID", ticket.getUserID())
                        .set("FlightID", ticket.getFlightID())
                        .set("SeatType", ticket.getSeatType())
                        .set("SeatID", ticket.getSeatID())
                        .set("Price", ticket.getPrice())
        );
    }

    private FlightReserve convertFlightReserve(Entity entity) {
        FlightReserve flightReserve = new FlightReserve();
        flightReserve.setReserveID(entity.getInt("ReserveID"));
        flightReserve.setUserID(entity.getInt("UserID"));
        flightReserve.setFlightID(entity.getInt("FlightID"));
        flightReserve.setSeatType(entity.getStr("SeatType"));
        flightReserve.setSeatID(entity.getInt("SeatID"));
        flightReserve.setPrice(entity.getInt("Price"));
        return flightReserve;
    }
}
