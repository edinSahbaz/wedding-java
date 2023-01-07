package Models;

public class Pice extends Usluga {
    public Pice(int id, String vrsta) {
        super(id, vrsta);
    }

    @Override
    public String toString() {
        return "Paket pica (id: " + id + "): " + vrsta;
    }
}
