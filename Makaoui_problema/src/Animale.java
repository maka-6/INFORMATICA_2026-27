/*
* Autore: Makaoui Youness
* Classe: 5G
* Data: 29/10/2026
* Versione: 1.0
* Descrizione: Classe animale con metodi per lettura e scrittura in un File binario
*/


import java.io.*;

class Animale {
	
	private int matricola;
	private String nome;
	private String razza;
	private int annoNascita;
	private int annoMorte;
	
	public static final int MAX_DIM = 20;
	private static final int ANIMALE_DIM = (MAX_DIM*2) + (4*3);
	
	Animale(int matricola, String nome, String razza, int annoNascita, int annoMorte){
		this.matricola = matricola;
		this.razza = razza;
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.annoMorte = annoMorte;
	}
	
	public int getMatricola(){
		return matricola;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getRazza(){
		return razza;
	}
	
	public int getAnnoNascita(){
		return annoNascita;
	}
	
	public int getAnnoMorte(){
		return annoMorte;
	}
	
	public static int getByteDIM(){
		return ANIMALE_DIM;
	}
	
	static void scrivi(RandomAccessFile archivio, Animale a) throws IOException{
		archivio.writeInt(a.matricola);
		Veterinario.scriviStringa(archivio, a.nome, MAX_DIM);
		Veterinario.scriviStringa(archivio, a.razza, MAX_DIM);
		archivio.writeInt(a.annoNascita);
		archivio.writeInt(a.annoMorte);
	}
	
	static Animale leggi(RandomAccessFile archivio) throws IOException{
		int matricola = archivio.readInt();
		String nome = Veterinario.leggiStringa(archivio, MAX_DIM);
		String razza = Veterinario.leggiStringa(archivio, MAX_DIM);
		int annoNascita = archivio.readInt();
		int annoMorte = archivio.readInt();
		return new Animale(matricola, nome, razza, annoNascita, annoMorte);
	}
	
	@Override
	public String toString(){
		return matricola + " " + nome + " " + razza + " " + " nato il: " + annoNascita + (annoMorte == 0 ? " Ancora in vita per ora" : " Deceduto il: " + annoMorte);
	}
}