package Models;

public class Catering {
    private int id;
    private String nazivSluzbe;
    private Paket paketUsluge;
    private int brojOsoblja;

    public Catering(int id, String nazivSluzbe, Paket paketUsluge, int brojOsoblja) {
        this.id = id;
        this.nazivSluzbe = nazivSluzbe;
        this.paketUsluge = paketUsluge;
        this.brojOsoblja = brojOsoblja;
    }

    public int getId() {
        return id;
    }

    public String getNazivSluzbe() {
        return nazivSluzbe;
    }

    public void setNazivSluzbe(String nazivSluzbe) {
        this.nazivSluzbe = nazivSluzbe;
    }

    public Paket getPaketUsluge() {
        return paketUsluge;
    }

    public void setPaketUsluge(Paket paketUsluge) {
        this.paketUsluge = paketUsluge;
    }

    public int getBrojOsoblja() {
        return brojOsoblja;
    }

    public void setBrojOsoblja(int brojOsoblja) {
        this.brojOsoblja = brojOsoblja;
    }

    @Override
    public String toString() {
        return "Catering sluzba (id: " + id + "): " + nazivSluzbe + "\n" +
                "Broj osoblja: " + brojOsoblja + "\n" +
                paketUsluge;
    }
}