import java.sql.*;
import java.sql.Statement;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection() throws SQLException {
        String url = "jdbc:sqlite:G:/wsiz/sem3/programowanie obiektowe/laboratorium/zal_PO/src/zal.db";
        this.connection = DriverManager.getConnection(url);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void close() throws SQLException {
        connection.close();
    }
}
