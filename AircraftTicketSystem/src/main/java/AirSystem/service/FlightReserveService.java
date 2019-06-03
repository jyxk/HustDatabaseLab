package AirSystem.service;

import AirSystem.entity.FlightReserve;

import java.util.List;

public interface FlightReserveService {

    Long addReserve(FlightReserve flightReserve);

    void deleteReserve(int reserveID);

    void updateReserve(FlightReserve flightReserve);

    List<FlightReserve> getAllReserves();

    FlightReserve getReserve(int reserveID);

    int countAllReserves();
}
