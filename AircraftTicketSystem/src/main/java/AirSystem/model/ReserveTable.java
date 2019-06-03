package AirSystem.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReserveTable {

    private IntegerProperty reserveID;
    private StringProperty departureDate, route, customer;

    public ReserveTable() {
        reserveID = new SimpleIntegerProperty();
        departureDate = new SimpleStringProperty("");
        route = new SimpleStringProperty("");
        customer = new SimpleStringProperty("");
    }

    public ReserveTable(int reserveID, String departureDate, String route, String customer) {
        this.reserveID = new SimpleIntegerProperty(reserveID);
        this.departureDate = new SimpleStringProperty(departureDate);
        this.route = new SimpleStringProperty(route);
        this.customer = new SimpleStringProperty(customer);
    }

    public int getReserveID() {
        return reserveID.get();
    }

    public IntegerProperty reserveIDProperty() {
        return reserveID;
    }

    public void setReserveID(int reserveID) {
        this.reserveID.set(reserveID);
    }

    public String getDepartureDate() {
        return departureDate.get();
    }

    public StringProperty departureDateProperty() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate.set(departureDate);
    }

    public String getRoute() {
        return route.get();
    }

    public StringProperty routeProperty() {
        return route;
    }

    public void setRoute(String route) {
        this.route.set(route);
    }

    public String getCustomer() {
        return customer.get();
    }

    public StringProperty customerProperty() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer.set(customer);
    }

}
