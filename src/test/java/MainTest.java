import model.DatabaseManager;

/**
 * Created by kehanyang on 15/5/31.
 */
public class MainTest {
    public static void main(String[] args) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        boolean result = databaseManager.deleteUser("testuser");
        System.out.println(result);
    }
}
