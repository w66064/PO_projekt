import java.time.LocalDate;
import java.util.Scanner;

public class Wydatki extends Transakcje implements UserInputWydatki{
    Scanner scanner = new Scanner(System.in);
    private String kategoria;

    public Wydatki(int id, int idKonta, LocalDate data, float kwota, String kategoria) {
        super(id, idKonta, data, kwota);
        this.kategoria = kategoria;
    }
    public Wydatki(){

    }

    public Wydatki(int idKonta, float kwota, String kategoria){

    }

    public String getKategoria() {
        return kategoria;
    }


    @Override
    public Wydatki daneDodajWydatki() {
        try {
            System.out.print("Podaj id konta: ");
            String idKontaStr = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyInt(idKontaStr);
            idKonta = Integer.parseInt(idKontaStr);

            System.out.print("Podaj kwote: ");
            String kwotaStr = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyFloat(kwotaStr);
            kwota = Float.parseFloat(kwotaStr);

            System.out.print("Podaj kategorie: ");
            kategoria = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyString(kategoria);

            return new Wydatki(idKonta, kwota, kategoria);
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dane: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int daneUsunWydatki(){
        try {
            System.out.print("Podaj id konta: ");
            String idWydatkuStr = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyInt(idWydatkuStr);
            int idWydatku = Integer.parseInt(idWydatkuStr);

            return idWydatku;
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dane: " + e.getMessage());
            return 0;
        }
    }









}
