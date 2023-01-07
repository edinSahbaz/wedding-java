import Models.*;

public class Main {
    public static void main(String[] args) {
        Fotograf f = new Fotograf(1, "Edin", "Sahbaz", 400);
        Maticar m = new Maticar(1, "Edin", "Sahbaz", 125920394);
        Hrana h = new Hrana(1, "Tradicionalna bosanska kuhinja");
        Pice p = new Pice(1, "Alkhoholna pica");
        Paket paket = new Paket(1, "Osnovni paket", 60, h, p);

        System.out.println(f);
        System.out.println(m);
        System.out.println(h);
        System.out.println(p);
        System.out.println(paket);
    }
}