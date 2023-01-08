package Models;

public class Sala {
    private int id;
    private String adresa;
    private int kapacitet;

    public Sala(int id, String adresa, int kapacitet) {
        this.id = id;
        this.adresa = adresa;
        this.kapacitet = kapacitet;
    }

    public int getId() {
        return id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    @Override
    public String toString() {
        return "Sala (id: " + id + "):\nAdresa: " + adresa + "\nKapacitet: " + kapacitet + " mjesta";
    }
}
