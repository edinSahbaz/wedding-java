import Models.Fotograf;
import Models.Maticar;

public class Main {
    public static void main(String[] args) {
        Fotograf f = new Fotograf("Edin", "Sahbaz", 400);
        Maticar m = new Maticar("Edin", "Sahbaz", 125920394);

        System.out.println(f);
        System.out.println(m);
    }
}