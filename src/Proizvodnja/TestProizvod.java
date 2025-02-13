package Proizvodnja;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.out;

public class TestProizvod {
    public static void main(String[] args) {
        int i = 0;
        ArrayList<Proizvod> proizvodi = new ArrayList<Proizvod>();
        String[] productNames = {"sunka", "sir", "jogurt", "kruh", "mlijeko", "break", "pasteta", "riba", "kruv", "cola", "karota", "kunpiri"};
        Random random = new Random();
        while (true) {  // vrti dok ne dode break
            String randomName = productNames[random.nextInt(productNames.length)]; // Random product name
            int randomPrice = random.nextInt(100) + 1; // Random price between 1 and 100
            int randomValue = random.nextInt(100) + 1; // Random value between 1 and 100

            Proizvod p1 = new Proizvod(randomName, randomPrice, randomValue);
            proizvodi.add(p1);
            out.println(p1.IspisiProizvod());
            if (randomName == "break") break;
        }

        out.println("\n--------------------Ispis svih proizvoda u Array listi:---------");
        for (Proizvod p : proizvodi) {
            out.println(p.IspisiProizvod() + " ");
        }

        double randomDouble = random.nextDouble();
        float randomFloat = random.nextFloat();
        float randomLong = random.nextLong();
        float randomInt = random.nextInt();

        out.println("\n---------------------Ispis randoma:-----------------------");
        out.println(randomDouble + "\n" + randomFloat + "\n" + randomLong + "\n" + randomLong + "\n" + randomInt);

    } // end main
} // end class
