package Models;

public class Lokacija {
    private int id;
    private Tema tema;
    private Sala sala;

    public Lokacija(int id, Tema tema, Sala sala) {
        this.id = id;
        this.tema = tema;
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Lokacija (id: " + id + "):\n" +
                tema + "\n" + sala;
    }
}
