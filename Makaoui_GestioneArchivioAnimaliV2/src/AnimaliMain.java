
/*
Autore: Makaoui Youness
Classe: 5G
Data: 2/10/2026
Oggetto: Gestione archivio animali
*/

import java.io.*;

class AnimaliMain {

    private static final String NOME_FILE = "animali.txt";

    private BufferedReader key;
    private GestioneAnimali gestioneAnimali;

    AnimaliMain() {
        key = new BufferedReader(new InputStreamReader(System.in));
        gestioneAnimali = new GestioneAnimali();
    }

    public static void main(String[] argv) {
        AnimaliMain programma = new AnimaliMain();
        programma.eseguiMenu();
    }

    private void eseguiMenu() {

        int scelta = -1;

        do {
            System.out.println("\n===== GESTIONE ARCHIVIO ANIMALI =====");
            System.out.println("1. Inserisci una scheda");
            System.out.println("2. Visualizza tutto l'archivio");
            System.out.println("3. Ricerca di una scheda tramite indice");
            System.out.println("4. Registra decesso");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            try {
                scelta = Integer.parseInt(key.readLine());

                switch (scelta) {

                    case 1:
                        inserisciScheda();
                        break;

                    case 2:
                        visualizzaArchivio();
                        break;

                    case 3:
                        ricercaPerIndice();
                        break;

                    case 4:
                        registraDecesso();
                        break;

                    case 0:
                        System.out.println("Arrivederci!");
                        break;

                    default:
                        System.out.println("Scelta non valida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido.");
            } catch (IOException e) {
                System.out.println("Errore durante la lettura dei dati.");
                break;
            }

        } while (scelta != 0);
    }

    private void inserisciScheda() throws IOException {

        System.out.println("\n===== INSERIMENTO SCHEDA =====");

        System.out.print("Matricola: ");
        String matricola = key.readLine();

        System.out.print("Nome: ");
        String nome = key.readLine();

        System.out.print("Razza: ");
        String razza = key.readLine();

        System.out.print("Anno di nascita: ");
        int annoNascita = Integer.parseInt(key.readLine());

        System.out.print("Anno di morte (0 se vivo): ");
        int annoMorte = Integer.parseInt(key.readLine());

        SchedaAnimale sa = new SchedaAnimale(
                matricola,
                nome,
                razza,
                annoNascita,
                annoMorte
        );

        gestioneAnimali.aggiungiScheda(sa);
        gestioneAnimali.scriviTutto();

        System.out.println("Scheda inserita correttamente.");
    }

    private void visualizzaArchivio() {

        System.out.println("\n===== ARCHIVIO ANIMALI =====");

        gestioneAnimali.leggiTutto();

        System.out.println(gestioneAnimali.toString());
    }

    private void ricercaPerIndice() throws IOException {

        System.out.println("\n===== RICERCA TRAMITE INDICE =====");

        System.out.print("Matricola da cercare: ");
        String matricola = key.readLine();

        try (RandomAccessFile f = new RandomAccessFile(NOME_FILE, "r")) {

            SchedaAnimale risultato =
                    gestioneAnimali.ricercaPerIndice(f, matricola);

            if (risultato != null) {
                System.out.println("Scheda trovata:");
                System.out.println(risultato);
            } else {
                System.out.println("Nessuna scheda trovata.");
            }
        }
    }

    private void registraDecesso() throws IOException {

        System.out.println("\n===== REGISTRAZIONE DECESSO =====");

        System.out.print("Matricola dell'animale: ");
        String matricola = key.readLine();

        try (RandomAccessFile f = new RandomAccessFile(NOME_FILE, "rw")) {

            SchedaAnimale modificato = gestioneAnimali.modificaAnnoMorte(f, matricola);

            if (modificato != null) {
                System.out.println("Scheda aggiornata:");
                System.out.println(modificato);
            } else {
                System.out.println("Scheda non trovata.");
            }
        }
    }
}