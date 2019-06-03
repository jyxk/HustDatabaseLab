package AirSystem.service;

import AirSystem.entity.Bill;

import java.util.List;

public interface BillService {

    List<Bill> getAllBills();

    void deleteBill(int id);

    void updateBill(Bill bill);

    Long insertBill(Bill bill);

    Bill getBill(int billID);

    List<Bill> getBillByUser(int userID);

    List<Bill> getBillByFlight(int flightID);

    int countAllBills();
}
