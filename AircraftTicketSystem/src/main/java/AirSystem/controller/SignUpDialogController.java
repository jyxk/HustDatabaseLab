package AirSystem.controller;

import AirSystem.entity.User;
import AirSystem.service.UserService;
import AirSystem.utils.ServiceFactory;
import AirSystem.utils.Validator;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SignUpDialogController {

    @FXML
    private TextField usernameField;
    @FXML
    private ToggleButton isMaleButton;
    @FXML
    private ToggleButton isFemaleButton;
    @FXML
    private ToggleButton unknownButton;
    @FXML
    private TextField ageField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField repeatPasswordField;
    @FXML
    private final ToggleGroup sexGroup = new ToggleGroup();

    private UserService userService = ServiceFactory.getUserServiceInstance();

    private Stage dialogStage;
    private User user = new User();
    private boolean okClicked = false;

    @FXML
    public void initalize() {
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
            user.setUsername(usernameField.getText());
            user.setAge(Integer.parseInt(ageField.getText().trim()));
            user.setEmail(emailField.getText().trim());
            user.setPhone(phoneField.getText().trim());
            user.setPassword(passwordField.getText().trim());
            String sex;
            if (isMaleButton.isSelected()) {
                sex = "男";
            }
            else if (isFemaleButton.isSelected()) {
                sex = "女";
            }
            else {
                sex = "其他";
            }
            user.setSex(sex);
            userService.addUser(user);

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (usernameField.getText() == null || usernameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (ageField.getText() == null || ageField.getText().length() == 0) {
            errorMessage += "No valid age!\n";
        }

        if (Validator.isEmail(emailField.getText().trim())) {
            errorMessage += "No valid email!\n";
        }

        if (phoneField.getText() == null || phoneField.getText().length() == 0 || Validator.isMobile(emailField.getText())) {
            errorMessage += "No valid phone!\n";
        }

        if (passwordField.getText() == null || Validator.isPassword(emailField.getText().trim())
            || repeatPasswordField.getText() == null || Validator.isPassword(repeatPasswordField.getText().trim())
            || !passwordField.getText().trim().equals(repeatPasswordField.getText().trim())) {
            errorMessage += "No valid password!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}
