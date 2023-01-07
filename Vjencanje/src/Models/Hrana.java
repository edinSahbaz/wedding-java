package Models;

public class Hrana extends Usluga {
    public Hrana(int id, String vrsta) {
        super(id, vrsta);
    }

    @Override
    public String toString() {
        return "Paket hrane (id: " + id + "): " + vrsta;
    }
}
