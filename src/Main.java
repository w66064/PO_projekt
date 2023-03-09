import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            ZarzadzanieFinansami zarzadzanieFinansami = new ZarzadzanieFinansami(databaseConnection);
            UserInterface userInterface = new UserInterface(zarzadzanieFinansami);
            userInterface.start();
        } catch (SQLException e) {
            System.out.println("Nie udało się połączyć z bazą danych.");
        }
    }
}
