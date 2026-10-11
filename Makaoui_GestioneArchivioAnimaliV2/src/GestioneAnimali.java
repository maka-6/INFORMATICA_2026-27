/*
Autore: Makaoui Youness
Classe: 5G
Data: 4/10/2026
Oggetto:
*/

import java.io.*;
class GestioneAnimali {

	SchedaAnimale[] dbAnimali = new SchedaAnimale[256];
	int nAnimali;
	IndexTable indice = new IndexTable();
	static final int max_record = (2 * 50) * 3 + 4 + 4;
	static final int max_stringa = 50;

	GestioneAnimali() {
		nAnimali=0;
	}

	void aggiungiScheda(SchedaAnimale sa){
		this.dbAnimali[nAnimali]= sa;
		nAnimali++;
	}

	void creaIndice() {

		indice.svuota();

		for (int i = 0; i < nAnimali; i++) {
			indice.add(dbAnimali[i].matricola, i);
		}

		indice.ordina();
	}

	SchedaAnimale leggiScheda(RandomAccessFile f) throws IOException{

		String m = readString(f);
		String n = readString(f);
		String r = readString(f);
		int an = f.readInt();
		int am = f.readInt();

		SchedaAnimale sa = new SchedaAnimale(m, n, r, an, am);
		return sa;
	}

	void scriviScheda(RandomAccessFile f, SchedaAnimale sa) throws IOException{
		writeString(sa.matricola, f);
		writeString(sa.nome, f);
		writeString(sa.razza, f);
		f.writeInt(sa.anno_nascita);
		f.writeInt(sa.anno_morte);
	}

	SchedaAnimale modificaAnnoMorte(RandomAccessFile f, String matricola) {

		try {
			SchedaAnimale tempSA = ricercaPerIndice(f, matricola);

			if (tempSA == null) {
				System.out.println("Animale non trovato.");
				return null;
			}

			System.out.println(tempSA);

			BufferedReader key = new BufferedReader(
					new InputStreamReader(System.in)
			);

			System.out.print("Modifica anno di morte: ");
			int annoMorte = Integer.parseInt(key.readLine());

			SchedaAnimale schedaAnimale = new SchedaAnimale(
					tempSA.matricola,
					tempSA.nome,
					tempSA.razza,
					tempSA.anno_nascita,
					annoMorte
			);

			int posizione = indice.cerca(matricola);

			f.seek((long) posizione * max_record);
			scriviScheda(f, schedaAnimale);

			return schedaAnimale;

		} catch (Exception e) {
			System.out.println("Errore durante la modifica dell'anno di morte.");
			return null;
		}
	}

	SchedaAnimale ricercaScheda(RandomAccessFile f, int numero_cercato)throws IOException{
		numero_cercato--;
		numero_cercato= numero_cercato * max_record;
		f.seek(numero_cercato);
		return leggiScheda(f);
	}

	    

	void writeString(String s, RandomAccessFile f) throws IOException {
		int l = s.length();
		if(l>max_stringa){
		    f.writeChars(s.substring(0,max_stringa));
		}
		else{
		    f.writeChars(s);
		
		    for (int i = l; i < max_stringa; i++) {
				f.writeChar('\0');
		    }
		}
		
	}

	String readString(RandomAccessFile f) throws IOException {
		String s = "";
		for (int i = 0; i < max_stringa; i++) {
		    char c = f.readChar();
		    if (c != '\0') {
				s += c;
		    }
		}

		return s;
	}

	void scriviTutto() {
		try (RandomAccessFile f = new RandomAccessFile("animali.txt", "rw")) {

			f.setLength(0);

			for (int i = 0; i < nAnimali; i++) {
				scriviScheda(f, dbAnimali[i]);
			}

		} catch (IOException e) {
			System.out.println("Errore nella scrittura del file.");
		}
	}

	void leggiTutto() {
		try {
		    RandomAccessFile f = new RandomAccessFile("animali.txt", "r");

		    nAnimali = 0;

		    while (true) {
				try {

					SchedaAnimale sa1 = leggiScheda(f);

					if (nAnimali >= dbAnimali.length) {
						System.out.println("Archivio pieno: limite massimo raggiunto.");
						break;
					}

					dbAnimali[nAnimali] = sa1;
					nAnimali++;

				} catch (EOFException e) {
					break;
				}
		    }

		    f.close();

		} catch (IOException e) {
		    System.out.println("Errore nella lettura del file");
		}
	}

	SchedaAnimale ricercaPerIndice(RandomAccessFile f, String matricola) throws IOException {

		leggiTutto();
		creaIndice();

		int posizione = indice.cerca(matricola);

		if (posizione == -1) {
			return null;
		}

		f.seek((long) posizione * max_record);

		return leggiScheda(f);
	}

	@Override
	public String toString() {
		String s = "";

		for (int i = 0; i < nAnimali; i++) {
			s += dbAnimali[i].toString() + "\n";
		}

		return s;
    }
}