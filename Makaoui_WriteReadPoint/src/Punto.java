/*
 * Autore: Makaoui Youness
 * Data: 21/9/2026
 * Classe: 5G
 * Luogo:
 * Descrizione:
 */

import java.io.RandomAccessFile;
import java.io.IOException;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void scriviSuFile(RandomAccessFile file) throws IOException {
        file.writeDouble(x);
        file.writeDouble(y);
    }

    public void leggiDaFile(RandomAccessFile file) throws IOException {
        x = file.readDouble();
        y = file.readDouble();
    }

    public void stampa() {
        System.out.println("Punto: (" + x + ", " + y + ")");
    }

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("punto.txt", "rw");

            // Creo il punto
            Punto p = new Punto(10.5, 20.3);

            // Scrivo il punto nel file
            p.scriviSuFile(file);

            // Riporto il cursore all'inizio del file
            file.seek(0);

            // Creo un nuovo punto e leggo i dati dal file
            Punto p2 = new Punto(0, 0);
            p2.leggiDaFile(file);

            // Visualizzo il punto letto
            p2.stampa();

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}