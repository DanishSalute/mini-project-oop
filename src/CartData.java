import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CartData {

    // Shared list of cart items
    private static final ObservableList<CartItem> cartItems = FXCollections.observableArrayList();

    // Shared total price
    private static double totalPrice = 0.0;

    public static ObservableList<CartItem> getCartItems() {
        return cartItems;
    }

    public static double getTotalPrice() {
        return totalPrice;
    }

    public static void setTotalPrice(double total) {
        totalPrice = total;
    }
    
}
