package J25ParcijalniIspit1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.out;

public class EvidencijaVozila {
    public static void main(String[] args) {
        ArrayList<Vozilo> lista = new ArrayList<Vozilo>();

        Automobil auto1 = null;
        Automobil auto2 = null;
        Motocikl moto1 = null;
        Motocikl moto2 = null;

        try {
            auto1 = new Automobil("ST-1234-ZG", "AUDI", 2022, 5);
            auto2 = new Automobil("ZG-4321-ST", "VW", 2018, 3);
            moto1 = new Motocikl("RI-9999-OS", "Harley-Davidson", 1995, "benzinski");
            moto2 = new Motocikl("OS-1111-RI", "Tomos", 1965, "benzinski");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        lista.add(auto1);
        lista.add(auto2);
        lista.add(moto1);
        lista.add(moto2);

        for (Vozilo v : lista) {
            out.println(v.prikaziPodatke());
        }

        out.println("----------------------------------------------------------");

        auto1.setBrojVrata(7);
        out.println(auto1.brojVrata);
        out.println(moto2.getTipMotora());

        out.println("----------------------------------------------------------");

        spremiPodatkeUDatoteku("C:\\Users\\josip\\IntelliJProjects\\JavaTecaj\\src\\J25ParcijalniIspit1\\ListaVozila.txt", lista);

        out.println("/////////////////////////////////////////////");

        ucitajPodatkeIzDatoteke("C:\\Users\\josip\\IntelliJProjects\\JavaTecaj\\src\\J25ParcijalniIspit1\\ListaVozila.txt");

    } // end main

    public static void spremiPodatkeUDatoteku(String putanjaNaDatoteku, ArrayList<Vozilo> lista) {
        try (FileWriter writer = new FileWriter(putanjaNaDatoteku)) { // Automatically closes writer
            for (Vozilo v : lista) {
                writer.write(v.prikaziPodatke() + "\n");
            }
        } catch (IOException e) {
            out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void ucitajPodatkeIzDatoteke(String putanjaNaDatoteku) {
        try (FileReader reader = new FileReader(putanjaNaDatoteku)) { // Automatically closes reader
            int znakovi;
            StringBuilder stringBuilder = new StringBuilder();
            while ((znakovi = reader.read()) != -1) {
                stringBuilder.append((char) znakovi);
            }
            out.println("Sadržaj datoteke:");
            out.println(stringBuilder);
        } catch (IOException e) {
            out.println("Error reading file: " + e.getMessage());
        }
    }


} // end class
