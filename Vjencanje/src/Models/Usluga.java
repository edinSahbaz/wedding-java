package Models;

public abstract class Usluga implements IDataModel {
    protected int id;
    protected String vrsta;

    public Usluga(int id, String vrsta) {
        this.id = id;
        this.vrsta = vrsta;
    }

    public int getId() {
        return id;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (id: " + id + "): " + vrsta;
    }
}
