import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LockedUpMunchies extends Application {

    @Override
    public void start(Stage loginStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/LoginOrRegisterPage.fxml"));
        Scene loginPage = new Scene(root);
        loginStage.setScene(loginPage);
        loginStage.setTitle("Locked Up Munchies");
        loginStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}