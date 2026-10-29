/*
* Autore: Makaoui Youness
* Classe: 5G
* Data: 29/10/2026
* Versione: 1.0
* Descrizione: Classe Veterinario
*/


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

class Veterinario{
	private ArrayList<Animale> animali;
    private IndexHash indice;
	private RandomAccessFile archivio;
	
	Veterinario(){
		try{
			animali = new ArrayList<Animale>();
			archivio = new RandomAccessFile("animali.bin","rw");
            indice = new IndexHash();
			ricaricaArchivio();
		} catch (IOException e){
			System.out.println("Errore apertura file");
		}
	}

	private void ricaricaArchivio() {
		try {
            int n = (int) (archivio.length() / Animale.getByteDIM());
			for(int i = 0; i < n; i++) {
				Animale a = Animale.leggi(archivio);
				animali.add(a);
				indice.add(a.getNome(), a.getMatricola());
			}
        } catch (IOException e) {
            System.out.println("Errore di lettura");
        }
	}

	static void scriviStringa(RandomAccessFile f, String s, int len) throws IOException {
		StringBuilder sb = new StringBuilder(s);
		sb.setLength(len);              // tronca se lunga, riempie con '\0' se corta
		f.writeBytes(sb.toString());    // 1 byte per carattere -> esattamente len byte
	}

	static String leggiStringa(RandomAccessFile f, int len) throws IOException {
		byte[] b = new byte[len];
		f.readFully(b);
		return new String(b).trim();    // trim toglie anche i '\0' di riempimento
	}
    
    public void salvaAnimale(Animale a) throws IOException {
		try {
			int pos = (int) (archivio.length() / Animale.getByteDIM());   // prossimo record libero
			archivio.seek((long) pos * Animale.getByteDIM());
			Animale.scrivi(archivio, a);
			indice.add(a.getNome(), a.getMatricola());
			
		} catch (IOException e) {
			System.out.println("Errore di scrittura");
		}
		System.out.println(archivio.length());
	}

	public void cercaNome(int matricola) {
		indice.getNome(matricola);
	}

	public void cercaMatricola(String nome) {
		indice.getMatr(nome);
	}
}