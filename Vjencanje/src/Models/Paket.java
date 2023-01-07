package Models;

public class Paket {
    private int id;
    private String nazivPaketa;
    private float cijenaPoOsobi;
    private Hrana paketHrane;
    private Pice paketPica;

    public Paket(int id, String nazivPaketa, float cijenaPoOsobi, Hrana paketHrane, Pice paketPica) {
        this.id = id;
        this.nazivPaketa = nazivPaketa;
        this.cijenaPoOsobi = cijenaPoOsobi;
        this.paketHrane = paketHrane;
        this.paketPica = paketPica;
    }

    public int getId() {
        return id;
    }

    public String getNazivPaketa() {
        return nazivPaketa;
    }

    public void setNazivPaketa(String nazivPaketa) {
        this.nazivPaketa = nazivPaketa;
    }

    public float getCijenaPoOsobi() {
        return cijenaPoOsobi;
    }

    public void setCijenaPoOsobi(float cijenaPoOsobi) {
        this.cijenaPoOsobi = cijenaPoOsobi;
    }

    public Hrana getPaketHrane() {
        return paketHrane;
    }

    public void setPaketHrane(Hrana paketHrane) {
        this.paketHrane = paketHrane;
    }

    public Pice getPaketPica() {
        return paketPica;
    }

    public void setPaketPica(Pice paketPica) {
        this.paketPica = paketPica;
    }

    @Override
    public String toString() {
        return "Paket usluga (id: " + id + "):" +
                "\nNaziv paketa: " + nazivPaketa +
                "\nCijena paketa po osobi: " + cijenaPoOsobi + "KM" +
                "\n" + paketHrane +
                "\n" + paketPica;
    }
}
