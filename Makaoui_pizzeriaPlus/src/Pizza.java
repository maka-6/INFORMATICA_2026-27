/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/


class Pizza {
	
	private String nome;
	private float price;
	private int quantita;
	private boolean wait; // Indica se l'ordine va composto il prima possibile oppure aspettare la coincidenza
	private Data consegna;
	
	private static final int MAX_DIM = 20;
	private static final int PIZZA_DIM = MAX_DIM + 8 + 4 + 1 + Data.getByteDIM();
	
	public Pizza () {
		nome = "Margherita";
		quantita = 1;
		price = 5.99f;
		wait = false; // la pizza va preparata al momento se possibile
		consegna = null; // data equivale a null quando la pizza non ha un orario specifico
	}
	
	public Pizza (String nome, float price, int quantita, boolean wait, Data consegna) {
		this.nome = nome;
		this.quantita = quantita;
		this.price = price;
		this.wait = wait; 
		this.consegna = consegna; 
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
}