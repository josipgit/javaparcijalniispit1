package J14PrMultConstrStudKrugTrok;

public class Pravokutnik extends GeometrijskiLik {

    int a;
    int b;

    public Pravokutnik(String naziv, int a, int b) {
        super(naziv);
        this.a = a;
        this.b = b;
    }

    public double Povrsina() {
        return a * b;
    }

    @Override
    public double Opseg() {
        return 0;
    }

    public int PovrsinaPravokutnika() {
        return a * b;
    }

    public int OpsegPravokutnika() {
        return a + a + b + b;
    }

    public double getPovrsinaPravokutnika() {
        return PovrsinaPravokutnika();
    }

    @Override
    public String toString() {
        return "Pravokutnik {" + " " +
                "a=" + a + " " +
                ", b=" + b + " " +
                "Povrsina pravokutnika je " + PovrsinaPravokutnika() + " " +
                "Opseg pravokutnika je " + OpsegPravokutnika() + " " +
                '}';
    }
}



