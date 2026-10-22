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
	private RandomAccessFile archivio; // aperto una volta sola
	private IndexTable indice = new IndexTable();

	public Pizzeria(){
		nome = "Sopranos's Pizza";
		Ordine tempOrd = new Ordine();
		orario = new Data(11, 0);
		ordini[0] = tempOrd;
		try {
			archivio = new RandomAccessFile("ordini.bin", "rw");
		} catch (IOException e) {
			System.out.println("Errore");
		}
		ricostruisciIndice();
	}
	
	public Pizzeria(String nome, Ordine[] ordini, Data orario, RandomAccessFile archivio){
		this.nome = nome;
		this.ordini = ordini;
		this.orario = orario;
		this.archivio = archivio;
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

	public void salvaOrdine(Ordine o) throws IOException {
		try {
			int pos = (int) (archivio.length() / Ordine.getByteDIM());   // prossimo record libero
			archivio.seek((long) pos * Ordine.getByteDIM());
			o.scriviRecord(archivio);
			indice.aggiungi(o.getCliente().getNome(), pos);
		} catch (IOException e) {
			System.out.println("Errore di scrittura");
		}
		System.out.println(archivio.length());
	}

	public Ordine cercaOrdine(String nome) {
		int pos = indice.cerca(nome);
		if (pos == -1) return null;
		try {
			archivio.seek((long) pos * Ordine.getByteDIM());
			return Ordine.leggiRecord(archivio);
		} catch (IOException e) {
			System.out.println("Errore di lettura");
			return null;
		}
	}

	private void ricostruisciIndice() {
		try {
			int n = (int) (archivio.length() / Ordine.getByteDIM());
			for (int i = 0; i < n; i++) {
				archivio.seek((long) i * Ordine.getByteDIM());
				Ordine o = Ordine.leggiRecord(archivio);
				indice.aggiungi(o.getCliente().getNome(), i);
			}
		} catch (IOException e) {
			System.out.println("Errore di lettura");
		}
	}

	public void chiudi() {
		try { archivio.close(); } catch (IOException e) { }
	}
}