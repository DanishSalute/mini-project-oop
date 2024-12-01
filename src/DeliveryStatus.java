import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DeliveryStatus implements Initializable {

    @FXML
    private ImageView backgroundDoodle;

    @FXML
    private Label deliveryStatus, deliveryOption, orderedItemsLabel, additionalDetailsLabel, totalPriceLabel;

    @FXML
    private Circle deliveryStatusImage;

    @FXML
    private ProgressBar progressBar;

    @FXML 
    private VBox homeButton;

    @FXML
    private Button collectOrderButton;

    @FXML
    private ListView<CartItem> cartList;

    UserData userData = UserData.getInstance();
    Timeline timeline = new Timeline();

    public void setCartDetails(ObservableList<CartItem> cartItems, double totalPrice, String deliveryOption, String deliveryAddress, String additionalRequest) {
        cartList.setItems(cartItems);
        String formattedTotal = String.format("%.2f", totalPrice);
        totalPriceLabel.setText("Total: RM " + formattedTotal);
        
        // Set the delivery option
        this.deliveryOption.setText(deliveryOption);
        
        if (additionalRequest == null || additionalRequest.isEmpty()) {
            additionalRequest = "No additional request";
        }

        additionalDetailsLabel.setText("Delivery Address :\n" + deliveryAddress + "\nAdditional Request: \n" + additionalRequest);
    }

    // Set images in circle
    public void images(Circle imageFrame, String imagePath) {
        Image image = new Image(imagePath, false);
        imageFrame.setFill(new ImagePattern(image));
    }

    // Immediate function
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deliveryStatusImage.setDisable(false);
        images(deliveryStatusImage, "/Images/deliveryScooter.gif");

        // Set progress bar to saved progress
        progressBar.setProgress(userData.storeProgressbar);

        // Start animation immediately
        animateProgressBar();

        // Ensures clicks are registered even on transparent areas
        homeButton.setPickOnBounds(true);
    }

    @SuppressWarnings("unused")
    private void animateProgressBar() {
        // KeyFrame that animates the progress from the current value to 1 over the remaining time
        KeyFrame keyFrame = new KeyFrame(
            Duration.seconds(60 - (60 * userData.storeProgressbar)), // Calculate remaining time
            new KeyValue(progressBar.progressProperty(), 1)
        );

        timeline.getKeyFrames().add(keyFrame);

        // Add a listener to dynamically update the deliveryStatus label
        progressBar.progressProperty().addListener((observable, oldValue, newValue) -> {
            double progress = newValue.doubleValue();
            if (progress < 0.3) {
                deliveryStatus.setText("Preparing the order");
            } else if (progress < 0.5) {
                deliveryStatus.setText("The rider is picking up your order");
            } else if (progress < 1) {
                deliveryStatus.setText("Your rider is on the way to deliver your order");
            } else {
                deliveryStatus.setText("Your rider has arrived");
                collectOrderButton.setDisable(false);
            }
        });

        // Start the timeline
        timeline.play();
    }

    @FXML
    void homeButton_CLICKED(MouseEvent event) throws IOException {
        if (timeline != null){
            timeline.stop();
            deliveryStatusImage.setDisable(true);
        }

        userData.storeProgressbar = progressBar.getProgress();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/HomePage.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        
    }

    @FXML
    void collectOrderButton_Clicked(ActionEvent event) {
        deliveryOption.setText("Thank you for ordering with us");
        deliveryStatusImage.setVisible(false);
        deliveryStatus.setText("Have a great meal!");
        
        UserData.getInstance().userOrdered = false;
        CartData.clearCart();
    }
}