package AirSystem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FlightTable {

    private IntegerProperty flightID;
    private StringProperty flightNum, srcStation, dstStation;

    public FlightTable() {
        flightID = new SimpleIntegerProperty();
        flightNum = new SimpleStringProperty();
        srcStation = new SimpleStringProperty();
        dstStation = new SimpleStringProperty();
    }

    public FlightTable(int flightID, String flightNum, String srcStation, String dstStation) {
        this.flightID = new SimpleIntegerProperty(flightID);
        this.flightNum = new SimpleStringProperty(flightNum);
        this.srcStation = new SimpleStringProperty(srcStation);
        this.dstStation = new SimpleStringProperty(dstStation);
    }

    public int getflightID() {
        return flightID.get();
    }

    public IntegerProperty flightIDProperty() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID.set(flightID);
    }

    public String getFlightNum() {
        return flightNum.get();
    }

    public StringProperty flightNumProperty() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum.set(flightNum);
    }

    public String getSrcStation() {
        return srcStation.get();
    }

    public StringProperty srcStationProperty() {
        return srcStation;
    }

    public void setSrcStation(String srcStation) {
        this.srcStation.set(srcStation);
    }

    public String getDstStation() {
        return dstStation.get();
    }

    public StringProperty dstStationProperty() {
        return dstStation;
    }

    public void setDstStation(String dstStation) {
        this.dstStation.set(dstStation);
    }


}
