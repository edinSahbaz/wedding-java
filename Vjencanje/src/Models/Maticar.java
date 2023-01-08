package Models;

public class Maticar extends Ucesnik {
    private int brojLicence;

    public Maticar(int id, String ime, String prezime, int brojLicence) {
        super(id, ime, prezime);
        this.brojLicence = brojLicence;
    }

    public int getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(int brojLicence) {
        this.brojLicence = brojLicence;
    }

    @Override
    public String toString() {
        return super.toString() + ", broj licence: " + brojLicence;
    }
}
