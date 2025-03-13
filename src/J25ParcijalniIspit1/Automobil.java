package J25ParcijalniIspit1;

public class Automobil extends Vozilo
{
    int brojVrata;

    public Automobil(String regBroj, String marka, int godinaProizvodnje, int brojVrata) throws MojaIznimka {
        super(regBroj, marka, godinaProizvodnje);
        if (brojVrata < 0) {
            throw new MojaIznimka("Broj vrata ne moze bit negativan !!!!!!!!!!!!", "Korisnik: JOSIP");
        }
        this.brojVrata = brojVrata;
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(int brojVrata) {
        this.brojVrata = brojVrata;
    }

    @Override
    public String prikaziPodatke() {
        return super.prikaziPodatke() + " Broj vrata: " + brojVrata;
    }

} // end class
