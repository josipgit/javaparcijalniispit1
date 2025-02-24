package J14PrExteInteGeomLikovi;

public abstract class GeometrijskiLik implements Comparable<GeometrijskiLik> {
    String naziv;

    public GeometrijskiLik(String naziv) {
        this.naziv = naziv;
    }

    public abstract double Povrsina();

    public abstract double Opseg();

    public int compareTo(GeometrijskiLik other) {
        return Double.compare(this.Povrsina(), other.Povrsina());
    }

}
