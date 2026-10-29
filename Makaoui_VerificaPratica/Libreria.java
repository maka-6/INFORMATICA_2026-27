/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 22/10/2026
	Luogo: Lab 53bis
	Descrizione: Verifica Pratica
*/

import java.util.*;
import java.io.*;

class Libreria {
	
	private ArrayList<Libro> libreria;
	private RandomAccessFile archivio;
	private IndexTable table;
	
	
	Libreria(){
		table = new IndexTable();
		libreria = new ArrayList<Libro>();
		try{
	
			archivio = new RandomAccessFile("Libreria.bin","rw");
			caricaLibreria();
		} catch (IOException e) {
			System.out.println("Errore");
		}
	}
	
	public static void scriviStringa( RandomAccessFile archivio, String s, int len ) throws IOException {
		StringBuilder sb = new StringBuilder(s);
		sb.setLength(len);
		archivio.writeBytes(sb.toString());
	}
	
	public static String leggiStringa(RandomAccessFile archivio, int dim) throws IOException {
		byte[] b = new byte[dim];
		archivio.readFully(b);
		return new String(b).trim();
	}
	
	public void visualizzaLibreria(){
		
		for(int i = 0; i < libreria.size(); i++){
			System.out.println(libreria.get(i).toString());
		}
	}
	
	public void aggiungiLibro(Libro libro){
		libro.setId(libreria.size()+1); // imposto l'id
		scriviRecord(libro);
		libreria.add(libro);
	}
	
	public void scriviRecord(Libro libro){
		try{
			int pos = (int) archivio.length() / Libro.getLibroDIM();
			archivio.seek((long) pos * libro.getLibroDIM());
			libro.scrivi(archivio);
			table.aggiungiItem( new Item( libro.getId(), pos ));
		} catch (IOException e) {
			System.out.println("Errore");
		}
	}
	
	public void caricaLibreria() throws IOException {
		int n = (int) archivio.length() / Libro.getLibroDIM();
		for( int i = 0; i < n; i++){
			archivio.seek((long) i * Libro.getLibroDIM());
			String titolo = leggiStringa(archivio, Libro.MAX_DIM);
			String autore = leggiStringa(archivio, Libro.MAX_DIM);
			String genere = leggiStringa(archivio, Libro.MAX_DIM);
			int pubblicazione = archivio.readInt();
			boolean disponibile = archivio.readBoolean();
			int id = archivio.readInt();
			
			Libro libro = new Libro( titolo, autore, genere, pubblicazione, disponibile, id);
			libreria.add(libro);
			table.aggiungiItem(new Item(id, i));
		}
	}
}