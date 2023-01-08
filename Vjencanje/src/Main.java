import Models.*;

public class Main {
    public static void main(String[] args) {
        Fotograf f = new Fotograf(1, "Edin", "Sahbaz", 400);
        Maticar m = new Maticar(1, "Edin", "Sahbaz", 125920394);
        Hrana h = new Hrana(1, "Tradicionalna bosanska kuhinja");
        Pice p = new Pice(1, "Alkhoholna pica");
        Paket paket = new Paket(1, "Osnovni paket", 60, h, p);
        Catering c = new Catering(1, "ABC Catering", paket, 20);
        Tema t = new Tema(1, "Standardna tema", 10);
        Sala s = new Sala(1, "Bulevar Mese Selimovica 18", 300);
        Lokacija l = new Lokacija(1, t, s);

        System.out.println(l);
    }
}