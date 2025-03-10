package J23Pr;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class J23BinarniPdf {
    public static void main(String[] args) {
        String ulazniFile = null; // u ovu var spremamo putanju na ulazni fajl
        String izlazniFile = null; // putanja izlaznog fajla
        Scanner scanner = new Scanner(in).useLocale(Locale.US);
        InputStream ulaz = null;
        OutputStream izlaz = null;

        try {
            // Unos putanje ulaznog fajla
            out.print("Unesite putanju originalne datoteke: ");
            ulazniFile = scanner.nextLine();
            File inputFile = new File(ulazniFile);
            ulaz = new BufferedInputStream(new FileInputStream(inputFile)); // Buffered input stream for better performance

            // Read binary data
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] byteChunk = new byte[4096]; // Read in chunks of 4KB
            int bytesRead;
            while ((bytesRead = ulaz.read(byteChunk)) != -1) {
                buffer.write(byteChunk, 0, bytesRead);
            }
            byte[] fileData = buffer.toByteArray(); // Store the file contents in a byte array

            // Unos putanje izlaznog fajla
            out.print("Unesite putanju kopirane datoteke: ");
            izlazniFile = scanner.nextLine();
            File outputFile = new File(izlazniFile);

            // Ako izlazni fajl vec odprije postoji, ispisujemo njegov sadržaj i brišemo ga
            if (outputFile.exists()) {
                out.println("Izlazni fajl vec postoji. Sadrzaj (prvih 100 bajtova):");

                try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(outputFile))) {
                    byte[] existingData = new byte[100]; // Read first 100 bytes for preview
                    int readBytes = reader.read(existingData);
                    if (readBytes > 0) {
                        for (int i = 0; i < readBytes; i++) {
                            out.print((char) existingData[i]); // Print as characters
                        }
                        out.println();
                    }
                }

                out.println("Brisem postojeci izlazni fajl: ");
                if (!outputFile.delete()) {
                    System.err.println("Greska: Ne mogu obrisati postojeci izlazni fajl!");
                    return;
                }
            }

            // Kreiramo izlazni fajl i upisujemo podatke
            izlaz = new DataOutputStream(new FileOutputStream(outputFile));
            izlaz.write(fileData); // Write full binary data from input

            out.println("VAZNO!!!! Prvo treba zatvoriti ulaz i izlaz da bi mogli izbrisati fajl !!!!!!!!");

            if (ulaz != null) ulaz.close();  // Properly close InputStream
            if (izlaz != null) izlaz.close();  // Properly close OutputStream

            out.println("Program uspjesno izvrsen !!!!!!");

            // Pitamo korisnika želi li obrisati novostvoreni fajl
            out.print("Zelite li izbrisati novostvoreni fajl? (Y/N): ");
            String userInput = scanner.nextLine().trim().toUpperCase();

            if (userInput.equals("Y")) {
                if (outputFile.delete()) {
                    out.println("Novostvoreni fajl uspjesno obrisan.");
                } else {
                    System.err.println("Greska: Ne mogu obrisati novostvoreni fajl!");
                }
            } else {
                out.println("Fajl nije obrisan.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Greska jer fajl nije pronaden: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Greska prilikom citanja ili pisanja je slijedeca: " + e.getMessage());
        } finally {
            out.println("Kraj programa !!!!!!");
        }
    }
}
