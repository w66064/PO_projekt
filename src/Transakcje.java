import java.time.LocalDate;
public class Transakcje  {
    private int id;
    public int idKonta;
    private LocalDate data;
    public float kwota;

    public Transakcje(int id, int idKonta, LocalDate data, float kwota) {
        this.id = id;
        this.idKonta = idKonta;
        this.data = data;
        this.kwota = kwota;
    }

    public Transakcje(){

    }

    public int getId() {
        return id;
    }

    public int getIdKonta() {
        return idKonta;
    }

    public LocalDate getData() {
        return data;
    }

    public float getKwota() {
        return kwota;
    }

}
