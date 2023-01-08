package Models;

public class Osoblje {
    private int id;
    private String ime;
    private String prezime;

    public Osoblje(int id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getId() {
        return id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPrezime() {
        return prezime;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (id: " + id + ") " + ime + " " + prezime;
    }
}
