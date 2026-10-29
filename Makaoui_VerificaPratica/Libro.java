/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 22/10/2026
	Luogo: Lab 53bis
	Descrizione: Verifica Pratica
*/


import java.util.*;
import java.io.*;

public class Libro {
	private String titolo;
	private String autore;
	private String genere;
	private int pubblicazione; // anno di pubblicazione
	private boolean disponibile;
	private int id;
	
	public static final int MAX_DIM = 30;
	private static final int DIM_LIBRO = ( MAX_DIM * 3 ) + 4 + 1 + 4;
	
	Libro(String titolo, String autore, String genere, int pubblicazione, boolean disponibile, int id){
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.pubblicazione = pubblicazione;
		this.disponibile = disponibile;
		this.id = id;
	}
	
	
	public static int getLibroDIM(){
		return DIM_LIBRO;
	}
	
	public String getTitolo(){
		return titolo;
	}
	
	public String getAutore(){
		return autore;
	}
	
	public String getGenere(){
		return genere;
	}
	
	public int getPubblicazione(){
		return pubblicazione;
	}
	
	public boolean disponibile(){
		return disponibile;
	}
	
	public int getId(){
		return id;
	}
	
	public void setTitolo( String titolo ){
		this.titolo = titolo;
	}
	
	public void setAutore( String autore ){
		this.autore = autore;
	}
	
	public void setGenere( String genere ){
		this.genere = genere;
	}
	
	public void setPubblicazione( int pubblicazione ){
		this.pubblicazione = pubblicazione;
	}
	
	public void setDisponibile( boolean disponibile ){
		this.disponibile = disponibile;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public void scrivi(RandomAccessFile archivio) throws IOException {
		Libreria.scriviStringa(archivio, titolo, MAX_DIM);
		Libreria.scriviStringa(archivio, autore, MAX_DIM);
		Libreria.scriviStringa(archivio, genere, MAX_DIM);
		archivio.writeInt(pubblicazione);
		archivio.writeBoolean(disponibile);
		archivio.writeInt(id);
	}
	
	@Override
	public String toString(){
		return "Libro: " + titolo + " scritto da: " + autore + " del genere " + genere + " pubblicato il: " + pubblicazione;
	}
}