import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HomePageController implements Initializable {

    @FXML
    private Circle bbbImage, gemasImage, gepukImage, kfcImage, kfryImage, nandosImage, rbsImage, richeeseImage;

    @FXML
    private Label bbbLabel, gemasLabel, gepukLabel, kfcLabel, kfryLabel, nandosLabel, rbsLabel, richeeseLabel;

    @FXML
    private VBox logoutButton;


    //Variables to store animation for use later

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Set Images
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
        circleAnimation(bbbImage);
        circleAnimation(rbsImage);
        circleAnimation(richeeseImage);
        circleAnimation(nandosImage);
        circleAnimation(gemasImage);
        circleAnimation(kfcImage);
        circleAnimation(kfryImage);
        circleAnimation(gepukImage);
        
    }


    private void setImage(Circle circle, String imagePath) {
        Image icon = new Image(imagePath, false);
        circle.setFill(new ImagePattern(icon));
    }

    //Setup for stroke and scale animation

    @SuppressWarnings("unused")
    private void circleAnimation(Circle circle) {
        // Stroke transition for hover
        StrokeTransition strokeTransitionStart = new StrokeTransition(Duration.millis(500), circle);
        strokeTransitionStart.setInterpolator(Interpolator.EASE_IN);
        strokeTransitionStart.setToValue(Color.BLACK);
    
        // Stroke transition for mouse leave
        StrokeTransition strokeTransitionEnd = new StrokeTransition(Duration.millis(500), circle);
        strokeTransitionEnd.setInterpolator(Interpolator.EASE_OUT);
        strokeTransitionEnd.setToValue(Color.web("#636363"));
    
        // Scale transition for hover
        ScaleTransition scaleTransitionStart = new ScaleTransition(Duration.millis(500), circle);
        scaleTransitionStart.setInterpolator(Interpolator.EASE_IN);
        scaleTransitionStart.setToX(1.1);
        scaleTransitionStart.setToY(1.1);
    
        // Scale transition for mouse leave
        ScaleTransition scaleTransitionEnd = new ScaleTransition(Duration.millis(500), circle);
        scaleTransitionEnd.setInterpolator(Interpolator.EASE_OUT);
        scaleTransitionEnd.setToX(1.0);
        scaleTransitionEnd.setToY(1.0);
    
        // Add hover listener
        circle.hoverProperty().addListener((observable, oldValue, isHovered) -> {
            if (isHovered) {
                scaleTransitionStart.play();
                strokeTransitionStart.play();
            } else {
                scaleTransitionEnd.play();
                strokeTransitionEnd.play();
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
    void logoutButtonClicked(MouseEvent event) {

    }
}
