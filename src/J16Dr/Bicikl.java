package J16Dr;

import static java.lang.System.out;

public class Bicikl extends  Vozilo{
    String vrsta;

    public Bicikl(String tip, Double brzina, String vrsta) {
        super(tip, brzina);
        this.vrsta = vrsta;
    }

    @Override
    public boolean kretanje() {
        out.println("Bicikl: " + tip + "Vrsta: " + vrsta + " se krece brzinom " + brzina);
        return false;
    }

} // end class
