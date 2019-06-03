package AirSystem.controller;

import AirSystem.entity.Admin;
import AirSystem.service.AdminService;
import AirSystem.service.UserService;
import AirSystem.utils.ServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ToggleButton isCustomerButton;

    private AdminService adminService = ServiceFactory.getAdminServiceInstance();

    private UserService userService = ServiceFactory.getUserServiceInstance();

    @FXML
    private void login() throws Exception {

        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (!isCustomerButton.isSelected()) {
            if (adminService.login(username, password)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setContentText("登录成功");
                alert.showAndWait();

                Stage mainStage = new Stage();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
                BorderPane root = fxmlLoader.load();
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/css/style.css");
                mainStage.setTitle("Air ticket system");
                mainStage.setMaximized(true);
                mainStage.setScene(scene);
                mainStage.getIcons().add(new Image("/img/logo.png"));
                mainStage.show();

                Admin admin = adminService.getAdminByUsername(username);
                MainController mainController = fxmlLoader.getController();
                mainController.setAdmin(admin);
                Stage loginStage = (Stage) usernameField.getScene().getWindow();
                loginStage.close();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setContentText("账号或密码错误，登录失败！");
                alert.showAndWait();
            }
        } else {
            if (userService.login(username, password)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setContentText("登录成功");
                alert.showAndWait();

                Stage mainStage = new Stage();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ViewFlight.fxml"));
                AnchorPane root = fxmlLoader.load();
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/css/style.css");
                mainStage.setTitle("Air ticket system");
                mainStage.setMaximized(true);
                mainStage.setScene(scene);
                mainStage.getIcons().add(new Image("/img/logo.png"));
                mainStage.show();

                Admin admin = adminService.getAdminByUsername(username);
                MainController mainController = fxmlLoader.getController();
                mainController.setAdmin(admin);
                Stage loginStage = (Stage) usernameField.getScene().getWindow();
                loginStage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setContentText("账号或密码错误，登录失败！");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public boolean signup() throws Exception {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/SignUpDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Scene scene = new Scene(page);
            scene.getStylesheets().add("/css/style.css");
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("User Sign Up");
            dialogStage.initModality(Modality.WINDOW_MODAL);

            dialogStage.setScene(scene);

            // Set the person into the controller.
            SignUpDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);


            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
