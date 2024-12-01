import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CartData {

    // Shared list of cart items
    private static final ObservableList<CartItem> cartItems = FXCollections.observableArrayList();

    // Shared total price
    private static double totalPrice = 0.0;

    public static int ag_setA_Quantity;
    public static int ag_setB_Quantity;
    public static int ag_setC_Quantity;

    public static int bbb_setA_Quantity;
    public static int bbb_setB_Quantity;
    public static int bbb_setC_Quantity;

    public static int gemas_setA_Quantity;
    public static int gemas_setB_Quantity;
    public static int gemas_setC_Quantity;

    public static int kfc_setA_Quantity;
    public static int kfc_setB_Quantity;
    public static int kfc_setC_Quantity;

    public static int kfry_setA_Quantity;
    public static int kfry_setB_Quantity;
    public static int kfry_setC_Quantity;

    public static int nandos_setA_Quantity;
    public static int nandos_setB_Quantity;
    public static int nandos_setC_Quantity;

    public static int rbs_setA_Quantity;
    public static int rbs_setB_Quantity;
    public static int rbs_setC_Quantity;

    public static int richeese_setA_Quantity;
    public static int richeese_setB_Quantity;
    public static int richeese_setC_Quantity;  
    
        public static ObservableList<CartItem> getCartItems() {
            return cartItems;
        }
    
        public static double getTotalPrice() {
            return totalPrice;
        }
    
        public static void setTotalPrice(double total) {
            totalPrice = total;
        }
        
        public static void setGepukQuantity(int quantity1, int quantity2, int quantity3) {
            ag_setA_Quantity = quantity1;
            ag_setB_Quantity = quantity2;
            ag_setC_Quantity = quantity3;
        }

        public static void setRicheeseQuantity(int quantity1, int quantity2, int quantity3) {
            richeese_setA_Quantity = quantity1;
            richeese_setB_Quantity = quantity2;
            richeese_setC_Quantity = quantity3;
        }

        public static void setBBBQuantity(int quantity1, int quantity2, int quantity3) {
            bbb_setA_Quantity = quantity1;
            bbb_setB_Quantity = quantity2;
            bbb_setC_Quantity = quantity3;
        }

        public static void setGemasQuantity(int quantity1, int quantity2, int quantity3) {
            gemas_setA_Quantity = quantity1;
            gemas_setB_Quantity = quantity2;
            gemas_setC_Quantity = quantity3;
        }

        public static void setKfcQuantity(int quantity1, int quantity2, int quantity3) {
            kfc_setA_Quantity = quantity1;
            kfc_setB_Quantity = quantity2;
            kfc_setC_Quantity = quantity3;
        }

        public static void setKfryQuantity(int quantity1, int quantity2, int quantity3) {
            kfry_setA_Quantity = quantity1;
            kfry_setB_Quantity = quantity2;
            kfry_setC_Quantity = quantity3;
        }

        public static void setNandosQuantity(int quantity1, int quantity2, int quantity3) {
            nandos_setA_Quantity = quantity1;
            nandos_setB_Quantity = quantity2;
            nandos_setC_Quantity = quantity3;
        }

        public static void setRBSQuantity(int quantity1, int quantity2, int quantity3) {
            rbs_setA_Quantity = quantity1;
            rbs_setB_Quantity = quantity2;
            rbs_setC_Quantity = quantity3;
        }

    public static void clearCart(){
        cartItems.clear();
        totalPrice = 0.0;
    }
}
