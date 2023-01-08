package Models;

import Helpers.DateHelper;

public class Osoba extends Ucesnik {
    private Uloga uloga;

    public Osoba(int id, String ime, String prezime, Uloga uloga) {
        super(id, ime, prezime);
        this.uloga = uloga;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    @Override
    public String toString() {
        return super.toString() + ", uloga: " + uloga.getNaziv();
    }
}
