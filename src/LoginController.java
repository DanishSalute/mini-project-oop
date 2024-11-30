import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    // 
    private Stage stage;
    private Scene scene;
    private Parent root;


    // Variables for buttons
    @FXML
    private Button loginButton, registerButton, accountRegisterButton, buttonConfirmLogin_YES, buttonConfirmLogin_NO;
    @FXML
    private AnchorPane loginBackgroundPage, loginForegroundSlider;
    @FXML
    private Pane loginPane, registerPane, ConfirmLogin_PANE;
    @FXML
    private PasswordField loginPasswordField, registerPasswordField;
    @FXML
    private Label loginPasswordPrompt, loginUsernamePrompt, registerUsernamePrompt, registerPasswordPrompt, registerAccountLabel, infoTextU_L, infoTextP_L, infoTextU_R, infoTextP_R, displayUsername;
    @FXML
    private TextField loginUsernameField, registerUsernameField, registerPasswordVisible, loginPasswordVisible;
    @FXML
    private Slider sliderAccount;
    @FXML
    private ImageView doodleBackground, iconL_PasswordVisible, iconL_PasswordHidden, iconR_PasswordVisible, iconR_PasswordHidden, userPFP, infoIconU_L, infoIconP_L, infoIconU_R, infoIconP_R, logoFrame;



    // User Data
    public ArrayList<String> registeredUsername = new ArrayList<>();
    public ArrayList<String> registeredPassword = new ArrayList<>();
    int indexOfCurrentUser;
    

//Animation     


    // Flag to track if the slider is toggled
    private boolean isSliderMoved = false;
    

//Labels


    // Making labels appear above the textfield when clicked

    @SuppressWarnings("unused")
@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    // Hide all prompts by default
    loginUsernamePrompt.setVisible(false);
    loginPasswordPrompt.setVisible(false);
    registerUsernamePrompt.setVisible(false);
    registerPasswordPrompt.setVisible(false);

    // Add focus listeners to show/hide prompts based on which field is focused
    loginUsernameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
        loginUsernamePrompt.setVisible(newValue);
        loginPasswordPrompt.setVisible(false);
        registerUsernamePrompt.setVisible(false);
        registerPasswordPrompt.setVisible(false);
    });

    loginPasswordField.focusedProperty().addListener((observable, oldValue, newValue) -> {
        loginPasswordPrompt.setVisible(newValue);
        loginUsernamePrompt.setVisible(false);
        registerUsernamePrompt.setVisible(false);
        registerPasswordPrompt.setVisible(false);
    });

    loginPasswordVisible.focusedProperty().addListener((observable, oldValue, newValue) -> {
        loginPasswordPrompt.setVisible(newValue);
        loginUsernamePrompt.setVisible(false);
        registerUsernamePrompt.setVisible(false);
        registerPasswordPrompt.setVisible(false);
    });

    registerUsernameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
        registerUsernamePrompt.setVisible(newValue);
        loginUsernamePrompt.setVisible(false);
        loginPasswordPrompt.setVisible(false);
        registerPasswordPrompt.setVisible(false);
    });

    registerPasswordField.focusedProperty().addListener((observable, oldValue, newValue) -> {
        registerPasswordPrompt.setVisible(newValue);
        loginUsernamePrompt.setVisible(false);
        loginPasswordPrompt.setVisible(false);
        registerUsernamePrompt.setVisible(false);
    });

    registerPasswordVisible.focusedProperty().addListener((observable, oldValue, newValue) -> {
        registerPasswordPrompt.setVisible(newValue);
        loginUsernamePrompt.setVisible(false);
        loginPasswordPrompt.setVisible(false);
        registerUsernamePrompt.setVisible(false);
    });

    // Set images for background and logo
    Image logo = new Image("/Images/LOGO-removebg-preview.png");
    logoFrame.setImage(logo);
    Image doodle = new Image("/Images/cropped-LoginPageBackground.jpg");
    doodleBackground.setImage(doodle);
    

}

    
    //Slide animation    
    @SuppressWarnings("unused")
    @FXML
    void accountButton_Clicked(ActionEvent event) {
        // Disable the button while animation is running
        accountRegisterButton.setDisable(true);

        // Target value for the slider animation
        DoubleProperty targetValue = sliderAccount.valueProperty();
        KeyValue kvstart1 = new KeyValue(targetValue, 500);
        KeyValue kvend1 = new KeyValue(targetValue, 0);

        // Keyframe for slider
        KeyFrame kfstart1 = new KeyFrame(Duration.millis(500), kvstart1);
        KeyFrame kfEnd1 = new KeyFrame(Duration.millis(500), kvend1);
        Timeline timeline = new Timeline(kfstart1, kfstart1);
        Timeline timeline2 = new Timeline(kfEnd1, kfEnd1);

        // Orange foreground animation
        TranslateTransition sliderTransition = new TranslateTransition();
        sliderTransition.setNode(loginForegroundSlider);
        sliderTransition.setDuration(Duration.millis(500));
        sliderTransition.setInterpolator(Interpolator.EASE_OUT);

        // Motion blur effect
        javafx.scene.effect.MotionBlur motionBlur = new javafx.scene.effect.MotionBlur();
        motionBlur.setRadius(0); // Initial blur radius

        // Background animation
        TranslateTransition backgroundTransition = new TranslateTransition();
        backgroundTransition.setNode(doodleBackground);
        backgroundTransition.setDuration(Duration.millis(500));
        backgroundTransition.setInterpolator(Interpolator.EASE_OUT);

        // Blur animation
        Timeline blurTimeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(motionBlur.radiusProperty(), 0)),
            new KeyFrame(Duration.millis(250), new KeyValue(motionBlur.radiusProperty(), 20)),
            new KeyFrame(Duration.millis(500), new KeyValue(motionBlur.radiusProperty(), 0))
        );

        loginBackgroundPage.setEffect(motionBlur);

        if (!isSliderMoved) {
            // Move slider to the right
            sliderTransition.setByX(743);
            backgroundTransition.setByX(743);
            timeline.play();
            registerAccountLabel.setText("ALREADY HAVE AN ACCOUNT?");
            registerAccountLabel.setLayoutX(60);
            accountRegisterButton.setText("LOGIN");
        } else {
            // Move slider back to its original position
            sliderTransition.setByX(-743);
            backgroundTransition.setByX(-743);
            timeline2.play();
            registerAccountLabel.setText("DON'T HAVE AN ACCOUNT?");
            registerAccountLabel.setLayoutX(86);
            accountRegisterButton.setText("REGISTER");
        }

        // Play animations
        blurTimeline.play();
        sliderTransition.play();
        backgroundTransition.play();

        // Re-enable the button after the animation finishes
        sliderTransition.setOnFinished(animationEvent -> accountRegisterButton.setDisable(false));

        isSliderMoved = !isSliderMoved; // Toggle the state
    }


