/*
 * Nome: Makaoui Youness
 * Classe: 5G
 * Data: 20/09/2026
 * Descrizione: Programma per la gestione degli appuntamenti
*/

public class Appuntamento {

    private String data;
    private String ora;
    private String descrizione;

    // Costruttore
    public Appuntamento(String data, String ora, String descrizione) {
        this.data = data;
        this.ora = ora;
        this.descrizione = descrizione;
    }

    // Metodi getter
    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }

    public String getDescrizione() {
        return descrizione;
    }

    // Metodo per visualizzare l'appuntamento
    public void visualizza() {
        System.out.println("Data: " + data);
        System.out.println("Ora: " + ora);
        System.out.println("Descrizione: " + descrizione);
        System.out.println("-------------------------");
    }
}
