/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/

import java.io.IOException;
import java.io.RandomAccessFile;

class Cliente{
	
	private String nome;
	private Data ritiro; // se la data equivale a (-1;-1) il cliente ritira subito
	private int numOrdine;
	
	private static final int MAX_DIM = 20;
	private static int CLIENTE_DIM = (MAX_DIM) + Data.getByteDIM() + 4;
	
	public Cliente (){
		nome = "mario";
		ritiro = new Data();
		numOrdine = 1;
	}

	public Cliente (String nome, Data ritiro, int numOrdine){
		this.nome = nome;
		this.ritiro = ritiro;
		this.numOrdine = numOrdine;
	}

	public Cliente (String nome, int numOrdine){
		this.nome = nome;
		this.ritiro = new Data();
		this.numOrdine = numOrdine;
	}

	public String getNome(){
		return nome;
	}

	public int getOrdine(){
		return numOrdine;
	}
	
	public Data getDataRitiro(){
		return ritiro;
	}
	
	public static int getByteDIM(){
		return CLIENTE_DIM;
	}

	public void scrivi(RandomAccessFile archivio) throws IOException {
		Pizzeria.scriviStringa(archivio, nome, MAX_DIM);
		Data.salva(archivio, ritiro);
		archivio.writeInt(numOrdine);
	}

	public static Cliente leggi(RandomAccessFile archivio) throws IOException{
		String nome = Pizzeria.leggiStringa(archivio, MAX_DIM);
		Data ritiro = Data.leggi(archivio);
		int numOrdine = archivio.readInt();
		return new Cliente(nome, ritiro, numOrdine);
	}
	
	@Override
	public String toString(){
		return "Cliente: " + nome + " Ritira" + (ritiro.getHour() == -1 ? " subito" : " alle ore: " + ritiro.toString());
	}
}