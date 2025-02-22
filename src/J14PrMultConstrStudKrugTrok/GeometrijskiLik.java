package J14PrMultConstrStudKrugTrok;

public abstract class GeometrijskiLik {
    String naziv;

    public GeometrijskiLik(String naziv) {
        this.naziv = naziv;
    }

    public abstract double Povrsina ();

    public abstract double Opseg ();


}
