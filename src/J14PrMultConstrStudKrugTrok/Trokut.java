package J14PrMultConstrStudKrugTrok;

public class Trokut {

    int a;
    int b;
    int c;

    public Trokut(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double PovrsinaTrokuta() {
        double s = 0.5*(a+b+c);
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public int OpsegTrokuta() {
        return a + b + c;
    }

    public double getPovrsinaTrokuta() {
        return PovrsinaTrokuta();
    }

    @Override
    public String toString() {
        return "Trokut {" + " " +
                "a=" + a + " " +
                ", b=" + b + " " +
                ", c=" + c + " " +
                " Povrsina trokuta je " + PovrsinaTrokuta() + " " +
                "Opseg trokuta je " + OpsegTrokuta() + " " +
                "}";


    }
}
