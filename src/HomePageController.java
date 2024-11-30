import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomePageController implements Initializable {

    // Variables for all GUI

    @FXML
    private Circle bbbImage, gemasImage, gepukImage, kfcImage, kfryImage, nandosImage, rbsImage, richeeseImage;

    @FXML
    private Label bbbLabel, gemasLabel, gepukLabel, kfcLabel, kfryLabel, nandosLabel, rbsLabel, richeeseLabel, displayUsername;

    @FXML
    private VBox logoutButton;

    @FXML
    private ImageView backgroundDoodle;


    // Variables for switching scene

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    UserData userData = UserData.getInstance();


    public int userChoice;
    
        //Variables to store animation for use later
    
        @Override
        public void initialize(URL location, ResourceBundle resources) {
    
            // Set Images
            Image background = new Image("/Images/homepageBackground.jpg");
            backgroundDoodle.setImage(background);
    
    
            setImage(bbbImage, "/Images/bbb.jpg");
            setImage(gemasImage, "/Images/gemas.jpg");
            setImage(gepukImage, "/Images/gepuk.jpg");
            setImage(kfcImage, "/Images/kfc.jpg");
            setImage(kfryImage, "/Images/Kfry.jpg");
            setImage(nandosImage, "/Images/nandos.jpg");
            setImage(richeeseImage, "/Images/richeese.png");
            setImage(rbsImage, "/Images/Rbs.jpg");
    
            // Add hover animations on images and labels (Orange colored)
            addHoverAnimationOrange(richeeseImage, richeeseLabel);
            addHoverAnimationOrange(rbsImage, rbsLabel);
            addHoverAnimationOrange(gepukImage, gepukLabel);
    
            // Add hover animations on images and labels (White Colored)
            addHoverAnimationWhite(kfcImage, kfcLabel);
            addHoverAnimationWhite(gemasImage, gemasLabel);
    
            // Add hover animations on images and labels (Black Colored)
            addHoverAnimationBlack(kfryImage, kfryLabel);
            addHoverAnimationBlack(nandosImage, nandosLabel);
            addHoverAnimationBlack(bbbImage, bbbLabel);
    
            //All the circles animation
            circleAnimation(bbbImage, bbbLabel);
            circleAnimation(rbsImage, rbsLabel);
            circleAnimation(richeeseImage, richeeseLabel);
            circleAnimation(nandosImage, nandosLabel);
            circleAnimation(gemasImage, gemasLabel);
            circleAnimation(kfcImage, kfcLabel);
            circleAnimation(kfryImage, kfryLabel);
            circleAnimation(gepukImage, gepukLabel);
    
            String currentUsername = userData.getRegisteredUsername();
            displayUsername.setText(currentUsername);
        }
    

    private void setImage(Circle circle, String imagePath) {
        Image icon = new Image(imagePath, false);
        circle.setFill(new ImagePattern(icon));
    }

    //Setup for stroke and scale animation

    @SuppressWarnings("unused")
    private void circleAnimation(Circle circle, Label label) {
        // Stroke transition for hover (Circle)
        StrokeTransition strokeTransitionStart = new StrokeTransition(Duration.millis(500), circle);
        strokeTransitionStart.setInterpolator(Interpolator.EASE_IN);
        strokeTransitionStart.setToValue(Color.BLACK);

        StrokeTransition strokeTransitionEnd = new StrokeTransition(Duration.millis(500), circle);
        strokeTransitionEnd.setInterpolator(Interpolator.EASE_OUT);
        strokeTransitionEnd.setToValue(Color.web("#636363"));

        // Scale transition for hover (Circle)
        ScaleTransition scaleTransitionStart = new ScaleTransition(Duration.millis(500), circle);
        scaleTransitionStart.setInterpolator(Interpolator.EASE_IN);
        scaleTransitionStart.setToX(1.1);
        scaleTransitionStart.setToY(1.1);

        ScaleTransition scaleTransitionEnd = new ScaleTransition(Duration.millis(500), circle);
        scaleTransitionEnd.setInterpolator(Interpolator.EASE_OUT);
        scaleTransitionEnd.setToX(1.0);
        scaleTransitionEnd.setToY(1.0);

        // Scale transition for hover (Label)
        ScaleTransition scaleTransitionStartLabel = new ScaleTransition(Duration.millis(500), label);
        scaleTransitionStartLabel.setInterpolator(Interpolator.EASE_IN);
        scaleTransitionStartLabel.setToX(1.1);
        scaleTransitionStartLabel.setToY(1.1);

        ScaleTransition scaleTransitionEndLabel = new ScaleTransition(Duration.millis(500), label);
        scaleTransitionEndLabel.setInterpolator(Interpolator.EASE_OUT);
        scaleTransitionEndLabel.setToX(1.0);
        scaleTransitionEndLabel.setToY(1.0);

        // Add hover listener
        circle.hoverProperty().addListener((observable, oldValue, isHovered) -> {
            if (isHovered) {
                scaleTransitionStart.play();
                strokeTransitionStart.play();
                scaleTransitionStartLabel.play();
            } else {
                scaleTransitionEnd.play();
                strokeTransitionEnd.play();
                scaleTransitionEndLabel.play();
            }
        });
        label.hoverProperty().addListener((observable, oldValue, isHovered) -> {
            if (isHovered) {
                scaleTransitionStart.play();
                strokeTransitionStart.play();
                scaleTransitionStartLabel.play();
            } else {
                scaleTransitionEnd.play();
                strokeTransitionEnd.play();
                scaleTransitionEndLabel.play();
            }
        });
    }

    //Animations for restaurant selections
    //Variables to check if the other animation is still playing to prevent bugs

    @SuppressWarnings("unused")
    private void addHoverAnimationWhite(Circle image, Label label) {

        // Listener for image hover
        image.hoverProperty().addListener((observable, oldValue, isHovered) -> {
            if (isHovered) {
                if (!label.getStyleClass().contains("restaurantLabelWhite")) {
                    label.getStyleClass().add("restaurantLabelWhite");
                }
            } else {
                label.getStyleClass().remove("restaurantLabelWhite");
            }
        });

        // Listener for label hover
        label.hoverProperty().addListener((observable, oldValue, isHovered) -> {

            if (isHovered) {
                if (!label.getStyleClass().contains("restaurantLabelWhite")) {
                    label.getStyleClass().add("restaurantLabelWhite");
                }
            } else {
                label.getStyleClass().remove("restaurantLabelWhite");
            }
        });
    }

    //Variables to check if the other animation is still playing to prevent bugs
    @SuppressWarnings("unused")
    private void addHoverAnimationBlack(Circle image, Label label) {

        // Listener for image hover
        image.hoverProperty().addListener((observable, oldValue, isHovered) -> {
            if (isHovered) {
                if (!label.getStyleClass().contains("restaurantLabelBlack")) {
                    label.getStyleClass().add("restaurantLabelBlack");
                    }
                } else {
                    label.getStyleClass().remove("restaurantLabelBlack");
            }
        });

        // Listener for label hover
        label.hoverProperty().addListener((observable, oldValue, isHovered) -> {

            if (isHovered) {
                if (!label.getStyleClass().contains("restaurantLabelBlack")) {
                    label.getStyleClass().add("restaurantLabelBlack");
                }
            } else {
                label.getStyleClass().remove("restaurantLabelBlack");
            }
        });
    }


    @SuppressWarnings("unused")
    private void addHoverAnimationOrange(Circle image, Label label) {

        // Listener for image hover
        image.hoverProperty().addListener((observable, oldValue, isHovered) -> {
            if (isHovered) {
                if (!label.getStyleClass().contains("restaurantLabelOrange")) {
                    label.getStyleClass().add("restaurantLabelOrange");
                }
            } else {
                label.getStyleClass().remove("restaurantLabelOrange");
            }
        });

        // Listener for label hover
        label.hoverProperty().addListener((observable, oldValue, isHovered) -> {

            if (isHovered) {
                if (!label.getStyleClass().contains("restaurantLabelOrange")) {
                    label.getStyleClass().add("restaurantLabelOrange");
                }
            } else {
                label.getStyleClass().remove("restaurantLabelOrange");
            }
        });
    }

    //Ends here for animations

    @FXML
    void logoutButtonClicked(MouseEvent event) throws IOException {
        Alert confirmLogout = new Alert(Alert.AlertType.CONFIRMATION);

        //Center the alert box relative to the parent window
        confirmLogout.initOwner(((Node) event.getSource()).getScene().getWindow());

        // Info texts shown
        confirmLogout.setTitle("Logout Confirmation");
        confirmLogout.setHeaderText("Are you sure you want to logout?");
        confirmLogout.showAndWait();

        
        if (confirmLogout.getResult() == ButtonType.OK) {
            root = FXMLLoader.load(getClass().getResource("/FXML/LoginOrRegisterPage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/CSS/animationMenu.css").toExternalForm());
            stage.setScene(scene);
            stage.show();

            System.out.println("User successfully login");
        }
    }


    // User selecting restaurants of choice

    @FXML
    void bbbImage_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 5; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show(); 
    }

    @FXML
    void bbbLabel_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 5; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();   
        
    }

    @FXML
    void gemasImage_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 7; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();   
        
    }

    @FXML
    void gemasLabel_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 7; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();    
        
    }

    @FXML
    void gepukImage_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 8; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void gepukLabel_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 8; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void kfcImage_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 4; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void kfcLabel_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 4; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void kfryImage_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 2; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();    
        
    }

    @FXML
    void kfryLabel_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 2; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();   
        
    }

    @FXML
    void nandosImage_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 3; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show(); 
        
    }

    @FXML
    void nandosLabel_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 3; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();   
        
    }

    @FXML
    void rbsImage_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 1; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show(); 
        
    }

    @FXML
    void rbsLabel_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 1; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void richeeseImage_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 6; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();  
        
    }

    @FXML
    void richeeseLabel_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        // Get the controller from the loader
        MenuSelection menuSelection = loader.getController();
        menuSelection.userChoice = 6; // Set the user choice in the actual controller instance
        menuSelection.setUserChoice(); // Call the method to apply visibility changes

        // Set the new scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
