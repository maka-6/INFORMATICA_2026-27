/*
 * Nome: Makaoui Youness
 * Classe: 5G
 * Data: 20/09/2026
 * Descrizione: Programma per la gestione degli appuntamenti
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestioneAppuntamenti gestore = new GestioneAppuntamenti();

        int scelta;

        do {

            System.out.println("\n==============================");
            System.out.println("GESTIONE APPUNTAMENTI");
            System.out.println("==============================");
            System.out.println("1. Inserire un appuntamento");
            System.out.println("2. Visualizzare tutti gli appuntamenti");
            System.out.println("3. Cercare appuntamenti per giorno");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {

                case 1:

                    System.out.print("Inserisci la data (gg/mm/aaaa): ");
                    String data = scanner.nextLine();

                    System.out.print("Inserisci l'ora: ");
                    String ora = scanner.nextLine();

                    System.out.print("Inserisci la descrizione: ");
                    String descrizione = scanner.nextLine();

                    Appuntamento nuovo =
                            new Appuntamento(data, ora, descrizione);

                    gestore.inserisciAppuntamento(nuovo);

                    break;

                case 2:

                    gestore.visualizzaAppuntamenti();

                    break;

                case 3:

                    System.out.print("Inserisci la data da cercare: ");
                    String dataRicerca = scanner.nextLine();

                    gestore.cercaPerData(dataRicerca);

                    break;

                case 4:

                    System.out.println("Programma terminato.");

                    break;

                default:

                    System.out.println("Scelta non valida.");

            }

        } while (scelta != 4);

        scanner.close();
    }
}