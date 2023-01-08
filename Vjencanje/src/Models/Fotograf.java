package Models;

public class Fotograf extends Osoblje {
    private float cijena;

    public Fotograf (int id, String ime, String prezime, float cijena) {
        super(id, ime, prezime);
        this.cijena = cijena;
    }

    public float getCijena() {
        return cijena;
    }

    public void setCijena(float cijena) {
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return super.toString() + ", cijena: " + cijena + "KM";
    }
}
