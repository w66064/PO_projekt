import java.time.LocalDate;
import java.util.Scanner;

public class Przychody extends Transakcje implements UserInputPrzychody{
    Scanner scanner = new Scanner(System.in);
    private String zrodlo;

    public Przychody(int id, int idKonta, LocalDate data, float kwota, String zrodlo) {
        super(id, idKonta, data, kwota);
        this.zrodlo = zrodlo;
    }

    public Przychody(){

    }

    public Przychody(int idKonta, float kwota, String zrodlo){

    }

    public String getZrodlo() {
        return zrodlo;
    }

    @Override
    public Przychody daneDodajPrzychody() {
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
            zrodlo = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyString(zrodlo);

            return new Przychody(idKonta, kwota, zrodlo);
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dane: " + e.getMessage());
            return null;
        }

    }

    @Override
    public int daneUsunPrzychody(){
        try {
            System.out.print("Podaj id konta: ");
            String idWydatkuStr = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyInt(idWydatkuStr);
            int idPrzychodu = Integer.parseInt(idWydatkuStr);

            return idPrzychodu;
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dane: " + e.getMessage());
            return 0;
        }
    }

}
