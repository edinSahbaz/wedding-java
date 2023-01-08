package Models;

import Helpers.DateHelper;

import java.util.Date;

public class Racun {
    private int id;
    private Vjencanje vjencanje;
    private float iznos;
    private Date datumIzdavanja;

    public Racun(int id, Vjencanje vjencanje) {
        this.id = id;
        this.vjencanje = vjencanje;
        this.datumIzdavanja = new Date();
        calculateIznos();
    }

    private void calculateIznos() {
        int brojOsoba = vjencanje.getOsobe().size();
        float cijenaFotografa = vjencanje.getFotograf().getCijena();
        float cijenaCateringaPoOsobi = vjencanje.getCatering().getPaketUsluge().getCijenaPoOsobi();
        float cijenaSalePoOsobi = vjencanje.getLokacija().getTema().getCijenaPoMjestu();

        this.iznos = cijenaFotografa + brojOsoba * (cijenaCateringaPoOsobi + cijenaSalePoOsobi);
    }

    public int getId() {
        return id;
    }

    public Vjencanje getVjencanje() {
        return vjencanje;
    }

    public void setVjencanje(Vjencanje vjencanje) {
        this.vjencanje = vjencanje;
        this.datumIzdavanja = new Date();
        calculateIznos();
    }

    public float getIznos() {
        return iznos;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    @Override
    public String toString() {
        String datumVjencanja = DateHelper.getDateInFormat(vjencanje.getTermin(), "dd.MM.yyyy hh:mm");
        String datumRacuna = DateHelper.getDateInFormat(vjencanje.getTermin(), "dd.MM.yyyy hh:mm");

        return "Iznos racuna za vjencanje "
                + vjencanje.getLokacija().getSala().getAdresa() + ", " + datumVjencanja + ": " + iznos + "KM"
                + "\nDatum i vrijeme izdavanja racuna: " + datumRacuna;
    }
}
