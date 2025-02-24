package J14PrExteInteGeomLikovi;

public class SviGeometrijskiLikovi {
    // Objects of the three types.
    private Trokut trokut;
    private Krug krug;
    private Pravokutnik pravokutnik;

    // Constructor that accepts objects for each type.
    public SviGeometrijskiLikovi(Trokut trokut, Krug krug, Pravokutnik pravokutnik) {
        this.trokut = trokut;
        this.krug = krug;
        this.pravokutnik = pravokutnik;
    }

    // toString method to display the information about all contained objects.
    @Override
    public String toString() {
        return "Svi geometrijski likovi: {" +
                "\n  Trokut: " + trokut +
                ",\n  Krug: " + krug +
                ",\n  Pravokutnik: " + pravokutnik +
                "\n}";
    }
}

