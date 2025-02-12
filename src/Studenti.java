import java.util.ArrayList;
import java.util.Arrays;

public class Studenti {
    private String ime;
    private String prezime;
    private int brojIndeksa;
    private ArrayList<String> listaIspita= new ArrayList<>();

    public Studenti(String ime, String prezime, int brojIndeksa, String ispit1, String ispit2, String ispit3) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa = brojIndeksa;
        listaIspita.add(ispit1);
        listaIspita.add(ispit2);
        listaIspita.add(ispit3);
    }

    public Studenti(String ime, String prezime, String... ispiti) {
        this.ime = ime;
        this.prezime = prezime;
        this.listaIspita.addAll(Arrays.asList(ispiti));
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(int brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public ArrayList<String> getListaIspita() {
        return listaIspita;
    }

    public void setListaIspita(ArrayList<String> listaIspita) {
        this.listaIspita = listaIspita;
    }

    @Override
    public String toString() {
        return "Studenti{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", brojIndeksa=" + brojIndeksa +
                '}';
    }
}
