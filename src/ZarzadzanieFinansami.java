import java.sql.*;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZarzadzanieFinansami {
    private DatabaseConnection databaseConnection;

    public ZarzadzanieFinansami(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void dodajWydatek(int idKonta, float kwota, String kategoria) throws SQLException {
        try {
            LocalDate data = LocalDate.now();
            String query = "INSERT INTO wydatki (id_konta, data, kwota, kategoria) VALUES (" + idKonta + ", '" + data + "', " + kwota + ", '" + kategoria + "')";
            databaseConnection.executeUpdate(query);
            System.out.println("Dodano nowy wydatek!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void usunWydatek(int id) throws SQLException {
        try {
            String query = "DELETE FROM wydatki WHERE id=" + id;
            int rowsAffected = databaseConnection.executeUpdate(query);
            if (rowsAffected == 0) {
                System.out.println("Nie znaleziono wydatku o podanym id!");
            } else {
                System.out.println("Usunięto wydatek!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dodajPrzychod(int idKonta, float kwota, String zrodlo) throws SQLException {
        try{
            LocalDate data = LocalDate.now();
            String query = "INSERT INTO przychody (id_konta, data, kwota, zrodlo) VALUES (" + idKonta + ", '" + data + "', " + kwota + ", '" + zrodlo + "')";
            databaseConnection.executeUpdate(query);
            System.out.println("Dodano nowy przychód!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dodajKonto(int idKonta, String nazwa) throws SQLException {
        try {
            String query = "INSERT INTO konto (id, nazwa) VALUES (" + idKonta + ", '" + nazwa + "')";
            databaseConnection.executeUpdate(query);
            System.out.println("Dodano nowe konto!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void usunKonto(int id) throws SQLException {
        try{
            String query = "DELETE FROM konto WHERE id=" + id;
            int rowsAffected = databaseConnection.executeUpdate(query);
            if (rowsAffected == 0) {
                System.out.println("Nie znaleziono konta o podanym id!");
            } else {
                System.out.println("Usunięto konto!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void usunPrzychod(int id) throws SQLException {
        try{
            String query = "DELETE FROM przychody WHERE id=" + id;
            int rowsAffected = databaseConnection.executeUpdate(query);
            if (rowsAffected == 0) {
                System.out.println("Nie znaleziono przychodu o podanym id!");
            } else {
                System.out.println("Usunięto przychód!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

public void wyswietlWszystkiePrzychody() throws SQLException {
    try {
        // Tworzenie zapytania SELECT
        String queryWydatki = "SELECT * FROM przychody";
        Statement stmt = databaseConnection.createStatement();
        ResultSet rs = stmt.executeQuery(queryWydatki);

        System.out.println("Wszystkie przychody:");
        // Przetwarzanie wyników zapytania
        while (rs.next()) {
            // Wypisanie wartości z kolumn
            System.out.println(rs.getInt("id") + "\t" +
                    rs.getInt("id_konta") + "\t" +
                    rs.getString("data") + "\t" +
                    rs.getDouble("kwota") + "\t" +
                    rs.getString("zrodlo"));
        }System.out.println("--------------------------------------------");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


    public void wyswietlWszystkieWydatki() throws SQLException {
        try {
            // Tworzenie zapytania SELECT
            String queryWydatki = "SELECT * FROM wydatki";
            Statement stmt = databaseConnection.createStatement();
            ResultSet rs = stmt.executeQuery(queryWydatki);

            System.out.println("Wszystkie wydatki:");
            // Przetwarzanie wyników zapytania
            while (rs.next()) {
                // Wypisanie wartości z kolumn
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getInt("id_konta") + "\t" +
                        rs.getString("data") + "\t" +
                        rs.getDouble("kwota") + "\t" +
                        rs.getString("kategoria"));
            }System.out.println("--------------------------------------------");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void wyswietlKonta() throws SQLException {
        try {
            // Tworzenie zapytania SELECT
            String queryWydatki = "SELECT * FROM konto";
            Statement stmt = databaseConnection.createStatement();
            ResultSet rs = stmt.executeQuery(queryWydatki);

            System.out.println("Wszystkie konta:");
            // Przetwarzanie wyników zapytania
            while (rs.next()) {
                // Wypisanie wartości z kolumn
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("nazwa"));
            } System.out.println("--------------------------------------------");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void zmienNazweKonta(int id, String nowaNazwa) throws SQLException {
        try {
            // Tworzenie zapytania UPDATE
            String sql = "UPDATE konto SET nazwa = '" + nowaNazwa + "' WHERE id = " + id;
            int rowsAffected = databaseConnection.executeUpdate(sql);

            // Sprawdzenie, czy udało się zaktualizować konto
            if (rowsAffected == 0) {
                System.out.println("Nie znaleziono konta o podanym id!");
            } else {
                System.out.println("Zaktualizowano nazwę konta!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}

