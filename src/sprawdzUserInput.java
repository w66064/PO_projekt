public class sprawdzUserInput {

    public static void sprawdzCzyInt(String idKontaStr) throws IllegalArgumentException {
        try {
            int idKonta = Integer.parseInt(idKontaStr);
            if (idKonta <= 0) {
                throw new IllegalArgumentException("Wartosc musi byc wieksza od zera");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Niepoprawny format liczby calkowitej");
        }
    }

    public static void sprawdzCzyFloat(String kwotaStr) throws IllegalArgumentException {
        try {
            float kwota = Float.parseFloat(kwotaStr);
            if (kwota <= 0) {
                throw new IllegalArgumentException("Wartosc musi byc wieksza od zera");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Niepoprawny format liczby zmiennoprzecinkowej");
        }
    }

    public static void sprawdzCzyString(String kategoria) throws IllegalArgumentException {
        if (kategoria == null || kategoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Wartosc nie moze byc pusta lub skladac sie tylko z bialych znakow");
        }
    }
}
