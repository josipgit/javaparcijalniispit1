package J14PrMultConstrStudKrugTrok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class J14Pr12StudKrugTrokPrav {
    private String ime;
    private String prezime;
    private int OIB;

    public String dohvatiPodatke() {
        return (ime + " " + prezime + " " + OIB);
    }

    public static void main(String[] args) {
        J14Pr12StudKrugTrokPrav polaznik1 = new J14Pr12StudKrugTrokPrav();
        J14Pr12StudKrugTrokPrav polaznik2 = new J14Pr12StudKrugTrokPrav();
        polaznik1.ime = "Ivan";
        polaznik1.prezime = "Ivic";
        polaznik1.OIB = 456237452;

        out.println(polaznik1.dohvatiPodatke());

        Studenti student1 = new Studenti("Ivan", "Ivic", 12345, "matematika", "hrvatski", "engleski");
        out.println(student1);
        out.println(student1.getIme());
        out.println(student1.getBrojIndeksa());
        student1.setPrezime("Ivanovic");
        out.println(student1);
        out.println(student1.getListaIspita());

        Studenti student2 = new Studenti("Marko", "Markovic", "mat", "eng", "fiz");
        out.println(student2);
        ArrayList<String> lista2 = new ArrayList<>(List.of("predmet1", "predmet2"));
        student2.setListaIspita(lista2);
        out.println(student2);

        Trokut trokut = new Trokut(1, 2, 3);
        Krug krug = new Krug(5);
        Pravokutnik pravokutnik = new Pravokutnik("krpalo",3, 4);

        double povKruga = krug.PovrsinaKruga();
        double povTrokuta = trokut.PovrsinaTrokuta();
        double povPravokutnika = pravokutnik.PovrsinaPravokutnika();

        //out.println(trokut);
        //out.println(krug);
        //out.println(pravokutnik);

        ArrayList<Double> povrsine = new ArrayList<>();
        povrsine.add(trokut.getPovrsinaTrokuta());
        povrsine.add(krug.getPovrsinaKruga());
        povrsine.add(pravokutnik.getPovrsinaPravokutnika());

        Collections.sort(povrsine);
        out.println(povrsine);


    } // end main
} // end class
