public class Pravokutnik {

    int a;
    int b;

    public Pravokutnik(int a, int b) {
        this.a = a;
        this.b = b;
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



