/*
 * Nome: Makaoui Youness
 * Classe: 5G
 * Data: 20/09/2026
 * Descrizione: Programma per la gestione degli appuntamenti
*/

import java.util.ArrayList;

public class GestioneAppuntamenti {

    private ArrayList<Appuntamento> appuntamenti;

    // Costruttore
    public GestioneAppuntamenti() {
        appuntamenti = new ArrayList<>();
    }

    // Inserisce un nuovo appuntamento
    public void inserisciAppuntamento(Appuntamento appuntamento) {
        appuntamenti.add(appuntamento);
        System.out.println("Appuntamento inserito!");
    }

    // Visualizza tutti gli appuntamenti
    public void visualizzaAppuntamenti() {

        if (appuntamenti.isEmpty()) {
            System.out.println("Non ci sono appuntamenti.");
            return;
        }

        System.out.println("\n--- TUTTI GLI APPUNTAMENTI ---");

        for (Appuntamento a : appuntamenti) {
            a.visualizza();
        }
    }

    // Cerca gli appuntamenti di una determinata data
    public void cercaPerData(String data) {

        boolean trovato = false;

        System.out.println("\n--- APPUNTAMENTI DEL " + data + " ---");

        for (Appuntamento a : appuntamenti) {

            if (a.getData().equals(data)) {
                a.visualizza();
                trovato = true;
            }
        }

        if (!trovato) {
            System.out.println("Nessun appuntamento trovato per questa data.");
        }
    }
}