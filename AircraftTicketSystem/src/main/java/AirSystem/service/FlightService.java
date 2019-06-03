package AirSystem.service;

import AirSystem.entity.Flight;

import java.util.List;

public interface FlightService {

    /**
     * 新增航班 返回自增主键
     * @param flight
     * @return
     */
    Long addFlight(Flight flight);

    /**
     * 根据id删除
     * @param id
     */
    void deleteFlight(int id);

    void updateFlight(Flight flight);

    List<Flight> getAllFlights();

    Flight getFlight(int id);

    List<Flight> getFlightBySrc(String srcStation);

    List<Flight> getFlightByDst(String dstStation);

    int countAllFlights();

}
