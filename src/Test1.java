import java.sql.SQLException;

public class Test1 {
    private ZarzadzanieFinansami zarzadzanieFinansami;
    private DatabaseConnection databaseConnection;
    public Test1(ZarzadzanieFinansami zarzadzanieFinansami) {
        this.zarzadzanieFinansami = zarzadzanieFinansami;
    }

    public Test1(){}

    public void testZarzadzanieFinansami() throws SQLException {
        // dodaj wydatek i wyswietl wszystkie wydatki
        zarzadzanieFinansami.dodajWydatek(1, 1000, "test");
        zarzadzanieFinansami.wyswietlWszystkieWydatki();

        // dodaj przychod i wyswietl wszystkie przychody
        zarzadzanieFinansami.dodajPrzychod(1,1000, "test");
        zarzadzanieFinansami.wyswietlWszystkiePrzychody();

        // dodaj konto i wyswietl konta
        zarzadzanieFinansami.dodajKonto(3, "test");
        zarzadzanieFinansami.wyswietlKonta();

        // zmien nazwe konta i wyswietl konta
        zarzadzanieFinansami.zmienNazweKonta(3, "Test zmiany nazwy konta");
        zarzadzanieFinansami.wyswietlKonta();

        // usun konto i wyswietl konta
        zarzadzanieFinansami.usunKonto(3);
        zarzadzanieFinansami.wyswietlKonta();
    }
}
