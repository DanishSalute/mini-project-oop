import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuSelection {

    @FXML
    private HBox AG_SETA_HBOX, AG_SETB_HBOX, AG_SETC_HBOX;
    @FXML
    private HBox BBB_SETA_HBOX, BBB_SETB_HBOX, BBB_SETC_HBOX;
    @FXML
    private HBox GEMAS_SETA_HBOX, GEMAS_SETB_HBOX, GEMAS_SETC_HBOX;
    @FXML
    private HBox KFC_SETA_HBOX, KFC_SETB_HBOX, KFC_SETC_HBOX;
    @FXML
    private HBox KFRY_SETA_HBOX, KFRY_SETB_HBOX, KFRY_SETC_HBOX;
    @FXML
    private HBox NANDOS_SETA_HBOX, NANDOS_SETB_HBOX, NANDOS_SETC_HBOX;
    @FXML
    private HBox RBS_SETA_HBOX, RBS_SETB_HBOX, RBS_SETC_HBOX;
    @FXML
    private HBox RICHEESE_SETA_HBOX, RICHEESE_SETB_HBOX, RICHEESE_SETC_HBOX;

    @FXML
    private Button AG_SETA_MINUS, AG_SETA_PLUS, AG_SETB_MINUS, AG_SETB_PLUS, AG_SETC_MINUS, AG_SETC_PLUS;
    @FXML
    private Button BBB_SETA_MINUS, BBB_SETA_PLUS, BBB_SETB_MINUS, BBB_SETB_PLUS, BBB_SETC_MINUS, BBB_SETC_PLUS;
    @FXML
    private Button GEMAS_SETA_MINUS, GEMAS_SETA_PLUS, GEMAS_SETB_MINUS, GEMAS_SETB_PLUS, GEMAS_SETC_MINUS;
    @FXML
    private Button KFC_SETA_MINUS, KFC_SETA_PLUS, KFC_SETB_MINUS, KFC_SETB_PLUS, KFC_SETC_MINUS, KFC_SETC_PLUS;
    @FXML
    private Button KFRY_SETA_MINUS, KFRY_SETB_MINUS, KFRY_SETB_PLUS, KFRY_SETC_MINUS, KFRY_SETC_PLUS;
    @FXML
    private Button NANDOS_SETA_MINUS, NANDOS_SETA_PLUS, NANDOS_SETB_MINUS, NANDOS_SETB_PLUS, NANDOS_SETC_MINUS, NANDOS_SETC_PLUS;
    @FXML
    private Button RBS_SETA_MINUS, RBS_SETA_PLUS, RBS_SETB_MINUS, RBS_SETB_PLUS, RBS_SETC_MINUS, RBS_SETC_PLUS;
    @FXML
    private Button RICHEESE_SETA_MINUS, RICHEESE_SETA_PLUS, RICHEESE_SETB_MINUS, RICHEESE_SETB_PLUS, RICHEESE_SETC_MINUS, RICHEESE_SETC_PLUS;
    @FXML
    private Button backButton, checkOut_Btn;

    @FXML
    private Label AG_SETA_QUANTITY, AG_SETB_QUANTITY, AG_SETC_QUANTITY;
    @FXML
    private Label BBB_SETA_QUANTITY, BBB_SETB_QUANTITY, BBB_SETC_QUANTITY;
    @FXML
    private Label GEMAS_SETA_QUANTITY, GEMAS_SETB_QUANTITY, GEMAS_SETC_QUANTITY;
    @FXML
    private Label KFC_SETA_QUANTITY, KFC_SETB_QUANTITY, KFC_SETC_QUANTITY;
    @FXML
    private Label KFRY_SETA_QUANTITY, KFRY_SETB_QUANTITY, KFRY_SETC_QUANTITY;
    @FXML
    private Label NANDOS_SETA_QUANTITY, NANDOS_SETB_QUANTITY, NANDOS_SETC_QUANTITY;
    @FXML
    private Label RBS_SETA_QUANTITY, RBS_SETB_QUANTITY, RBS_SETC_QUANTITY;
    @FXML
    private Label RICHEESE_SETA_QUANTITY, RICHEESE_SETB_QUANTITY, RICHEESE_SETC_QUANTITY;

    public int userChoice;

    public void setUserChoice(){
        switch (userChoice) {
            case 1:
                //RBS
                RBS_SETA_HBOX.setVisible(true);
                RBS_SETB_HBOX.setVisible(true);
                RBS_SETC_HBOX.setVisible(true);
                break;
            case 2:
                //KFRY
                KFRY_SETA_HBOX.setVisible(true);
                KFRY_SETB_HBOX.setVisible(true);
                KFRY_SETC_HBOX.setVisible(true);
                break;
            case 3:
                //NANDOS
                NANDOS_SETA_HBOX.setVisible(true);
                NANDOS_SETB_HBOX.setVisible(true);
                NANDOS_SETC_HBOX.setVisible(true);
                break;
            case 4:
                //KFC
                KFC_SETA_HBOX.setVisible(true);
                KFC_SETB_HBOX.setVisible(true);
                KFC_SETC_HBOX.setVisible(true);
                break;
            case 5:
                //BBB
                BBB_SETA_HBOX.setVisible(true);
                BBB_SETB_HBOX.setVisible(true);
                BBB_SETC_HBOX.setVisible(true);
                break;
            case 6:
                //RICHEESE
                RICHEESE_SETA_HBOX.setVisible(true);
                RICHEESE_SETB_HBOX.setVisible(true);
                RICHEESE_SETC_HBOX.setVisible(true);
                break;
            case 7:
                //GEMAS
                GEMAS_SETA_HBOX.setVisible(true);
                GEMAS_SETB_HBOX.setVisible(true);
                GEMAS_SETC_HBOX.setVisible(true);
                break;
            case 8:
                //GEPUK
                AG_SETA_HBOX.setVisible(true);
                AG_SETB_HBOX.setVisible(true);
                AG_SETC_HBOX.setVisible(true);
                break;
            default:
                break;
        }
    }

    @FXML
    private ListView<CartItem> cartListView; // ListView to display the cart
    @FXML
    private Label totalPriceLabel; // Label to display total price

    public void initialize() {
        // Bind the cartListView directly to the shared CartData's cartItems
        cartListView.setItems(CartData.getCartItems());
        updateTotalPrice();

        // Debugging: Ensure cartListView correctly reflects shared CartData
        System.out.println("Cart initialized with items: " + CartData.getCartItems());
    }

    private void updateTotalPrice() {
        double totalPrice = CartData.getCartItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        String priceFormatted = String.format("%.2f", totalPrice);
        totalPriceLabel.setText("Total: RM" + priceFormatted);

        // Update shared total price in CartData
        CartData.setTotalPrice(totalPrice);
    }

    private void addItemToCart(String itemName, double itemPrice, int deltaQuantity) {
        // Use the shared cartItems directly for all updates
        ObservableList<CartItem> cartItems = CartData.getCartItems();

        // Debugging: Print the current state of the cart
        System.out.println("Current cart items before update: " + cartItems);

        // Check if the cart is empty and we are trying to remove an item
        if (cartItems.isEmpty() && deltaQuantity < 1) {
            return; // Prevent removing items from an empty cart
        }

        // Iterate through existing cart items to check if the item already exists
        for (CartItem item : cartItems) {
            if (item.getName().equals(itemName)) {
                int newQuantity = item.getQuantity() + deltaQuantity;
                if (newQuantity <= 0) {
                    cartItems.remove(item); // Remove the item if the quantity becomes 0
                    System.out.println("Removed item: " + itemName);
                } else {
                    item.setQuantity(newQuantity); // Update the quantity
                    System.out.println("Updated item: " + itemName + " to quantity: " + newQuantity);
                }
                cartListView.refresh(); // Refresh the ListView
                updateTotalPrice(); // Update the total price
                return;
            }
        }

        // If the item does not exist and the deltaQuantity is positive, add it to the cart
        if (deltaQuantity > 0) {
            cartItems.add(new CartItem(itemName, itemPrice, deltaQuantity));
            System.out.println("Added new item: " + itemName + " with quantity: " + deltaQuantity);
            updateTotalPrice(); // Update the total price
        }
    }


    // Variables to store quantities for Ayam Gepuk (AG)
    public int ag_setA_Quantity;
    public int ag_setB_Quantity;
    public int ag_setC_Quantity;

    // Variables to store quantities for BBB
    public int bbb_setA_Quantity;
    public int bbb_setB_Quantity;
    public int bbb_setC_Quantity;

    // Variables to store quantities for GEMAS
    public int gemas_setA_Quantity;
    public int gemas_setB_Quantity;
    public int gemas_setC_Quantity;

    // Variables to store quantities for KFC
    public int kfc_setA_Quantity;
    public int kfc_setB_Quantity;
    public int kfc_setC_Quantity;

    // Variables to store quantities for KFRY
    public int kfry_setA_Quantity;
    public int kfry_setB_Quantity;
    public int kfry_setC_Quantity;

    // Variables to store quantities for Nandos
    public int nandos_setA_Quantity;
    public int nandos_setB_Quantity;
    public int nandos_setC_Quantity;

    // Variables to store quantities for RBS
    public int rbs_setA_Quantity;
    public int rbs_setB_Quantity;
    public int rbs_setC_Quantity;

    // Variables to store quantities for Richeese
    public int richeese_setA_Quantity;
    public int richeese_setB_Quantity;
    public int richeese_setC_Quantity;

    //AYAM GEPUK

    @FXML
    void AG_SETA_PLUS_Click(ActionEvent event) {
        addItemToCart("Ayam Gepuk SET A", 11.90, 1);
        ag_setA_Quantity++;
        AG_SETA_QUANTITY.setText(String.valueOf(ag_setA_Quantity));
    }

    @FXML
    void AG_SETA_MINUS_Click(ActionEvent event) {
        if (ag_setA_Quantity > 0) { // Check if quantity is greater than 0
            addItemToCart("Ayam Gepuk SET A", 11.90, -1);
            ag_setA_Quantity--;
            AG_SETA_QUANTITY.setText(String.valueOf(ag_setA_Quantity));
        }
    }

    @FXML
    void AG_SETB_PLUS_Click(ActionEvent event) {
        addItemToCart("Ayam Gepuk SET B", 12.90, 1);
        ag_setB_Quantity++;
        AG_SETB_QUANTITY.setText(String.valueOf(ag_setB_Quantity));
    }

    @FXML
    void AG_SETB_MINUS_Click(ActionEvent event) {
        if (ag_setB_Quantity > 0) { // Check if quantity is greater than 0
            addItemToCart("Ayam Gepuk SET B", 12.90, -1);
            ag_setB_Quantity--;
            AG_SETB_QUANTITY.setText(String.valueOf(ag_setB_Quantity));
        }
    }

    @FXML
    void AG_SETC_PLUS_Click(ActionEvent event) {
        addItemToCart("Ayam Gepuk SET C", 13.90, 1);
        ag_setC_Quantity++;
        AG_SETC_QUANTITY.setText(String.valueOf(ag_setC_Quantity));
    }

    @FXML
    void AG_SETC_MINUS_Click(ActionEvent event) {
        if (ag_setC_Quantity > 0) { // Check if quantity is greater than 0
            addItemToCart("Ayam Gepuk SET C", 13.90, -1);
            ag_setC_Quantity--;
            AG_SETC_QUANTITY.setText(String.valueOf(ag_setC_Quantity));
        }
    }

    // BBB
    @FXML
    void BBB_SETA_PLUS_Click(ActionEvent event) {
        addItemToCart("Tom Yam Campur", 8.90, 1);
        bbb_setA_Quantity++;
        BBB_SETA_QUANTITY.setText(String.valueOf(bbb_setA_Quantity));
    }

    @FXML
    void BBB_SETA_MINUS_Click(ActionEvent event) {
        if (bbb_setA_Quantity > 0) { // Check if quantity is greater than 0
            addItemToCart("Tom Yam Campur", 8.90, -1);
            bbb_setA_Quantity--;
            BBB_SETA_QUANTITY.setText(String.valueOf(bbb_setA_Quantity));
        }
    }

    @FXML
    void BBB_SETB_PLUS_Click(ActionEvent event) {
        addItemToCart("Telur Bungkus", 5.90, 1);
        bbb_setB_Quantity++;
        BBB_SETB_QUANTITY.setText(String.valueOf(bbb_setB_Quantity));
    }

    @FXML
    void BBB_SETB_MINUS_Click(ActionEvent event) {
        if (bbb_setB_Quantity > 0) { // Check if quantity is greater than 0
            addItemToCart("Telur Bungkus", 5.90, -1);
            bbb_setB_Quantity--;
            BBB_SETB_QUANTITY.setText(String.valueOf(bbb_setB_Quantity));
        }
    }

    @FXML
    void BBB_SETC_PLUS_Click(ActionEvent event) {
        addItemToCart("Teh O' Ais", 2.50, 1);
        bbb_setC_Quantity++;
        BBB_SETC_QUANTITY.setText(String.valueOf(bbb_setC_Quantity));
    }

    @FXML
    void BBB_SETC_MINUS_Click(ActionEvent event) {
        if (bbb_setC_Quantity > 0) {
            addItemToCart("Teh O' Ais", 2.50, -1);
            bbb_setC_Quantity--;
            BBB_SETC_QUANTITY.setText(String.valueOf(bbb_setC_Quantity));
        }
    }

    // GEMAS
    @FXML
    void GEMAS_SETA_PLUS_Click(ActionEvent event) {
        addItemToCart("Nasi Ayam Panggang", 7.90, 1);
        gemas_setA_Quantity++;
        GEMAS_SETA_QUANTITY.setText(String.valueOf(gemas_setA_Quantity));
    }

    @FXML
    void GEMAS_SETA_MINUS_Click(ActionEvent event) {
        if (gemas_setA_Quantity > 0) {
            addItemToCart("Nasi Ayam Panggang", 7.90, -1);
            gemas_setA_Quantity--;
            GEMAS_SETA_QUANTITY.setText(String.valueOf(gemas_setA_Quantity));
        }
    }

    @FXML
    void GEMAS_SETB_PLUS_Click(ActionEvent event) {
        addItemToCart("Nasi Ayam BBQ", 9.90, 1);
        gemas_setB_Quantity++;
        GEMAS_SETB_QUANTITY.setText(String.valueOf(gemas_setB_Quantity));
    }

    @FXML
    void GEMAS_SETB_MINUS_Click(ActionEvent event) {
        if (gemas_setB_Quantity > 0) {
            addItemToCart("Nasi Ayam BBQ", 9.90, -1);
            gemas_setB_Quantity--;
            GEMAS_SETB_QUANTITY.setText(String.valueOf(gemas_setB_Quantity));
        }
    }

    @FXML
    void GEMAS_SETC_PLUS_Click(ActionEvent event) {
        addItemToCart("Teh O' Ais", 2.50, 1);
        gemas_setC_Quantity++;
        GEMAS_SETC_QUANTITY.setText(String.valueOf(gemas_setC_Quantity));
    }

    @FXML
    void GEMAS_SETC_MINUS_Click(ActionEvent event) {
        if (gemas_setC_Quantity > 0) {
            addItemToCart("Teh O' Ais", 2.50, -1);
            gemas_setC_Quantity--;
            GEMAS_SETC_QUANTITY.setText(String.valueOf(gemas_setC_Quantity));
        }
    }

    // KFC
    @FXML
    void KFC_SETA_PLUS_Click(ActionEvent event) {
        addItemToCart("Kid's Meal", 10.90, 1);
        kfc_setA_Quantity++;
        KFC_SETA_QUANTITY.setText(String.valueOf(kfc_setA_Quantity));
    }

    @FXML
    void KFC_SETA_MINUS_Click(ActionEvent event) {
        if (kfc_setA_Quantity > 0) {
            addItemToCart("Kid's Meal", 10.90, -1);
            kfc_setA_Quantity--;
            KFC_SETA_QUANTITY.setText(String.valueOf(kfc_setA_Quantity));
        }
    }

    @FXML
    void KFC_SETB_PLUS_Click(ActionEvent event) {
        addItemToCart("3 Piece Chicken SET", 14.90, 1);
        kfc_setB_Quantity++;
        KFC_SETB_QUANTITY.setText(String.valueOf(kfc_setB_Quantity));
    }

    @FXML
    void KFC_SETB_MINUS_Click(ActionEvent event) {
        if (kfc_setB_Quantity > 0) {
            addItemToCart("3 Piece Chicken SET", 14.90, -1);
            kfc_setB_Quantity--;
            KFC_SETB_QUANTITY.setText(String.valueOf(kfc_setB_Quantity));
        }
    }

    @FXML
    void KFC_SETC_PLUS_Click(ActionEvent event) {
        addItemToCart("Twister SET", 7.90, 1);
        kfc_setC_Quantity++;
        KFC_SETC_QUANTITY.setText(String.valueOf(kfc_setC_Quantity));
    }

    @FXML
    void KFC_SETC_MINUS_Click(ActionEvent event) {
        if (kfc_setC_Quantity > 0) {
            addItemToCart("Twister SET", 7.90, -1);
            kfc_setC_Quantity--;
            KFC_SETC_QUANTITY.setText(String.valueOf(kfc_setC_Quantity));
        }
    }

    // KFRY
    @FXML
    void KFRY_SETA_PLUS_Click(ActionEvent event) {
        addItemToCart("Honey Mustard Bumbuk", 17.90, 1);
        kfry_setA_Quantity++;
        KFRY_SETA_QUANTITY.setText(String.valueOf(kfry_setA_Quantity));
    }

    @FXML
    void KFRY_SETA_MINUS_Click(ActionEvent event) {
        if (kfry_setA_Quantity > 0) {
            addItemToCart("Honey Mustard Bumbuk", 17.90, -1);
            kfry_setA_Quantity--;
            KFRY_SETA_QUANTITY.setText(String.valueOf(kfry_setA_Quantity));
        }
    }

    @FXML
    void KFRY_SETB_PLUS_Click(ActionEvent event) {
        addItemToCart("Honey Chicken", 22.90, 1);
        kfry_setB_Quantity++;
        KFRY_SETB_QUANTITY.setText(String.valueOf(kfry_setB_Quantity));
    }

    @FXML
    void KFRY_SETB_MINUS_Click(ActionEvent event) {
        if (kfry_setB_Quantity > 0) {
            addItemToCart("Honey Chicken", 22.90, -1);
            kfry_setB_Quantity--;
            KFRY_SETB_QUANTITY.setText(String.valueOf(kfry_setB_Quantity));
        }
    }

    @FXML
    void KFRY_SETC_PLUS_Click(ActionEvent event) {
        addItemToCart("Cheesy Chicken", 26.90, 1);
        kfry_setC_Quantity++;
        KFRY_SETC_QUANTITY.setText(String.valueOf(kfry_setC_Quantity));
    }

    @FXML
    void KFRY_SETC_MINUS_Click(ActionEvent event) {
        if (kfry_setC_Quantity > 0) {
            addItemToCart("Cheesy Chicken", 26.90, -1);
            kfry_setC_Quantity--;
            KFRY_SETC_QUANTITY.setText(String.valueOf(kfry_setC_Quantity));
        }
    }

    // NANDOS
    @FXML
    void NANDOS_SETA_PLUS_Click(ActionEvent event) {
        addItemToCart("Mac n' Cheese", 20.90, 1);
        nandos_setA_Quantity++;
        NANDOS_SETA_QUANTITY.setText(String.valueOf(nandos_setA_Quantity));
    }

    @FXML
    void NANDOS_SETA_MINUS_Click(ActionEvent event) {
        if (nandos_setA_Quantity > 0) {
            addItemToCart("Mac n' Cheese", 20.90, -1);
            nandos_setA_Quantity--;
            NANDOS_SETA_QUANTITY.setText(String.valueOf(nandos_setA_Quantity));
        }
    }

    @FXML
    void NANDOS_SETB_PLUS_Click(ActionEvent event) {
        addItemToCart("Honey Yuzu Thigh Bowl", 18.90, 1);
        nandos_setB_Quantity++;
        NANDOS_SETB_QUANTITY.setText(String.valueOf(nandos_setB_Quantity));
    }

    @FXML
    void NANDOS_SETB_MINUS_Click(ActionEvent event) {
        if (nandos_setB_Quantity > 0) {
            addItemToCart("Honey Yuzu Thigh Bowl", 18.90, -1);
            nandos_setB_Quantity--;
            NANDOS_SETB_QUANTITY.setText(String.valueOf(nandos_setB_Quantity));
        }
    }

    @FXML
    void NANDOS_SETC_PLUS_Click(ActionEvent event) {
        addItemToCart("Cheesy Chicken Wrap", 14.90, 1);
        nandos_setC_Quantity++;
        NANDOS_SETC_QUANTITY.setText(String.valueOf(nandos_setC_Quantity));
    }

    @FXML
    void NANDOS_SETC_MINUS_Click(ActionEvent event) {
        if (nandos_setC_Quantity > 0) {
            addItemToCart("Cheesy Chicken Wrap", 14.90, -1);
            nandos_setC_Quantity--;
            NANDOS_SETC_QUANTITY.setText(String.valueOf(nandos_setC_Quantity));
        }
    }

    // RBS (Roti Canai Business)
    @FXML
    void RBS_SETA_PLUS_Click(ActionEvent event) {
        addItemToCart("Roti Canai", 1.50, 1);
        rbs_setA_Quantity++;
        RBS_SETA_QUANTITY.setText(String.valueOf(rbs_setA_Quantity));
    }

    @FXML
    void RBS_SETA_MINUS_Click(ActionEvent event) {
        if (rbs_setA_Quantity > 0) {
            addItemToCart("Roti Canai", 1.50, -1);
            rbs_setA_Quantity--;
            RBS_SETA_QUANTITY.setText(String.valueOf(rbs_setA_Quantity));
        }
    }

    @FXML
    void RBS_SETB_PLUS_Click(ActionEvent event) {
        addItemToCart("Nasi Goreng Ayam", 8.9, 1);
        rbs_setB_Quantity++;
        RBS_SETB_QUANTITY.setText(String.valueOf(rbs_setB_Quantity));
    }

    @FXML
    void RBS_SETB_MINUS_Click(ActionEvent event) {
        if (rbs_setB_Quantity > 0) {
            addItemToCart("Nasi Goreng Ayam", 8.90, -1);
            rbs_setB_Quantity--;
            RBS_SETB_QUANTITY.setText(String.valueOf(rbs_setB_Quantity));
        }
    }

    @FXML
    void RBS_SETC_PLUS_Click(ActionEvent event) {
        addItemToCart("Milo Ais", 2.50, 1);
        rbs_setC_Quantity++;
        RBS_SETC_QUANTITY.setText(String.valueOf(rbs_setC_Quantity));
    }

    @FXML
    void RBS_SETC_MINUS_Click(ActionEvent event) {
        if (rbs_setC_Quantity > 0) {
            addItemToCart("Milo Ais", 2.50, -1);
            rbs_setC_Quantity--;
            RBS_SETC_QUANTITY.setText(String.valueOf(rbs_setC_Quantity));
        }
    }

    // RICHEESE
    @FXML
    void RICHEESE_SETA_PLUS_Click(ActionEvent event) {
        addItemToCart("Fire Chicken Set", 22.90, 1);
        richeese_setA_Quantity++;
        RICHEESE_SETA_QUANTITY.setText(String.valueOf(richeese_setA_Quantity));
    }

    @FXML
    void RICHEESE_SETA_MINUS_Click(ActionEvent event) {
        if (richeese_setA_Quantity > 0) {
            addItemToCart("Fire Chicken Set", 22.90, -1);
            richeese_setA_Quantity--;
            RICHEESE_SETA_QUANTITY.setText(String.valueOf(richeese_setA_Quantity));
        }
    }

    @FXML
    void RICHEESE_SETB_PLUS_Click(ActionEvent event) {
        addItemToCart("COMBO Set", 53.90, 1);
        richeese_setB_Quantity++;
        RICHEESE_SETB_QUANTITY.setText(String.valueOf(richeese_setB_Quantity));
    }

    @FXML
    void RICHEESE_SETB_MINUS_Click(ActionEvent event) {
        if (richeese_setB_Quantity > 0) {
            addItemToCart("COMBO Set", 53.90, -1);
            richeese_setB_Quantity--;
            RICHEESE_SETB_QUANTITY.setText(String.valueOf(richeese_setB_Quantity));
        }
    }

    @FXML
    void RICHEESE_SETC_PLUS_Click(ActionEvent event) {
        addItemToCart("Bandung Ice", 5.90, 1);
        richeese_setC_Quantity++;
        RICHEESE_SETC_QUANTITY.setText(String.valueOf(richeese_setC_Quantity));
    }

    @FXML
    void RICHEESE_SETC_MINUS_Click(ActionEvent event) {
        if (richeese_setC_Quantity > 0) {
            addItemToCart("Bandung Ice", 5.90, -1);
            richeese_setC_Quantity--;
            RICHEESE_SETC_QUANTITY.setText(String.valueOf(richeese_setC_Quantity));
        }
    }

    public void setRBSQuantity(){
        rbs_setA_Quantity = CartData.rbs_setA_Quantity;
        rbs_setB_Quantity = CartData.rbs_setB_Quantity;
        rbs_setC_Quantity = CartData.rbs_setC_Quantity;

        RBS_SETA_QUANTITY.setText(String.valueOf(rbs_setA_Quantity));
        RBS_SETB_QUANTITY.setText(String.valueOf(rbs_setB_Quantity));
        RBS_SETC_QUANTITY.setText(String.valueOf(rbs_setC_Quantity));
    }

    public void setAGQuantity() {
        ag_setA_Quantity = CartData.ag_setA_Quantity;
        ag_setB_Quantity = CartData.ag_setB_Quantity;
        ag_setC_Quantity = CartData.ag_setC_Quantity;
    
        AG_SETA_QUANTITY.setText(String.valueOf(ag_setA_Quantity));
        AG_SETB_QUANTITY.setText(String.valueOf(ag_setB_Quantity));
        AG_SETC_QUANTITY.setText(String.valueOf(ag_setC_Quantity));
    }
    
    public void setBBBQuantity() {
        bbb_setA_Quantity = CartData.bbb_setA_Quantity;
        bbb_setB_Quantity = CartData.bbb_setB_Quantity;
        bbb_setC_Quantity = CartData.bbb_setC_Quantity;
    
        BBB_SETA_QUANTITY.setText(String.valueOf(bbb_setA_Quantity));
        BBB_SETB_QUANTITY.setText(String.valueOf(bbb_setB_Quantity));
        BBB_SETC_QUANTITY.setText(String.valueOf(bbb_setC_Quantity));
    }
    
    public void setGemasQuantity() {
        gemas_setA_Quantity = CartData.gemas_setA_Quantity;
        gemas_setB_Quantity = CartData.gemas_setB_Quantity;
        gemas_setC_Quantity = CartData.gemas_setC_Quantity;
    
        GEMAS_SETA_QUANTITY.setText(String.valueOf(gemas_setA_Quantity));
        GEMAS_SETB_QUANTITY.setText(String.valueOf(gemas_setB_Quantity));
        GEMAS_SETC_QUANTITY.setText(String.valueOf(gemas_setC_Quantity));
    }
    
    public void setKFCQuantity() {
        kfc_setA_Quantity = CartData.kfc_setA_Quantity;
        kfc_setB_Quantity = CartData.kfc_setB_Quantity;
        kfc_setC_Quantity = CartData.kfc_setC_Quantity;
    
        KFC_SETA_QUANTITY.setText(String.valueOf(kfc_setA_Quantity));
        KFC_SETB_QUANTITY.setText(String.valueOf(kfc_setB_Quantity));
        KFC_SETC_QUANTITY.setText(String.valueOf(kfc_setC_Quantity));
    }
    
    public void setKFRYQuantity() {
        kfry_setA_Quantity = CartData.kfry_setA_Quantity;
        kfry_setB_Quantity = CartData.kfry_setB_Quantity;
        kfry_setC_Quantity = CartData.kfry_setC_Quantity;
    
        KFRY_SETA_QUANTITY.setText(String.valueOf(kfry_setA_Quantity));
        KFRY_SETB_QUANTITY.setText(String.valueOf(kfry_setB_Quantity));
        KFRY_SETC_QUANTITY.setText(String.valueOf(kfry_setC_Quantity));
    }
    
    public void setNandosQuantity() {
        nandos_setA_Quantity = CartData.nandos_setA_Quantity;
        nandos_setB_Quantity = CartData.nandos_setB_Quantity;
        nandos_setC_Quantity = CartData.nandos_setC_Quantity;
    
        NANDOS_SETA_QUANTITY.setText(String.valueOf(nandos_setA_Quantity));
        NANDOS_SETB_QUANTITY.setText(String.valueOf(nandos_setB_Quantity));
        NANDOS_SETC_QUANTITY.setText(String.valueOf(nandos_setC_Quantity));
    }
    
    public void setRicheeseQuantity() {
        richeese_setA_Quantity = CartData.richeese_setA_Quantity;
        richeese_setB_Quantity = CartData.richeese_setB_Quantity;
        richeese_setC_Quantity = CartData.richeese_setC_Quantity;
    
        RICHEESE_SETA_QUANTITY.setText(String.valueOf(richeese_setA_Quantity));
        RICHEESE_SETB_QUANTITY.setText(String.valueOf(richeese_setB_Quantity));
        RICHEESE_SETC_QUANTITY.setText(String.valueOf(richeese_setC_Quantity));
    }
    
    public void setGepukQuantity() {
        ag_setA_Quantity = CartData.ag_setA_Quantity;
        ag_setB_Quantity = CartData.ag_setB_Quantity;
        ag_setC_Quantity = CartData.ag_setC_Quantity;
    
        AG_SETA_QUANTITY.setText(String.valueOf(ag_setA_Quantity));
        AG_SETB_QUANTITY.setText(String.valueOf(ag_setB_Quantity));
        AG_SETC_QUANTITY.setText(String.valueOf(ag_setC_Quantity));
    }

    @FXML
    void clickBackButton(ActionEvent event) throws IOException {
        Alert confirmExit = new Alert(Alert.AlertType.CONFIRMATION);

        //Center the alert box relative to the parent window
        confirmExit.initOwner(((Node) event.getSource()).getScene().getWindow());

        // Info texts shown
        confirmExit.setTitle("Back to main menu");
        confirmExit.setHeaderText("Are you sure you want to exit the menu");
        confirmExit.setContentText("Your cart will be cleared once you exit");
        confirmExit.showAndWait();

        if (confirmExit.getResult() == ButtonType.OK) {
            CartData.clearCart();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/HomePage.fxml"));
            Parent root = loader.load();

            // Set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    void checkOut_Btn_Click(ActionEvent event) throws IOException {
        if (CartData.getTotalPrice() != 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CheckoutController.fxml"));
            Parent root = loader.load();

            switch (userChoice) {
                case 1:
                    CartData.setRBSQuantity(rbs_setA_Quantity, rbs_setB_Quantity, rbs_setC_Quantity);
                    break;
                case 2:
                    CartData.setKfryQuantity(kfry_setA_Quantity, kfry_setB_Quantity, kfry_setC_Quantity);
                    break;
                case 3:
                    CartData.setNandosQuantity(nandos_setA_Quantity, nandos_setB_Quantity, nandos_setC_Quantity);
                    break;
                case 4:
                    CartData.setKfcQuantity(kfc_setA_Quantity, kfc_setB_Quantity, kfc_setC_Quantity);
                    break;
                case 5:
                    CartData.setBBBQuantity(bbb_setA_Quantity, bbb_setB_Quantity, bbb_setC_Quantity);
                    break;
                case 6:
                    CartData.setRicheeseQuantity(richeese_setA_Quantity, richeese_setB_Quantity, richeese_setC_Quantity);
                    break;
                case 7:
                    CartData.setGemasQuantity(gemas_setA_Quantity, gemas_setB_Quantity, gemas_setC_Quantity);
                    break;
                case 8:
                    CartData.setGepukQuantity(ag_setA_Quantity, ag_setB_Quantity, ag_setC_Quantity);
                    break;
                default:
                    break;
                }
            // Set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show(); 
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(((Node) event.getSource()).getScene().getWindow());
            alert.setTitle("Error");
            alert.setContentText("Your cart is empty!");
            alert.show();
        }
    }

}
