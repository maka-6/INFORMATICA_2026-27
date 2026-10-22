/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/

import java.io.IOException;
import java.io.RandomAccessFile;

class Ordine {
	
	private Pizza[] pizzeOrd = new Pizza[5]; // la pizzeria ha solo 5 tipi di pizze ordinabili, ogni slot ha la sua pizza predefinita
	private boolean pronto;
	private Cliente cliente; // DIM CLIENTE 52
	private int numOrdine = 1;
	private float total;
	private boolean consegnato;

	private static final int DIM_ORDINE = (Pizza.getByteDIM() * 5) + 1 + Cliente.getByteDIM() + 4 + 4 + 1; // Unica Dimensione non statica
	
	public Ordine () {
		pizzeOrd[0] = new Pizza();
		total = pizzeOrd[0].getPrice();
		// popolo array di pizze vuote
		for(int i = 1; i < 5; i++){
			pizzeOrd[i] = new Pizza();
		}
		pronto = true;
		cliente = new Cliente();
		consegnato = false;
		pronto = false;
		total = calcolaTotale();
	}
	
	public Ordine(Pizza[] pizzeOrd, boolean pronto, float total, Cliente cliente, int numOrdine, boolean consegnato){
		this.pizzeOrd = pizzeOrd;
		for (int i = 0; i < 5; i++)
			if (this.pizzeOrd[i] == null)
				this.pizzeOrd[i] = new Pizza("", 0f, 0, false, new Data());   // pizza "vuota": quantita 0
		this.pronto = pronto;
		this.total = total;
		this.numOrdine = numOrdine;
		this.cliente = cliente;
		this.consegnato = consegnato;
	}
	
	public int getNumOrdine(){
		return numOrdine;
	}
	
	public void ordineCompletato( ) {
		pronto = true;
	}
	
	public float calcolaTotale(){
		float total = 0f;
		for(int i = 0; i < 5; i++){
			if ( pizzeOrd[i] != null ) {
				total += pizzeOrd[i].getPrice() * pizzeOrd[i].getQuantita();
			}
		}

		return total;
	}
	
	public void ordineConsegnato() {
		consegnato = true;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public static int getByteDIM(){
		return DIM_ORDINE;
	}

	void scriviRecord(RandomAccessFile f) throws IOException {
		for (int i = 0; i < 5; i++) {

			pizzeOrd[i].scrivi(f);

		}
		f.writeBoolean(pronto);
		cliente.scrivi(f);
		f.writeInt(numOrdine);
		f.writeFloat(total);
		f.writeBoolean(consegnato);
	}

	static Ordine leggiRecord(RandomAccessFile f) throws IOException {
		Pizza[] p = new Pizza[5];
		for (int i = 0; i < 5; i++) {
			p[i] = Pizza.leggi(f);
		}
		boolean pronto = f.readBoolean();
		Cliente c = Cliente.leggi(f);
		int num = f.readInt();
		float tot = f.readFloat();
		boolean cons = f.readBoolean();
		return new Ordine(p, pronto, tot, c, num, cons);
	}
	
	@Override
	public String toString(){
		return cliente.toString() + " Ordine numero: " + numOrdine;
	}
}