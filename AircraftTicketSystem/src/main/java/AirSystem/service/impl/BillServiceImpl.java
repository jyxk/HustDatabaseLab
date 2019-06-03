package AirSystem.service.impl;

import AirSystem.dao.BillDAO;
import AirSystem.entity.Bill;
import AirSystem.service.BillService;
import AirSystem.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillServiceImpl implements BillService {
    private BillDAO billDAO = DAOFactory.getBillDAOInstance();


    @Override
    public List<Bill> getAllBills() {
        List<Bill> billList = new ArrayList<>();
        try {
            billList = billDAO.selectAllBills();
        } catch (SQLException e) {
            System.err.println("查询所有订单信息出现异常");
        }
        return billList;
    }

    @Override
    public void deleteBill(int id) {
        try {
            billDAO.deleteBillById(id);
        } catch (SQLException e) {
            System.err.println("删除账单出现异常");
        }
    }

    @Override
    public void updateBill(Bill bill) {
        try {
            billDAO.updateBillStatus(bill);
        } catch (SQLException e) {
            System.err.println("更新账单出现异常");
        }
    }

    @Override
    public Long insertBill(Bill bill) {
        long result = 0;
        try {
            result = billDAO.insertBill(bill);
        } catch (SQLException e) {
            System.err.println("添加账单出现异常");
        }
        return result;
    }

    @Override
    public Bill getBill(int billID) {
        Bill bill = new Bill();
        try {
            bill = billDAO.getBillById(billID);
        } catch (SQLException e) {
            System.err.println("删除账单出现异常");
        }
        return bill;
    }

    @Override
    public List<Bill> getBillByUser(int userID) {
        List<Bill> billList = new ArrayList<>();
        try {
            billList = billDAO.getBillByUser(userID);
        } catch (SQLException e) {
            System.err.println("按旅客查询账单出现异常");
        }
        return billList;
    }

    @Override
    public List<Bill> getBillByFlight(int flightID) {
        List<Bill> billList = new ArrayList<>();
        try {
            billList = billDAO.getBillByFlight(flightID);
        } catch (SQLException e) {
            System.err.println("按旅客查询账单出现异常");
        }
        return billList;
    }

    @Override
    public int countAllBills() {
        int result = 0;
        try {
            result = billDAO.countBills();
        } catch (SQLException e) {
            System.err.println("统计账单出现异常");
        }
        return result;
    }
}