//Login function


    // Fade transition for infoicon and text
    private FadeTransition fadeTransitionP_L;
    private FadeTransition fadeTransitionTextP_L;
    private FadeTransition fadeTransitionU_L;
    private FadeTransition fadeTransitionTextU_L;

    // Login button function
    @FXML
    void loginButton_Clicked(ActionEvent event) {
        // If the fade transitions are not created, create them only once
        if (fadeTransitionP_L == null) {
            fadeTransitionP_L = new FadeTransition(Duration.seconds(5), infoIconP_L);
            fadeTransitionP_L.setFromValue(0.7);
            fadeTransitionP_L.setToValue(0.0);
            fadeTransitionP_L.setCycleCount(1);
            fadeTransitionP_L.setDelay(Duration.seconds(2));
        }
        if (fadeTransitionTextP_L == null) {
            fadeTransitionTextP_L = new FadeTransition(Duration.seconds(5), infoTextP_L);
            fadeTransitionTextP_L.setFromValue(1.0);
            fadeTransitionTextP_L.setToValue(0.0);
            fadeTransitionTextP_L.setCycleCount(1);
            fadeTransitionTextP_L.setDelay(Duration.seconds(2));
        }
        if (fadeTransitionU_L == null) {
            fadeTransitionU_L = new FadeTransition(Duration.seconds(5), infoIconU_L);
            fadeTransitionU_L.setFromValue(0.7);
            fadeTransitionU_L.setToValue(0.0);
            fadeTransitionU_L.setCycleCount(1);
            fadeTransitionU_L.setDelay(Duration.seconds(2));
        }
        if (fadeTransitionTextU_L == null) {
            fadeTransitionTextU_L = new FadeTransition(Duration.seconds(5), infoTextU_L);
            fadeTransitionTextU_L.setFromValue(1.0);
            fadeTransitionTextU_L.setToValue(0.0);
            fadeTransitionTextU_L.setCycleCount(1);
            fadeTransitionTextU_L.setDelay(Duration.seconds(2));
        }

        // Stop any active transitions before starting the new ones
        fadeTransitionP_L.stop();
        fadeTransitionTextP_L.stop();
        fadeTransitionU_L.stop();
        fadeTransitionTextU_L.stop();

        // Reset the values to start fresh (if necessary)
        infoIconP_L.setOpacity(0.7);
        infoTextP_L.setOpacity(1.0);
        infoIconU_L.setOpacity(0.7);
        infoTextU_L.setOpacity(1.0);

        try {
            String username = loginUsernameField.getText();
            String password = loginPasswordField.isVisible() ? loginPasswordField.getText() : loginPasswordVisible.getText();

            // Access shared user data
            UserData userData = UserData.getInstance();

            // Check if fields are empty
            if (username.isEmpty() || password.isEmpty()) {
                infoIconP_L.setVisible(true);
                infoTextP_L.setVisible(true);
                infoTextP_L.setText("All fields must be filled in");

                fadeTransitionP_L.play();
                fadeTransitionTextP_L.play();
                return;
            }

            // Check if the username exists in the registeredUsername list
            if (userData.registeredUsername.contains(username)) {
                int index = userData.registeredUsername.indexOf(username); // Find the index of the username

                // Check if the password matches the stored password
                if (userData.registeredPassword.get(index).equals(password)) {
                    // Save the index of the current user in the shared data class
                    userData.setIndexOfCurrentUser(index);

                    String currentUsername = userData.registeredUsername.get(userData.getIndexOfCurrentUser());

                    infoIconP_L.setVisible(false);
                    infoTextP_L.setVisible(false);
                    infoIconU_L.setVisible(false);
                    infoTextU_L.setVisible(false);

                    // Display the logged-in user's username
                    loginPane.setVisible(false);
                    displayUsername.setText(currentUsername);
                    ConfirmLogin_PANE.setVisible(true);

                } else {
                    // Incorrect password
                    infoIconP_L.setVisible(true);
                    infoTextP_L.setVisible(true);
                    infoTextP_L.setText("Incorrect password");

                    infoIconU_L.setVisible(false);
                    infoTextU_L.setVisible(false);

                    loginPasswordField.setText(null);
                    loginPasswordVisible.setText(null);

                    fadeTransitionP_L.play();
                    fadeTransitionTextP_L.play();
                }
            } else {
                // Username not found
                infoIconU_L.setVisible(true);
                infoTextU_L.setVisible(true);
                infoTextU_L.setText("Username not found");

                infoIconP_L.setVisible(false);
                infoTextP_L.setVisible(false);

                fadeTransitionU_L.play();
                fadeTransitionTextU_L.play();

                loginUsernameField.setText(null);
                loginPasswordField.setText(null);
                loginPasswordVisible.setText(null);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            infoIconP_L.setVisible(true);
            infoTextP_L.setVisible(true);
            infoTextP_L.setText("An unexpected error occurred");

            System.out.println(e.getMessage());

            fadeTransitionP_L.play();
            fadeTransitionTextP_L.play();
        }
    }



//Register function

    // Fade transition for infoicon and text (Register)
    private FadeTransition fadeTransitionP_R;
    private FadeTransition fadeTransitionTextP_R;
    private FadeTransition fadeTransitionU_R;
    private FadeTransition fadeTransitionTextU_R;

    // Register button function
    @FXML
    void registerButton_Clicked(ActionEvent event) {
        // If the fade transitions are not created, create them only once
        if (fadeTransitionP_R == null) {
            fadeTransitionP_R = new FadeTransition(Duration.seconds(5), infoIconP_R);
            fadeTransitionP_R.setFromValue(0.7);
            fadeTransitionP_R.setToValue(0.0);
            fadeTransitionP_R.setCycleCount(1);
            fadeTransitionP_R.setDelay(Duration.seconds(2));
        }
        if (fadeTransitionTextP_R == null) {
            fadeTransitionTextP_R = new FadeTransition(Duration.seconds(5), infoTextP_R);
            fadeTransitionTextP_R.setFromValue(1.0);
            fadeTransitionTextP_R.setToValue(0.0);
            fadeTransitionTextP_R.setCycleCount(1);
            fadeTransitionTextP_R.setDelay(Duration.seconds(2));
        }
        if (fadeTransitionU_R == null) {
            fadeTransitionU_R = new FadeTransition(Duration.seconds(5), infoIconU_R);
            fadeTransitionU_R.setFromValue(0.7);
            fadeTransitionU_R.setToValue(0.0);
            fadeTransitionU_R.setCycleCount(1);
            fadeTransitionU_R.setDelay(Duration.seconds(2));
        }
        if (fadeTransitionTextU_R == null) {
            fadeTransitionTextU_R = new FadeTransition(Duration.seconds(5), infoTextU_R);
            fadeTransitionTextU_R.setFromValue(1.0);
            fadeTransitionTextU_R.setToValue(0.0);
            fadeTransitionTextU_R.setCycleCount(1);
            fadeTransitionTextU_R.setDelay(Duration.seconds(2));
        }

        // Stop any active transitions before starting the new ones
        fadeTransitionP_R.stop();
        fadeTransitionTextP_R.stop();
        fadeTransitionU_R.stop();
        fadeTransitionTextU_R.stop();

        // Reset the values to start fresh (if necessary)
        infoIconP_R.setOpacity(0.7);
        infoTextP_R.setOpacity(1.0);
        infoIconU_R.setOpacity(0.7);
        infoTextU_R.setOpacity(1.0);

        try {
            String newUsername = registerUsernameField.getText();
            String newPassword = registerPasswordField.isVisible() ? registerPasswordField.getText() : registerPasswordVisible.getText();

            int usernameFieldLength = newUsername.length();
            int passwordFieldLength = newPassword.length();

            // Access shared user data
            UserData userData = UserData.getInstance();

            // Check if fields are empty
            if (newUsername.isEmpty() || newPassword.isEmpty()) {
                infoIconP_R.setVisible(true);
                infoTextP_R.setVisible(true);
                infoTextP_R.setText("All fields must be filled in");

                infoIconU_R.setVisible(false);
                infoTextU_R.setVisible(false);

                fadeTransitionP_R.play();
                fadeTransitionTextP_R.play();
                return;
            }

            // Check username length
            if (usernameFieldLength <= 8) {
                infoIconU_R.setVisible(true);
                infoTextU_R.setVisible(true);
                infoTextU_R.setText("Username must be more than 8 characters");

                infoIconP_R.setVisible(false);
                infoTextP_R.setVisible(false);

                fadeTransitionU_R.play();
                fadeTransitionTextU_R.play();
                return;
            }

            // Check password length
            if (passwordFieldLength <= 8) {
                infoIconP_R.setVisible(true);
                infoTextP_R.setVisible(true);
                infoTextP_R.setText("Password must be more than 8 characters");

                infoIconU_R.setVisible(false);
                infoTextU_R.setVisible(false);

                fadeTransitionP_R.play();
                fadeTransitionTextP_R.play();
                return;
            }

            // Check if username already exists
            if (userData.registeredUsername.contains(newUsername)) {
                infoIconU_R.setVisible(true);
                infoTextU_R.setVisible(true);
                infoTextU_R.setText("Username already exists");

                infoIconP_R.setVisible(false);
                infoTextP_R.setVisible(false);

                fadeTransitionU_R.play();
                fadeTransitionTextU_R.play();

                registerUsernameField.setText(null);
                registerPasswordField.setText(null);
                registerPasswordVisible.setText(null);
                return;
            }

            // Success: Add user data
            userData.registeredUsername.add(newUsername);
            userData.registeredPassword.add(newPassword);

            // Reset input fields
            registerUsernameField.setText(null);
            registerPasswordField.setText(null);
            registerPasswordVisible.setText(null);

            infoIconP_R.setVisible(false);
            infoTextP_R.setVisible(false);
            infoIconU_R.setVisible(false);
            infoTextU_R.setVisible(false);

            fadeTransitionU_R.stop();
            fadeTransitionP_R.stop();
            fadeTransitionTextP_R.stop();
            fadeTransitionTextU_R.stop();

            // Show success alert
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.initOwner(((Node) event.getSource()).getScene().getWindow());
            info.setTitle("Registration Confirmed");
            info.setHeaderText("User successfully registered");
            info.setContentText("May you have a delightful day");
            info.showAndWait();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }



//Hide password


    //Password Icon Visible or not function
    @FXML
    void iconL_HiddenClicked(MouseEvent event) {
        // Switching icons
        iconL_PasswordHidden.setVisible(false);
        iconL_PasswordVisible.setVisible(true);

        // Disable and enable appropriate icons
        iconL_PasswordHidden.setDisable(true);
        iconL_PasswordVisible.setDisable(false);

        // Switch field visibility for password
        loginPasswordVisible.setVisible(true);
        loginPasswordField.setVisible(false);

        // Disable and enable text fields
        loginPasswordField.setDisable(true);
        loginPasswordVisible.setDisable(false);

        // Ensure password field content is synchronized
        loginPasswordVisible.setText(loginPasswordField.getText());
    }

    @FXML
    void iconL_VisibleClicked(MouseEvent event) {
        // Switching icons
        iconL_PasswordHidden.setVisible(true);
        iconL_PasswordVisible.setVisible(false);

        // Disable and enable appropriate icons
        iconL_PasswordHidden.setDisable(false);
        iconL_PasswordVisible.setDisable(true);

        // Switch field visibility for password
        loginPasswordVisible.setVisible(false);
        loginPasswordField.setVisible(true);

        // Disable and enable text fields
        loginPasswordField.setDisable(false);
        loginPasswordVisible.setDisable(true);

        // Ensure password field content is synchronized
        loginPasswordField.setText(loginPasswordVisible.getText());
    }

    @FXML
    void iconR_HiddenClicked(MouseEvent event) {
        // Switching icons
        iconR_PasswordHidden.setVisible(false);
        iconR_PasswordVisible.setVisible(true);

        // Disable and enable appropriate icons
        iconR_PasswordHidden.setDisable(true);
        iconR_PasswordVisible.setDisable(false);

        // Switch field visibility for password
        registerPasswordVisible.setVisible(true);
        registerPasswordField.setVisible(false);

        // Disable and enable text fields
        registerPasswordField.setDisable(true);
        registerPasswordVisible.setDisable(false);

        // Ensure password field content is synchronized
        registerPasswordVisible.setText(registerPasswordField.getText());
    }

    @FXML
    void iconR_VisibleClicked(MouseEvent event) {
        // Switching icons
        iconR_PasswordHidden.setVisible(true);
        iconR_PasswordVisible.setVisible(false);

        // Disable and enable appropriate icons
        iconR_PasswordHidden.setDisable(false);
        iconR_PasswordVisible.setDisable(true);

        // Switch field visibility for password
        registerPasswordVisible.setVisible(false);
        registerPasswordField.setVisible(true);

        // Disable and enable text fields
        registerPasswordField.setDisable(false);
        registerPasswordVisible.setDisable(true);

        // Ensure password field content is synchronized
        registerPasswordField.setText(registerPasswordVisible.getText());
    }

// If the user clicked one of the buttons during login confirmation

    // When user clicked no

    @FXML
    void buttonConfirmLogin_NO_Clicked(ActionEvent event) {
        ConfirmLogin_PANE.setVisible(false);
        loginPane.setVisible(true);

        loginUsernameField.setText(null);
        loginPasswordField.setText(null);
        loginPasswordVisible.setText(null);

    }

    // When user clicked yes

    @FXML
    void buttonConfirmLogin_YES_Clicked(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML/HomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/CSS/animationMenu.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        System.out.println("User successfully login");
    }



// Tweak for better user interaction
// When hitting enter user navigate to the next field without needing to move the cursor and click which saves a lot of time

    @FXML
    void loginUsername_ENTER(ActionEvent event) {
        if (loginPasswordField.isVisible()) {
            loginPasswordField.requestFocus();
        }
        else if (loginPasswordVisible.isVisible()) {
            loginPasswordVisible.requestFocus();
        }
    }

    @FXML
    void loginPasswordField_ENTER(ActionEvent event){
        loginButton_Clicked(event);
    }

    @FXML
    void loginPasswordVisible_ENTER(ActionEvent event){
        loginButton_Clicked(event);
    }

    @FXML
    void registerUsername_ENTER(ActionEvent event){
        if (registerPasswordField.isVisible()) {
            registerPasswordField.requestFocus();
        }
        else if (registerPasswordVisible.isVisible()) {
            registerPasswordVisible.requestFocus();
        }
    }

    @FXML
    void registerPasswordField_ENTER(ActionEvent event){
        registerButton_Clicked(event);
    }

    @FXML
    void registerPasswordVisible_ENTER(ActionEvent event){
        registerButton_Clicked(event);
    }
}