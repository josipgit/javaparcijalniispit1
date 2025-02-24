package J14PrExteInteGeomLikovi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.System.out;

public class J14Pr12KrugTrokPrav {
    private String ime;
    private String prezime;
    private int OIB;

    public String dohvatiPodatke() {
        return (ime + " " + prezime + " " + OIB);
    }

    public static void main(String[] args) {

        Trokut trokut = new Trokut("trokutistan", 6, 8, 10);
        Krug krug = new Krug("krugistan", 5);
        Pravokutnik pravokutnik = new Pravokutnik("pravokutistan", 3, 4);

        double povKruga = krug.Povrsina();
        double povTrokuta = trokut.Povrsina();
        double povPravokutnika = pravokutnik.Povrsina();

        out.println(trokut);
        out.println(krug);
        out.println(pravokutnik);

        ArrayList<Double> povrsine = new ArrayList<>();
        povrsine.add(trokut.getPovrsinaTrokuta());
        povrsine.add(krug.getPovrsinaKruga());
        povrsine.add(pravokutnik.getPovrsinaPravokutnika());

        Collections.sort(povrsine);
        out.println(povrsine);

        out.println("\n\n----------------------------------------------------------");

        SviGeometrijskiLikovi likovi = new SviGeometrijskiLikovi(trokut, krug, pravokutnik);
        out.println(likovi);

        out.println("\n\n----------------------------------------------------------");


        ArrayList<GeometrijskiLik> geomlikovi = new ArrayList<>();
        geomlikovi.add(trokut);
        geomlikovi.add(krug);
        geomlikovi.add(pravokutnik);

        Collections.sort(geomlikovi);

        out.println("\nSortirani po povrsini: ");
        for (GeometrijskiLik lik : geomlikovi) {
            out.println(lik);
        }

    } // end main
} // end class
