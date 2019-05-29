package AirSystem.dao;

import AirSystem.entity.Bill;

import java.sql.SQLException;
import java.util.List;

public interface BillDAO {

    List<Bill> selectAllBills() throws SQLException;

    Bill getBillById(int id) throws SQLException;

    int deleteBillById(int id) throws SQLException;

    int countBills() throws SQLException;

    Long insertBill(Bill bill) throws SQLException;
}
