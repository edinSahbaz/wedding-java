import Models.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Fotograf f = new Fotograf(1, "Edin", "Sahbaz", 400);
        Maticar m = new Maticar(1, "Edin", "Sahbaz", 125920394);
        Hrana h = new Hrana(1, "Mediteranska");
        Pice p = new Pice(1, "Alkhoholna pica");
        Paket paket = new Paket(1, "Osnovni paket", 50, h, p);
        Catering c = new Catering(1, "ABC Catering", paket, 20);
        Tema t = new Tema(1, "Standardna tema", 20);
        Sala s = new Sala(1, "Bulevar Mese Selimovica 18", 300);
        Lokacija l = new Lokacija(1, t, s);

        Uloga mladozenja = new Uloga(1, "Mladozenja");
        Uloga mlada = new Uloga(2, "Mlada");
        Uloga gost = new Uloga(3, "Gost");

        Osoba o1 = new Osoba(1, "Ime1", "Prezime1", mladozenja);
        Osoba o2 = new Osoba(2, "Ime2", "Prezime2", mlada);
        Osoba o3 = new Osoba(3, "Ime3", "Prezime3", gost);
        Osoba o4 = new Osoba(4, "Ime4", "Prezime4", gost);
        Osoba o5 = new Osoba(5, "Ime5", "Prezime5", gost);

        Date termin = new Date();

        Vjencanje v = new Vjencanje(1, termin, l, m, f, c);
        v.addOsoba(o1);
        v.addOsoba(o2);
        v.addOsoba(o3);
        v.addOsoba(o4);
        v.addOsoba(o5);

        v.removeOsoba(o4);

        Racun r = new Racun(1, v);

        System.out.println(r);
    }
}