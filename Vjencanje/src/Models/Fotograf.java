package Models;

public class Fotograf {
    private String ime;
    private String prezime;
    private float cijena;

    public Fotograf (String ime, String prezime, float cijena) {
        this.ime = ime;
        this.prezime = prezime;
        this.cijena = cijena;
    }

    public float getCijena() {
        return cijena;
    }

    public void setCijena(float cijena) {
        this.cijena = cijena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return "Fotograf " + ime + " " + prezime + ", cijena: " + cijena;
    }
}
