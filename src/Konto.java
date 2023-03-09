import java.util.Scanner;

public class Konto implements UserInputKonto {
    private int id;
    private String nazwa;
    Scanner scanner = new Scanner(System.in);

    public Konto(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public Konto(){

    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    @Override
    public Konto daneDodajKonto() {
        try {
            System.out.print("Podaj id konta: ");
            String idKontaStr = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyInt(idKontaStr);
            id = Integer.parseInt(idKontaStr);

            System.out.print("Podaj kategorie: ");
            nazwa = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyString(nazwa);

            return new Konto(id, nazwa);
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dane: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int daneUsunKonto(){
        try {
            System.out.print("Podaj id konta: ");
            String idStr = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyInt(idStr);
            int id = Integer.parseInt(idStr);

            return id;
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dane: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public Konto daneZmienNazwe(){
        try {
            System.out.print("Podaj id konta: ");
            String idKontaStr = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyInt(idKontaStr);
            id = Integer.parseInt(idKontaStr);

            System.out.print("Podaj kategorie: ");
            nazwa = scanner.nextLine();
            sprawdzUserInput.sprawdzCzyString(nazwa);

            return new Konto(id, nazwa);
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dane: " + e.getMessage());
            return null;
        }
    }
}
