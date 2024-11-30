import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LockedUpMunchies extends Application {

    @Override
    public void start(Stage loginStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/LoginOrRegisterPage.fxml"));
        Scene loginPage = new Scene(root);
        loginStage.setFullScreen(true);
        //loginPage.getStylesheets().add(getClass().getResource("/CSS/animationMenu.css").toExternalForm());
        loginStage.setScene(loginPage);
        loginStage.setTitle("Locked Up Munchies");
        loginStage.show();

        Image icon = new Image("/Images/LOGO-removebg-preview.png");
        loginStage.getIcons().add(icon);

        if (loginStage.isShowing()) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Print the full screen width and height
        System.out.println("Full Screen Width: " + screenBounds.getWidth());
        System.out.println("Full Screen Height: " + screenBounds.getHeight());
    }
    }
    public static void main(String[] args) {
        launch(args);
    }
}