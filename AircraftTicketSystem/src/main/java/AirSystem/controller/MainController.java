package AirSystem.controller;

import AirSystem.entity.Admin;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private StackPane mainContainer;
    @FXML
    private Label timeLabel;
    @FXML
    private ImageView adminAvatar;
    @FXML
    private Label adminName;

    private Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        //开启UI线程，将登录界面传过来的管理员信息显示在主界面的右上角
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Image image = new Image(admin.getAvatar());
                adminAvatar.setImage(image);

                Circle circle = new Circle();
                circle.setCenterX(20.0);
                circle.setCenterX(20.0);
                circle.setRadius(20.0);
                adminAvatar.setClip(circle);

                adminName.setText(admin.getUsername());
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    LocalDateTime now = LocalDateTime.now();

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
                    String timeString = dateTimeFormatter.format(now);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            timeLabel.setText(timeString);
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
                }
            }
        }).start();

        try {
            AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/default.fxml")).load();
            mainContainer.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchView(String fileName) throws Exception {
        mainContainer.getChildren().clear();
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        mainContainer.getChildren().add(anchorPane);
    }

    public void logout() throws Exception {
        //close main stage
        Stage mainStage = (Stage) mainContainer.getScene().getWindow();
        mainStage.close();
        //pop up login
        Stage loginStage = new Stage();
        loginStage.setTitle("Login");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        loginStage.setMaximized(true);
        loginStage.getIcons().add(new Image("/img/logo.png"));
        loginStage.setScene(scene);
        loginStage.show();
    }
}
