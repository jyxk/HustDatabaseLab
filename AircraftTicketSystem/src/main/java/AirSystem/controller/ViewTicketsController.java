package AirSystem.controller;

import AirSystem.Main;
import AirSystem.entity.Flight;
import AirSystem.entity.FlightReserve;
import AirSystem.model.ReserveTable;
import AirSystem.service.FlightReserveService;
import AirSystem.service.FlightService;
import AirSystem.utils.ServiceFactory;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewTicketsController {

    @FXML
    private TableView<ReserveTable> reserveTable;

    @FXML
    private TableColumn<ReserveTable, String> departureTimeColumn;

    @FXML
    private TableColumn<ReserveTable, String> routeColumn;

    @FXML
    private TableColumn<ReserveTable, String> customerColumn;

    @FXML
    private Label srcLabel;
    @FXML
    private Label dstLabel;
    @FXML
    private Label carbinLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label phoneLabel;

    @FXML
    private TextField searchField;


    private ObservableList<ReserveTable> reserves, tableItems;

    private List<FlightReserve> flightReserveList;

    private FlightReserveService flightReserveService = ServiceFactory.getFlightReserveServiceInstance();

    public ViewTicketsController() {}

    @FXML
    public void initalize(URL location, ResourceBundle resources) {
        flightReserveList = flightReserveService.getAllReserves();

    }

    public void initializeSearch() {
        searchField.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (searchField.textProperty().get().isEmpty()) {
                    reserveTable.setItems(reserves);
                    return;
                }

                tableItems = FXCollections.observableArrayList();

                for (ReserveTable table : reserves) {
                    if (table.getRoute().toUpperCase().contains(searchField.getText().toUpperCase()) ||
                        table.getCustomer().toUpperCase().contains(searchField.getText().toUpperCase())
                    ) {
                        tableItems.add(table);
                    }
                }

                reserveTable.setItems(tableItems);
            }
        });
    }
}
