import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    // Variables for buttons
    @FXML
    private Button loginButton, registerButton, accountRegisterButton;
    @FXML
    private AnchorPane loginBackgroundPage, loginForegroundSlider;
    @FXML
    private Pane loginPane, registerPane;
    @FXML
    private PasswordField loginPasswordField, registerPasswordField;
    @FXML
    private Label loginPasswordPrompt, loginUsernamePrompt, registerUsernamePrompt, registerPasswordPrompt, registerAccountLabel, infoTextU_L, infoTextP_L, infoTextU_R, infoTextP_R;
    @FXML
    private TextField loginUsernameField, registerUsernameField, registerPasswordVisible, loginPasswordVisible;
    @FXML
    private Slider sliderAccount;
    @FXML
    private ImageView doodleBackground, iconL_PasswordVisible, iconL_PasswordHidden, iconR_PasswordVisible, iconR_PasswordHidden, userPFP, infoIconU_L, infoIconP_L, infoIconU_R, infoIconP_R;


    // User Data
    public ArrayList<String> registeredUsername = new ArrayList<>();
    public ArrayList<String> registeredPassword = new ArrayList<>();


//Animation     


    // Flag to track if the slider is toggled
    private boolean isSliderMoved = false;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Hide all prompts by default
        loginUsernamePrompt.setVisible(false);
        loginPasswordPrompt.setVisible(false);
        registerUsernamePrompt.setVisible(false);
        registerPasswordPrompt.setVisible(false);
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
            sliderTransition.setByX(500);
            backgroundTransition.setByX(500);
            timeline.play();
            registerAccountLabel.setText("ALREADY HAVE AN ACCOUNT?");
            registerAccountLabel.setLayoutX(60);
            accountRegisterButton.setText("LOGIN");
        } else {
            // Move slider back to its original position
            sliderTransition.setByX(-500);
            backgroundTransition.setByX(-500);
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


//Labels


    // Making labels appear above the textfield when clicked
    @FXML
    void loginUsername_Clicked(MouseEvent event) {
        loginUsernamePrompt.setVisible(true);
        loginPasswordPrompt.setVisible(false);
        registerPasswordPrompt.setVisible(false);
        registerUsernamePrompt.setVisible(false);
    }

    @FXML
    void loginPassword_Clicked(MouseEvent event) {
        loginUsernamePrompt.setVisible(false);
        loginPasswordPrompt.setVisible(true);
        registerPasswordPrompt.setVisible(false);
        registerUsernamePrompt.setVisible(false);
    }

    @FXML
    void registerUsername_Clicked(MouseEvent event) {
        loginUsernamePrompt.setVisible(false);
        loginPasswordPrompt.setVisible(false);
        registerPasswordPrompt.setVisible(false);
        registerUsernamePrompt.setVisible(true);
    }

    @FXML
    void registerPassword_Clicked(MouseEvent event) {
        loginUsernamePrompt.setVisible(false);
        loginPasswordPrompt.setVisible(false);
        registerPasswordPrompt.setVisible(true);
        registerUsernamePrompt.setVisible(false);
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
            fadeTransitionP_L.setFromValue(1.0);
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
            fadeTransitionU_L.setFromValue(1.0);
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

            // Check if fields are empty
            if (username.isEmpty() || password.isEmpty()) {
                infoIconP_L.setVisible(true);
                infoTextP_L.setVisible(true);
                infoTextP_L.setText("All fields must be filled in");
                
                // Start the fade transitions
                fadeTransitionP_L.play();
                fadeTransitionTextP_L.play();
                return; // Exit the method to prevent further processing
            }

            // Check if the username exists in the registeredUsername list
            if (registeredUsername.contains(username)) {
                int index = registeredUsername.indexOf(username); // Find the index of the username

                // Check if the password matches the stored password
                if (registeredPassword.get(index).equals(password)) {
                    infoIconP_L.setOpacity(0.7); // Ensure the icon is visible
                    infoTextP_L.setOpacity(1.0); // Ensure the text is visible
                    infoIconP_L.setVisible(false); // Hide the prompt icon initially
                    infoTextP_L.setVisible(false); // Hide the prompt text initially

                    System.out.println("User successfully logged in");
                } else {
                    infoIconP_L.setVisible(true);
                    infoTextP_L.setVisible(true);
                    infoTextP_L.setText("Incorrect password");

                    // Start the fade transitions
                    fadeTransitionP_L.play();
                    fadeTransitionTextP_L.play();
                }
            } else {
                // Display username not found if the entered username is not in the registered list
                infoIconU_L.setVisible(true);
                infoTextU_L.setVisible(true);
                infoTextU_L.setText("Username not found");

                // Start the fade transitions
                fadeTransitionU_L.play();
                fadeTransitionTextU_L.play();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            infoIconP_L.setVisible(true);
            infoTextP_L.setVisible(true);
            infoTextP_L.setText("An unexpected error occurred: " + e.getMessage());

            // Start the fade transitions
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
            fadeTransitionP_R.setFromValue(1.0);
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
            fadeTransitionU_R.setFromValue(1.0);
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

            // Check if fields are empty
            if (newUsername.isEmpty() || newPassword.isEmpty()) {
                infoIconP_R.setVisible(true);
                infoTextP_R.setVisible(true);
                infoTextP_R.setText("All fields must be filled in");

                // Start the fade transitions
                fadeTransitionP_R.play();
                fadeTransitionTextP_R.play();
                return; // Exit the method to prevent further processing
            }

            // Check if the username already exists
            if (!registeredUsername.contains(newUsername)) {

                infoIconP_L.setOpacity(0.7); // Ensure the icon is visible
                infoTextP_L.setOpacity(1.0); // Ensure the text is visible
                infoIconP_L.setVisible(false); // Hide the prompt icon initially
                infoTextP_L.setVisible(false); // Hide the prompt text initially

                // Add username and password
                registeredUsername.add(newUsername);
                registeredPassword.add(newPassword);
                System.out.println("User successfully registered");
            } else {
                infoIconU_R.setVisible(true);
                infoTextU_R.setVisible(true);
                infoTextU_R.setText("Username already exists");

                // Start the fade transitions
                fadeTransitionU_R.play();
                fadeTransitionTextU_R.play();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            infoIconP_R.setVisible(true);
            infoTextP_R.setVisible(true);
            infoTextP_R.setText("An unexpected error occurred: " + e.getMessage());

            // Start the fade transitions
            fadeTransitionP_R.play();
            fadeTransitionTextP_R.play();
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
}
