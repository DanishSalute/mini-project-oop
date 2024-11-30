import java.util.ArrayList;

public class UserData {
    private static UserData instance = new UserData();

    public ArrayList<String> registeredUsername = new ArrayList<>();
    public ArrayList<String> registeredPassword = new ArrayList<>();
    private int indexOfCurrentUser ;
    public int userChoice;


    public double storeProgressbar;

    // Private constructor for Singleton
    private UserData() {}

    public static UserData getInstance() {
        return instance;
    }

    public int getIndexOfCurrentUser () {
        return indexOfCurrentUser ;
    }

    public void setIndexOfCurrentUser (int index) {
        this.indexOfCurrentUser  = index;
    }

    public String getRegisteredUsername() {
        return registeredUsername.get(indexOfCurrentUser );
    }

    public void setUserChoice(int choice) {
        this.userChoice = choice;
    }
}