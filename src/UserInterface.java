import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface{
    private ZarzadzanieFinansami zarzadzanieFinansami;
    private DatabaseConnection databaseConnection;
    public UserInterface(ZarzadzanieFinansami zarzadzanieFinansami) {
        this.zarzadzanieFinansami = zarzadzanieFinansami;

    }

    public void start() throws SQLException {
        //----------------------------------TEST------------------------------
        zarzadzanieFinansami.dodajWydatek(1, 1000, "test");
        zarzadzanieFinansami.wyswietlWszystkieWydatki();

        zarzadzanieFinansami.dodajPrzychod(1,1000, "test");
        zarzadzanieFinansami.wyswietlWszystkiePrzychody();

        zarzadzanieFinansami.dodajKonto(3, "test");
        zarzadzanieFinansami.wyswietlKonta();

        zarzadzanieFinansami.zmienNazweKonta(3, "Test zmiany nazwy konta");
        zarzadzanieFinansami.wyswietlKonta();

        zarzadzanieFinansami.usunWydatek(5);
        zarzadzanieFinansami.usunPrzychod(5);
        zarzadzanieFinansami.usunKonto(3);
        zarzadzanieFinansami.wyswietlKonta();
        //----------------------------------KONIEC TESTU------------------------------

        Scanner scanner = new Scanner(System.in);
        int controllNumber = 0;
        while (true) {
            System.out.println("1. Dodaj wydatek");
            System.out.println("2. Dodaj przychod");
            System.out.println("3. Dodaj konto");

            System.out.println("4. Usun wydatek");
            System.out.println("5. Usun przychod");
            System.out.println("6. Usun konto");

            System.out.println("7. Wyswietl wszystkie wydatki");
            System.out.println("8. Wyswietl wszystkie przychody");
            System.out.println("9. Wyswietl wszystkie konta");

            System.out.println("10. Zmien nazwę konta");
            System.out.println("0. Zakoncz");
            System.out.println("--------------------------------------------");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 0:
                    System.out.println("Koniec programu...");
                    return;
                case 1:
                    Wydatki wydatki = new Wydatki();
                    wydatki.daneDodajWydatki();
                    if (wydatki.getIdKonta() != 0 && wydatki.getKwota() != 0.0f && wydatki.getKategoria() != null) {
                        try {
                            zarzadzanieFinansami.dodajWydatek(wydatki.getIdKonta(), wydatki.getKwota(), wydatki.getKategoria());
                        } catch (SQLException e) {
                            System.out.println("Nie udalo sie dodac wydatku.");
                            e.printStackTrace();
                        }
                    }

                    break;

                case 2:
                    Przychody przychody = new Przychody();
                    przychody.daneDodajPrzychody();

                    if (przychody.getIdKonta() != 0 && przychody.getKwota() != 0.0f && przychody.getZrodlo() != null) {
                        try {
                            zarzadzanieFinansami.dodajPrzychod(przychody.getIdKonta(), przychody.getKwota(), przychody.getZrodlo());
                            System.out.println("Dodano przychod.");
                        } catch (SQLException e) {
                            System.out.println("Nie udalo sie dodac przychodu.");
                            e.printStackTrace();
                        }
                    }
                    break;

                case 3:
                    Konto konto = new Konto();
                    konto.daneDodajKonto();

                    if (konto.getId() != 0 && konto.getNazwa() != null) {
                        try {
                            zarzadzanieFinansami.dodajKonto(konto.getId(), konto.getNazwa());
                        } catch (SQLException e) {
                            System.out.println("Nie udalo sie dodac konta.");
                            e.printStackTrace();
                        }
                    }
                    break;

                case 4:
                    Wydatki wydatki2 = new Wydatki();
                    controllNumber = wydatki2.daneUsunWydatki();

                    if (controllNumber != 0) {
                        try {
                            zarzadzanieFinansami.usunWydatek(controllNumber);
                            System.out.println("Usunieto wydatek.");
                        } catch (SQLException e) {
                            System.out.println("Nie udalo sie usunac wydatku.");
                            e.printStackTrace();
                        }
                    }

                    break;

                case 5:
                    Przychody przychody2 = new Przychody();
                    controllNumber = przychody2.daneUsunPrzychody();

                    if (controllNumber != 0) {
                        try {
                            zarzadzanieFinansami.usunPrzychod(controllNumber);
                        } catch (SQLException e) {
                            System.out.println("Nie udalo sie usunac przychodu.");
                            e.printStackTrace();
                        }
                    }
                    break;

                case 6:
                    Konto konto2 = new Konto();
                    controllNumber = konto2.daneUsunKonto();

                    if (controllNumber != 0) {
                        try {
                            zarzadzanieFinansami.usunKonto(controllNumber);
                        } catch (SQLException e) {
                            System.out.println("Nie udalo sie usunac konta.");
                            e.printStackTrace();
                        }
                    }

                    break;

                case 7:
                    try {
                        zarzadzanieFinansami.wyswietlWszystkieWydatki();
                    } catch (SQLException e) {
                        System.out.println("Nie udało się wyświetlić wydatkow.");
                    }
                    break;

                case 8:
                    try {
                        zarzadzanieFinansami.wyswietlWszystkiePrzychody();
                    } catch (SQLException e) {
                        System.out.println("Nie udało się wyświetlić przychodow.");
                    }
                    break;

                case 9:
                    try {
                        zarzadzanieFinansami.wyswietlKonta();
                    } catch (SQLException e) {
                        System.out.println("Nie udało się wyświetlić kont.");
                    }
                    break;

                case 10:
                    Konto konto3 = new Konto();
                    konto3.daneZmienNazwe();

                    if (konto3.getId() != 0 && konto3.getNazwa() != null) {
                        try {
                            zarzadzanieFinansami.zmienNazweKonta(konto3.getId(), konto3.getNazwa());
                        } catch (SQLException e) {
                            System.out.println("Nie udalo sie zmienic nazwy konta.");
                            e.printStackTrace();
                        }
                    }
                    break;

                default:
                    System.out.println("Nieznana opcja. Spróbuj ponownie.");
                    break;
            }
        }
    }

}

