import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;


public class Java12P10 {
    public static void main(String[] args) {
        String fakultet = "Fakultet organizacije i informatike Varazdin";
        String[] rijeciFakultet = fakultet.split(" ");
        for (String s : rijeciFakultet) {
            out.println(s);
        }
        String recenica = "   Danas je bio hladan dan   ";
        out.println(recenica);
        out.println("Unos ima znakova: " + recenica.length());
        recenica = recenica.trim(); // uklanja prazne razmake na pocetku i na kraju
        out.println(recenica);
        out.println("Broj znakova nakon skracivanja: " + recenica.length());


        out.println("\n\n----------------------Zadatak 1-------------------------");

        Scanner scanner = new Scanner(in).useLocale(Locale.US);

        String[] imePrezimeArray;
        while (true) { // beskonacna petlja dok ne dode break
            out.print("Unesite ime i prezime: ");
            String imePrezime = scanner.nextLine().trim(); // trim ukloni space-ove na sa pocetka i kraja stringa

            imePrezimeArray = imePrezime.split("\\s+"); // odvoji rijeci zasebno po space-u

            if (imePrezimeArray[0].length() > 7) {
                out.println("Ime sadrzi vise od 7 znakova! Pokusajte ponovo.");
                continue;
            }
            break;
        }

        System.out.println("Upisali ste ime: " + imePrezimeArray[0]);
        System.out.println("Upisali ste ime: " + imePrezimeArray[1]);

        System.out.print("Unesite ime grada: ");
        String grad = scanner.nextLine().toLowerCase(); // Convert to lowercase

        System.out.print("Samoglasnici u stringu: \n");

        // Set is an interface in Java that represents a collection of elements where no duplicates are allowed.
        // HashSet is a class that implements the Set interface.
        Set<Character> uniqueVowels = new HashSet<>();

        for (char c : grad.toCharArray()) { // pretvara string u polje char-ova
            if (("aeiou".indexOf(c) != -1) && uniqueVowels.add(c)) { // provjerava ima li samoglasnik i ponavlja li se taj samoglasnik
                System.out.println(grad + " ima samoglasnik " + c);
            }
        }

    } // end main
} // end class
