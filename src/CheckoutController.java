import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CheckoutController implements Initializable {

    @FXML
    private TextArea additionalRequest;

    @FXML
    private Button backButton;

    @FXML
    private RadioButton cashOption;

    @FXML
    private TextField debitCardField;

    @FXML
    private RadioButton debitCardOption;

    @FXML
    private TextArea deliveryAddress;

    @FXML
    private ComboBox<String> deliveryOptions;

    @FXML
    private Label totalPriceLabel;

    @FXML
    private Label labelInfo;

    @FXML
    private Button placeOrder;

    @FXML
    private Button saveAddress;

    @FXML
    private CheckBox checkConfirmation;

    @FXML
    private ListView<CartItem> cartListView;

    private String[] options = {
            "Standard (30 - 45 Minutes)",
            "Priority (20 - 25 Minutes)",
            "Saver (50 - 60 Minutes)"
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        double total = CartData.getTotalPrice();
        String formattedTotal = String.format("%.2f", total);
        cartListView.setItems(CartData.getCartItems());
        totalPriceLabel.setText("Total : RM " + formattedTotal);

        deliveryOptions.getItems().addAll(options);
        debitCardField.setDisable(true);

        debitCardOption.setOnAction(event -> {
            debitCardField.setDisable(false);
            cashOption.setSelected(false);
        });

        cashOption.setOnAction(event -> {
            debitCardField.setDisable(true);
            debitCardField.clear();
            debitCardOption.setSelected(false);
        });

        // Restrict input in debitCardField to numbers only
        debitCardField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                debitCardField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        placeOrder.setDisable(true);
        checkConfirmation.setOnAction(event -> {
            placeOrder.setDisable(!checkConfirmation.isSelected());
        });
    }

    @FXML
    void clickBackButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Menu.fxml"));
        Parent root = loader.load();

        MenuSelection menuSelection = loader.getController();
        menuSelection.setUserChoice();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public String selectedDeliveryOption;
    public String selectedPaymentOption;
    public String userAddress;
    public String userAdditionalRequest;

    @FXML
    void placeOrderClicked(ActionEvent event) {
        // Reset labelInfo before validating
        labelInfo.setText("");

        // Validate all mandatory fields
        boolean valid = true;

        if (deliveryAddress.getText().isEmpty()) {
            labelInfo.setVisible(true);
            labelInfo.setText("Delivery address cannot be empty.\n");
            valid = false;
        }
        if (deliveryOptions.getValue() == null) {
            labelInfo.setVisible(true);
            labelInfo.setText(labelInfo.getText() + "Please select a delivery option.\n");
            valid = false;
        }
        if (!cashOption.isSelected() && !debitCardOption.isSelected()) {
            labelInfo.setVisible(true);
            labelInfo.setText(labelInfo.getText() + "Please select a payment option.\n");
            valid = false;
        }
        if (debitCardOption.isSelected() && debitCardField.getText().isEmpty()) {
            labelInfo.setVisible(true);
            labelInfo.setText(labelInfo.getText() + "Please enter your debit card details.\n");
            valid = false;
        }

        if (valid) {
            // Save the user's inputs
            selectedDeliveryOption = deliveryOptions.getValue();
            selectedPaymentOption = cashOption.isSelected() ? "Cash" : "Debit Card";
            userAddress = deliveryAddress.getText();
            userAdditionalRequest = additionalRequest.getText();

            try {
                // Load the next scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/DeliveryStatus.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

