public class Krug {
    double radius;

    public Krug(int radius) {
        this.radius = radius;
    }

    public double PovrsinaKruga() {
        return radius * radius * Math.PI;
    }

    public double OpsegKruga() {
        return 2 * radius * Math.PI;
    }

    public double getPovrsinaKruga() {
        return PovrsinaKruga();
    }

    @Override
    public String toString() {
        return "Krug {" + " " +
                "radius=" + radius + " " +
                "Povrsina kruga je " + PovrsinaKruga() + " " +
                "Opseg kruga je " + OpsegKruga() + " " +
                '}';
    }
}

