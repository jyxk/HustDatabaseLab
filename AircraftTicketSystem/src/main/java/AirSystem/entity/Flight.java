package AirSystem.entity;

public class Flight {

    private int flightID;
    private String flightNum;
    private int BClassNum;
    private int EClassNum;
    private String leaveTime;
    private String arriveTime;
    private String srcStation;
    private String dstStation;
    private int BPrice;
    private int Eprice;

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public int getBClassNum() {
        return BClassNum;
    }

    public void setBClassNum(int BClassNum) {
        this.BClassNum = BClassNum;
    }

    public int getEClassNum() {
        return EClassNum;
    }

    public void setEClassNum(int EClassNum) {
        this.EClassNum = EClassNum;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getSrcStation() {
        return srcStation;
    }

    public void setSrcStation(String srcStation) {
        this.srcStation = srcStation;
    }

    public String getDstStation() {
        return dstStation;
    }

    public void setDstStation(String dstStation) {
        this.dstStation = dstStation;
    }

    public int getBPrice() {
        return BPrice;
    }

    public void setBPrice(int BPrice) {
        this.BPrice = BPrice;
    }

    public int getEprice() {
        return Eprice;
    }

    public void setEprice(int eprice) {
        Eprice = eprice;
    }

}

