package Models;

public class Usluga {
    protected int id;
    protected String vrsta;

    public Usluga(int id, String vrsta) {
        this.id = id;
        this.vrsta = vrsta;
    }

    public int getId() {
        return id;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }
}
