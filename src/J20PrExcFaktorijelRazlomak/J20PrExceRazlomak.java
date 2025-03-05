import java.util.Scanner;

public class J20PrExceRazlomak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // Input first fraction
                System.out.println("Unesi brojnik i nazivnik prvog razlomka (brojnik, enter, nazivnik):");
                if (!scanner.hasNextInt()) {
                    scanner.next(); // Consume invalid input
                    throw new IllegalArgumentException("Unijeli ste pogrešan znak, unesite ponovo!");
                }
                int brojnik1 = scanner.nextInt();

                if (!scanner.hasNextInt()) {
                    scanner.next();
                    throw new IllegalArgumentException("Unijeli ste pogrešan znak, unesite ponovo!");
                }
                int nazivnik1 = scanner.nextInt();

                // Input second fraction
                System.out.println("Unesi brojnik i nazivnik drugog razlomka (brojnik, enter, nazivnik):");
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    throw new IllegalArgumentException("Unijeli ste pogrešan znak, unesite ponovo!");
                }
                int brojnik2 = scanner.nextInt();

                if (!scanner.hasNextInt()) {
                    scanner.next();
                    throw new IllegalArgumentException("Unijeli ste pogrešan znak, unesite ponovo!");
                }
                int nazivnik2 = scanner.nextInt();

                // Validate nazivnikominators
                if (nazivnik1 == 0 || nazivnik2 == 0) {
                    throw new IllegalArgumentException("Nazivnik ne može biti nula, unesite ponovo!");
                }

                // Compute results
                String zbroj = zbrojRazlomaka(brojnik1, nazivnik1, brojnik2, nazivnik2);
                String razlika = razlikaRazlomaka(brojnik1, nazivnik1, brojnik2, nazivnik2);
                String produkt = umnozakRazlomaka(brojnik1, nazivnik1, brojnik2, nazivnik2);
                String kolicnik = kolicnikRazlomaka(brojnik1, nazivnik1, brojnik2, nazivnik2);

                // Display results
                System.out.println("Zbroj je: " + zbroj);
                System.out.println("Razlika je: " + razlika);
                System.out.println("Umnožak je: " + produkt);
                System.out.println("Količnik je: " + kolicnik);

                break; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("Izuzetak: " + e.getMessage());
                scanner.nextLine(); // Clear input buffer
            }
        }

        scanner.close(); // Close scanner after successful input
    }

    // Methods for fraction operations
    public static String zbrojRazlomaka(int brojnik1, int nazivnik1, int brojnik2, int nazivnik2) {
        int brojnik = brojnik1 * nazivnik2 + brojnik2 * nazivnik1;
        int nazivnik = nazivnik1 * nazivnik2;
        return skratiRazlomak(brojnik, nazivnik);
    }

    public static String razlikaRazlomaka(int brojnik1, int nazivnik1, int brojnik2, int nazivnik2) {
        int brojnik = brojnik1 * nazivnik2 - brojnik2 * nazivnik1;
        int nazivnik = nazivnik1 * nazivnik2;
        return skratiRazlomak(brojnik, nazivnik);
    }

    public static String umnozakRazlomaka(int brojnik1, int nazivnik1, int brojnik2, int nazivnik2) {
        int brojnik = brojnik1 * brojnik2;
        int nazivnik = nazivnik1 * nazivnik2;
        return skratiRazlomak(brojnik, nazivnik);
    }

    public static String kolicnikRazlomaka(int brojnik1, int nazivnik1, int brojnik2, int nazivnik2) {
        int brojnik = brojnik1 * nazivnik2;
        int nazivnik = nazivnik1 * brojnik2;
        if (nazivnik == 0) return "undefined"; // Prevent division by zero
        return skratiRazlomak(brojnik, nazivnik);
    }

    public static String skratiRazlomak(int brojnik, int nazivnik) {
        int najveciZajednickiDjeljitelj = najveciZajednickiDjeljitelj(Math.abs(brojnik), Math.abs(nazivnik));
        brojnik /= najveciZajednickiDjeljitelj;
        nazivnik /= najveciZajednickiDjeljitelj;

        if (nazivnik < 0) {
            brojnik = -brojnik;
            nazivnik = -nazivnik;
        }

        return brojnik + "/" + nazivnik;
    }

    public static int najveciZajednickiDjeljitelj(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
