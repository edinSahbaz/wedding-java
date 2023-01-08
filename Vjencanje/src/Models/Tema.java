package Models;

public class Tema {
    private int id;
    private String naziv;
    private float cijenaPoMjestu;

    public Tema(int id, String naziv, float cijenaPoMjestu) {
        this.id = id;
        this.naziv = naziv;
        this.cijenaPoMjestu = cijenaPoMjestu;
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

    public float getCijenaPoMjestu() {
        return cijenaPoMjestu;
    }

    public void setCijenaPoMjestu(float cijenaPoMjestu) {
        this.cijenaPoMjestu = cijenaPoMjestu;
    }

    @Override
    public String toString() {
        return "Tema (id: " + id + "): " + naziv + ", cijena po mjestu: " + cijenaPoMjestu + "KM";
    }
}
