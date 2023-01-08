package Models;

public class Uloga {
    private int id;
    private String naziv;

    public Uloga(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Uloga (id: " + id + "): " + naziv;
    }
}
