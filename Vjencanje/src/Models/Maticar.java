package Models;

public class Maticar {
    private int id;
    private String ime;
    private String prezime;
    private int brojLicence;

    public Maticar(int id, String ime, String prezime, int brojLicence) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.brojLicence = brojLicence;
    }

    public int getId() {
        return id;
    }

    public int getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(int brojLicence) {
        this.brojLicence = brojLicence;
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
        return "Maticar (id: " + id + ") " + ime + " " + prezime + ", broj licence: " + brojLicence;
    }
}
