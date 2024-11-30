/*import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MenuSelectionRIP implements Initializable {

    @FXML
    private ImageView AYAMGEPUK_SETA_IMAGE;

    @FXML
    private Button AYAMGEPUK_SETA_MINUS;

    @FXML
    private Button AYAMGEPUK_SETA_PLUS;

    @FXML
    private Label AYAMGEPUK_SETA_PRICE;

    @FXML
    private Label AYAMGEPUK_SETA_TEXT;

    @FXML
    private Label AYAMGEPUK_SETA_VALUE;

    @FXML
    private ImageView AYAMGEPUK_SETB_IMAGE;

    @FXML
    private Button AYAMGEPUK_SETB_MINUS;

    @FXML
    private Button AYAMGEPUK_SETB_PLUS;

    @FXML
    private Label AYAMGEPUK_SETB_PRICE;

    @FXML
    private Label AYAMGEPUK_SETB_TEXT;

    @FXML
    private Label AYAMGEPUK_SETB_VALUE;

    @FXML
    private ImageView KFC_SET1_IMAGE;

    @FXML
    private Button KFC_SET1_MINUS;

    @FXML
    private Button KFC_SET1_PLUS;

    @FXML
    private Label KFC_SET1_PRICE;

    @FXML
    private Label KFC_SET1_TEXT;

    @FXML
    private Label KFC_SET1_VALUE;

    @FXML
    private ImageView KFC_SET2_IMAGE;

    @FXML
    private Button KFC_SET2_MINUS;

    @FXML
    private Button KFC_SET2_PLUS;

    @FXML
    private Label KFC_SET2_PRICE;

    @FXML
    private Label KFC_SET2_TEXT;

    @FXML
    private Label KFC_SET2_VALUE;

    @FXML
    private Button backfoodmenuBtn;

    @FXML
    private Button checkoutBtn;

    @FXML
    private Label purchaselist;

    @FXML
    private Label totalprice;

    private HashMap<String, Integer> cart = new HashMap<>();
    private double currentTotal = 0.0;

    private int userChoice;

    public void setUserChoice(int choice) {
        this.userChoice = choice;
        updateViewBasedOnChoice();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize with default visibility or actions if needed
        hideAllMenus();
    }

    private void updateViewBasedOnChoice() {
        if (userChoice == 1) {
            hideKfcComponents();
            showAyamGepukComponents();
        } else if (userChoice == 2) {
            hideAyamGepukComponents();
            showKfcComponents();
        }
    }

    private void addToCart(String itemName, int quantity, double price) {
        cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
        currentTotal += price * quantity;
        updateCartDisplay();
    }

    private void removeFromCart(String itemName, int quantity, double price) {
        if (cart.containsKey(itemName) && cart.get(itemName) > 0) {
            cart.put(itemName, cart.get(itemName) - quantity);
            currentTotal -= price * quantity;
            if (cart.get(itemName) <= 0) {
                cart.remove(itemName);
            }
            updateCartDisplay();
        }
    }

    private void updateCartDisplay() {
        StringBuilder cartContent = new StringBuilder();
        for (String item : cart.keySet()) {
            cartContent.append(item).append(" x").append(cart.get(item)).append("\n");
        }
        purchaselist.setText(cartContent.toString());
        totalprice.setText("Total: RM " + String.format("%.2f", currentTotal));
    }

    @FXML
    void AYAMGEPUK_SETA_MINUS_CLICKED(ActionEvent event) {
        removeFromCart("Ayam Gepuk Set A", 1, Double.parseDouble(AYAMGEPUK_SETA_PRICE.getText().replace("RM", "").trim()));
        int currentValue = Integer.parseInt(AYAMGEPUK_SETA_VALUE.getText());
        if (currentValue > 0) 
            AYAMGEPUK_SETA_VALUE.setText(String.valueOf(currentValue - 1));
    }

    @FXML
    void AYAMGEPUK_SETA_PLUS_CLICKED(ActionEvent event) {
        addToCart("Ayam Gepuk Set A", 1, Double.parseDouble(AYAMGEPUK_SETA_PRICE.getText().replace("RM", "").trim()));
        int currentValue = Integer.parseInt(AYAMGEPUK_SETA_VALUE.getText());
        AYAMGEPUK_SETA_VALUE.setText(String.valueOf(currentValue + 1));
    }

    @FXML
    void AYAMGEPUK_SETB_MINUS_CLICKED(ActionEvent event) {
        removeFromCart("Ayam Gepuk Set B", 1, Double.parseDouble(AYAMGEPUK_SETB_PRICE.getText().replace("RM", "").trim()));
        int currentValue = Integer.parseInt(AYAMGEPUK_SETB_VALUE.getText());
        if (currentValue > 0) 
            AYAMGEPUK_SETB_VALUE.setText(String.valueOf(currentValue - 1));
    }

    @FXML
    void AYAMGEPUK_SETB_PLUS_CLICKED(ActionEvent event) {
        addToCart("Ayam Gepuk Set B", 1, Double.parseDouble(AYAMGEPUK_SETB_PRICE.getText().replace("RM", "").trim()));
        int currentValue = Integer.parseInt(AYAMGEPUK_SETB_VALUE.getText());
        AYAMGEPUK_SETB_VALUE.setText(String.valueOf(currentValue + 1));
    }

    @FXML
    void KFC_SET1_MINUS_CLICKED(ActionEvent event) {
        removeFromCart("KFC Set 1", 1, Double.parseDouble(KFC_SET1_PRICE.getText().replace("RM", "").trim()));
        int currentValue = Integer.parseInt(KFC_SET1_VALUE.getText());
        if (currentValue > 0) 
            KFC_SET1_VALUE.setText(String.valueOf(currentValue - 1));
    }

    @FXML
    void KFC_SET1_PLUS_CLICKED(ActionEvent event) {
        addToCart("KFC Set 1", 1, Double.parseDouble(KFC_SET1_PRICE.getText().replace("RM", "").trim()));
        int currentValue = Integer.parseInt(KFC_SET1_VALUE.getText());
        KFC_SET1_VALUE.setText(String.valueOf(currentValue + 1));
    }

    @FXML
    void KFC_SET2_MINUS_CLICKED(ActionEvent event) {
        removeFromCart("KFC Set 2", 1, Double.parseDouble(KFC_SET2_PRICE.getText().replace("RM", "").trim()));
        int currentValue = Integer.parseInt(KFC_SET2_VALUE.getText());
        if (currentValue > 0) 
            KFC_SET2_VALUE.setText(String.valueOf(currentValue - 1));
    }

    @FXML
    void KFC_SET2_PLUS_CLICKED(ActionEvent event) {
        addToCart("KFC Set 2", 1, Double.parseDouble(KFC_SET2_PRICE.getText().replace("RM", "").trim()));
        int currentValue = Integer.parseInt(KFC_SET2_VALUE.getText());
        KFC_SET2_VALUE.setText(String.valueOf(currentValue + 1));
    }

    @FXML
    void backfoodmenuClicked(ActionEvent event) {
        // Logic to go back to the food menu
        hideAllMenus(); 
        // Show the main food menu or perform any other necessary actions
    }

    @FXML
    void checkoutButton_CLICKED(ActionEvent event) {
        // Logic to handle checkout, e.g., navigate to a checkout scene
    }

    public void showAyamGepukComponents() {
        AYAMGEPUK_SETA_IMAGE.setVisible(true);
        AYAMGEPUK_SETA_MINUS.setVisible(true);
        AYAMGEPUK_SETA_PLUS.setVisible(true);
        AYAMGEPUK_SETA_PRICE.setVisible(true);
        AYAMGEPUK_SETA_TEXT.setVisible(true);
        AYAMGEPUK_SETA_VALUE.setVisible(true);

        AYAMGEPUK_SETB_IMAGE.setVisible(true);
        AYAMGEPUK_SETB_MINUS.setVisible(true);
        AYAMGEPUK_SETB_PLUS.setVisible(true);
        AYAMGEPUK_SETB_PRICE.setVisible(true);
        AYAMGEPUK_SETB_TEXT.setVisible(true);
        AYAMGEPUK_SETB_VALUE.setVisible(true);
    }

    public void hideAyamGepukComponents() {
        AYAMGEPUK_SETA_IMAGE.setVisible(false);
        AYAMGEPUK_SETA_MINUS.setVisible(false);
        AYAMGEPUK_SETA_PLUS.setVisible(false);
        AYAMGEPUK_SETA_PRICE.setVisible(false);
        AYAMGEPUK_SETA_TEXT.setVisible(false);
        AYAMGEPUK_SETA_VALUE.setVisible(false); 
        AYAMGEPUK_SETB_IMAGE.setVisible(false);
        AYAMGEPUK_SETB_MINUS.setVisible(false);
        AYAMGEPUK_SETB_PLUS.setVisible(false);
        AYAMGEPUK_SETB_PRICE.setVisible(false);
        AYAMGEPUK_SETB_TEXT.setVisible(false);
        AYAMGEPUK_SETB_VALUE.setVisible(false);
    }

    public void showKfcComponents() {
        KFC_SET1_IMAGE.setVisible(true);
        KFC_SET1_MINUS.setVisible(true);
        KFC_SET1_PLUS.setVisible(true);
        KFC_SET1_PRICE.setVisible(true);
        KFC_SET1_TEXT.setVisible(true);
        KFC_SET1_VALUE.setVisible(true);

        KFC_SET2_IMAGE.setVisible(true);
        KFC_SET2_MINUS.setVisible(true);
        KFC_SET2_PLUS.setVisible(true);
        KFC_SET2_PRICE.setVisible(true);
        KFC_SET2_TEXT.setVisible(true);
        KFC_SET2_VALUE.setVisible(true);
    }

    public void hideKfcComponents() {
        KFC_SET1_IMAGE.setVisible(false);
        KFC_SET1_MINUS.setVisible(false);
        KFC_SET1_PLUS.setVisible(false);
        KFC_SET1_PRICE.setVisible(false);
        KFC_SET1_TEXT.setVisible(false);
        KFC_SET1_VALUE.setVisible(false);

        KFC_SET2_IMAGE.setVisible(false);
        KFC_SET2_MINUS.setVisible(false);
        KFC_SET2_PLUS.setVisible(false);
        KFC_SET2_PRICE.setVisible(false);
        KFC_SET2_TEXT.setVisible(false);
        KFC_SET2_VALUE.setVisible(false);
    }

    private void hideAllMenus() {
        hideAyamGepukComponents();
        hideKfcComponents();
    }
}  

*/