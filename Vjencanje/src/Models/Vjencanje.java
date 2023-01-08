package Models;

import Helpers.DateHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Vjencanje {
    private int id;
    private Date termin;
    private Lokacija lokacija;
    private Maticar maticar;
    private Fotograf fotograf;
    private Catering catering;
    private ArrayList<Osoba> osobe;

    public Vjencanje(int id, Date termin, Lokacija lokacija, Maticar maticar, Fotograf fotograf, Catering catering) {
        this.id = id;
        this.termin = termin;
        this.lokacija = lokacija;
        this.maticar = maticar;
        this.fotograf = fotograf;
        this.catering = catering;
        this.osobe = new ArrayList<Osoba>();
    }

    public int getId() {
        return id;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }

    public Fotograf getFotograf() {
        return fotograf;
    }

    public void setFotograf(Fotograf fotograf) {
        this.fotograf = fotograf;
    }

    public Maticar getMaticar() {
        return maticar;
    }

    public void setMaticar(Maticar maticar) {
        this.maticar = maticar;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Catering getCatering() {
        return catering;
    }

    public void setCatering(Catering catering) {
        this.catering = catering;
    }

    public ArrayList<Osoba> getOsobe() {
        return osobe;
    }

    public void setOsobe(ArrayList<Osoba> osobe) {
        this.osobe = osobe;
    }

    public void addOsoba (Osoba osoba) {
        osobe.add(osoba);
    }

    public void removeOsoba (Osoba osoba) {
        osobe.remove(osoba);
    }

    @Override
    public String toString() {
        String dateOutput = DateHelper.getDateInFormat(termin, "dd.MM.yyyy hh:mm");
        String gostiOutput = osobe.stream().map(Object::toString)
                .collect(Collectors.joining("\n"));

        return "Vjencanje (id: " + id + "):" +
                "\nTermin: " + dateOutput  + "\n" +
                lokacija + "\n" + maticar + "\n" + fotograf + "\n" + catering
                + "\nGosti:\n" + gostiOutput;
    }
}
