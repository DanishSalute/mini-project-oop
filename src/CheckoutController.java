import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CheckoutController implements Initializable{

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
    private String[] options = {"Standard (30 - 45 Minutes)", "Priority (20 - 25 Minutes)", "Saver (50 - 60 Minutes)"};

    @FXML
    private Button placeOrder;

    @FXML
    private Button saveAddress;

    @FXML
    void clickBackButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deliveryOptions.getItems().addAll(options);
    }



}
