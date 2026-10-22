/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/


import java.io.IOException;
import java.io.RandomAccessFile;

class Pizza {
	
	private String nome;
	private float price;
	private int quantita;
	private boolean wait; // Indica se l'ordine va composto il prima possibile oppure aspettare la coincidenza
	private Data consegna;
	
	private static final int MAX_DIM = 20;
	private static final int PIZZA_DIM = (MAX_DIM) + 4 + 4 + 1 + Data.getByteDIM();

	// contenitore vuoto di pizza
	public Pizza () {
		nome = "0";
		quantita = 0;
		price = 0f;
		wait = false; // la pizza va preparata al momento se possibile
		consegna = new Data(); // data equivale a null quando la pizza non ha un orario specifico, non e stata ordinata
	}

	public Pizza (String nome, float price, int quantita, boolean wait, Data consegna){
		this.nome = nome;
		this.quantita = quantita;
		this.price = price;
		this.wait = wait;
		this.consegna = consegna;
	}

	public String getNome(){
		return nome;
	}

	public boolean getWait(){
		return wait;
	}

	public Data getData(){
		return consegna;
	}
	
	public static int getByteDIM(){
		return PIZZA_DIM;
	}
	
	public float getPrice(){
		return price;
	}
	
	public int getQuantita(){
		return quantita;
	}

	void scrivi(RandomAccessFile f) throws IOException {
		Pizzeria.scriviStringa(f, nome, MAX_DIM);
		f.writeFloat(price);
		f.writeInt(quantita);
		f.writeBoolean(wait);
		Data.salva(f, consegna);
	}

	static Pizza leggi(RandomAccessFile f) throws IOException {
		String nome = Pizzeria.leggiStringa(f, MAX_DIM);
		float price = f.readFloat();
		int quantita = f.readInt();
		boolean wait = f.readBoolean();
		Data consegna = Data.leggi(f);
		return new Pizza(nome, price, quantita, wait, consegna);
	}
}