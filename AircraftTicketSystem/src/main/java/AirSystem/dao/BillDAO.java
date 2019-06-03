package AirSystem.dao;

import AirSystem.entity.Bill;

import java.sql.SQLException;
import java.util.List;

public interface BillDAO {

    List<Bill> selectAllBills() throws SQLException;

    Bill getBillById(int id) throws SQLException;

    List<Bill> getBillByUser(int userID) throws SQLException;

    List<Bill> getBillByFlight(int flightID) throws SQLException;

    int deleteBillById(int id) throws SQLException;

    int updateBillStatus(Bill bill) throws SQLException;

    int countBills() throws SQLException;

    Long insertBill(Bill bill) throws SQLException;
}
