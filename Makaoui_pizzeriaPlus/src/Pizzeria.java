/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/
import java.io.*;

class Pizzeria {
	
	private String nome;
	private Ordine[] ordini = new Ordine[30]; // per colpa del basso budget della pizzeria massimo 30 ordini
	private Data orario;
	
	public Pizzeria(){
		nome = "Sopranos's Pizza";
		Ordine tempOrd = new Ordine();
		orario = new Data(11, 0);
	}
	
	public Pizzeria(String nome, Ordine[] ordini, Data orario){
		this.nome = nome;
		this.ordini = ordini;
		this.orario = orario;
	}
	
	
	public void salvaOrdine(String fileName, Ordine ordine){
		try{
			RandomAccessFile f = new RandomAccessFile(fileName, "rw");
			Cliente clienteTemp = ordine.getCliente();
			
			/*
			for (int i = 0; i < 5; i++) {
				Pizza p;
				
				if (p != null) {
					f.writeBoolean(true);
					// Scrivi tutti i campi della pizza
					// nome, prezzo, quantita, wait, consegna...
				} else {
					f.writeBoolean(false);
					
					// Riserva lo spazio restante dello slot
					// scrivendo valori predefiniti.
				}
			}*/
			
			// creare l'item
			// indice ArrayList
			// aggiungere item a indice
			
		} catch (IOException e){
			System.out.println("Errore");
		}
	}
}