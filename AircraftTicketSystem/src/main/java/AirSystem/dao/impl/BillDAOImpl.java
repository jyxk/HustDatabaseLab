package AirSystem.dao.impl;

import AirSystem.dao.BillDAO;
import AirSystem.entity.Bill;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillDAO {

    @Override
    public List<Bill> selectAllBills() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM Bill");
        List<Bill> billList = new ArrayList<>();
        for (Entity entity : entityList) {
            billList.add(convertBill(entity));
        }
        return billList;
    }

    @Override
    public Bill getBillById(int id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM Bill WHERE BillID = ?", id);
        return convertBill(entity);
    }

    @Override
    public List<Bill> getBillByUser(int userID) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM Bill WHERE UserID = ?", userID);
        List<Bill> billList = new ArrayList<>();
        for (Entity entity : entityList) {
            billList.add(convertBill(entity));
        }
        return billList;
    }

    @Override
    public List<Bill> getBillByFlight(int flightID) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM Bill WHERE FlightID = ?", flightID);
        List<Bill> billList = new ArrayList<>();
        for (Entity entity : entityList) {
            billList.add(convertBill(entity));
        }
        return billList;
    }

    @Override
    public int deleteBillById(int id) throws SQLException {
        return Db.use().del(
                Entity.create("Bill").set("BillID", id)
        );
    }

    @Override
    public int updateBillStatus(Bill bill) throws SQLException {

        return Db.use().update(
                Entity.create()
                        .set("UserOption", bill.getOption()),
                Entity.create("Bill").set("BillID", bill.getBillID())
        );
    }

    @Override
    public int countBills() throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM Bill").intValue();
    }

    @Override
    public Long insertBill(Bill bill) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("Bill")
                        .set("BillID", bill.getBillID())
                        .set("UserID", bill.getUserID())
                        .set("FlightID", bill.getFlightID())
                        .set("SeatType", bill.getSeatType())
                        .set("SeatID", bill.getSeatID())
                        .set("Price", bill.getPrice())
                        .set("UserOption", bill.getOption())
        );
    }

    private Bill convertBill(Entity entity) {
        Bill bill = new Bill();
        bill.setUserID(entity.getInt("UserID"));
        bill.setFlightID(entity.getInt("FlightID"));
        bill.setSeatType(entity.getStr("SeatType"));
        bill.setSeatID(entity.getInt("SeatID"));
        bill.setPrice(entity.getInt("Price"));
        bill.setOption(entity.getInt("UserOption"));
        return bill;
    }
}
