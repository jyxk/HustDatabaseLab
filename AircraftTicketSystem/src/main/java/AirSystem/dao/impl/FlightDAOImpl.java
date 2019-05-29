package AirSystem.dao.impl;

import AirSystem.dao.FlightDAO;
import AirSystem.entity.Flight;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

    @Override
    public List<Flight> selectAllFlights() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM Flight");
        List<Flight> flightList = new ArrayList<>();
        for (Entity entity : entityList) {
            flightList.add(convertFlight(entity));
        }
        return flightList;
    }

    @Override
    public int deleteFlightById(int id) throws SQLException {
        return Db.use().del(
                Entity.create("Flight").set("FlightID", id)
        );
    }

    @Override
    public Flight getFlightById(int id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM Flight WHERE FlightID = ?", id);
        return convertFlight(entity);
    }

    @Override
    public int countFlights() throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM Flight").intValue();
    }

    @Override
    public Long insertFlight(Flight flight) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("Flight")
                        .set("FlightID", flight.getFlightID())
                        .set("FlightNum", flight.getFlightNum())
                        .set("BClass", flight.getBClassNum())
                        .set("EClass", flight.getEClassNum())
                        .set("LeaveTime", flight.getLeaveTime())
                        .set("ArriveTime", flight.getArriveTime())
                        .set("SrcStation", flight.getSrcStation())
                        .set("DstStation", flight.getDstStation())
                        .set("BPrice", flight.getBPrice())
                        .set("EPrice", flight.getEprice())
        );
    }

    private Flight convertFlight(Entity entity) {
        Flight flight = new Flight();
        flight.setFlightID(entity.getInt("FlightID"));
        flight.setFlightNum(entity.getStr("FlightNum"));
        flight.setBClassNum(entity.getInt("BClass"));
        flight.setEClassNum(entity.getInt("EClass"));
        flight.setLeaveTime(entity.getStr("LeaveTime"));
        flight.setArriveTime(entity.getStr("ArriveTime"));
        flight.setSrcStation(entity.getStr("SrcStation"));
        flight.setDstStation(entity.getStr("DstStation"));
        flight.setBPrice(entity.getInt("BPrice"));
        flight.setEprice(entity.getInt("EPrice"));
        return flight;
    }
}
