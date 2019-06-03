package AirSystem.controller;

import AirSystem.entity.Flight;
import AirSystem.model.FlightTable;
import AirSystem.service.FlightService;
import AirSystem.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;


public class ViewFlightController {

    @FXML
    private TextField srcStationField;
    @FXML
    private TextField dstStationField;
    @FXML
    private Label usernameLabel;

    @FXML
    private TableView<FlightTable> flightTable;

    @FXML
    private TableColumn<FlightTable, String> flightNumColumn;

    @FXML
    private TableColumn<FlightTable, String> srcStationColumn;

    @FXML
    private TableColumn<FlightTable, String> dstStationColumn;

    @FXML
    private Label flightNumLabel;
    @FXML
    private Label srcStationLabel;
    @FXML
    private Label dstStationLabel;
    @FXML
    private DatePicker departureTimePicker;
    @FXML
    private ChoiceBox cabinChoiceBox;

    @FXML
    private Button bookButton;

    private ObservableList<FlightTable> flights;

    private List<Flight> flightList;

    private FlightService flightService = ServiceFactory.getFlightServiceInstance();

    public ViewFlightController() {}

    @FXML
    public void initalize() {
        flightList = flightService.getAllFlights();
        cabinChoiceBox.setItems(FXCollections.observableArrayList("商务舱", "经济舱"));
    }

}
