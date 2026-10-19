/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/

class Ordine {
	
	private Pizza[] pizzeOrd = new Pizza[5]; // la pizzeria ha solo 5 tipi di pizze ordinabili, ogni slot ha la sua pizza predefinita
	private boolean pronto;
	private Cliente cliente; // DIM CLIENTE 52
	private int numOrdine = 1;
	private float total;
	private boolean consegnato;
	
	private static final int MAX_NOME = 20;
	private static final int DIM_ORDINE = (Pizza.getByteDIM() * 5) + 1 + Cliente.getByteDIM() + 4 + 8 + 1;
	
	public Ordine () {
		pizzeOrd[0] = new Pizza();
		total = pizzeOrd[0].getPrice();
		pronto = true;
		cliente = new Cliente();
		consegnato = false;
	}
	
	public Ordine(Pizza[] pizzeOrd, boolean pronto, float total, Cliente cliente, int numOrdine, boolean consegnato){
		this.pizzeOrd = pizzeOrd;
		this.pronto = pronto;
		this.total = total;
		this.numOrdine = numOrdine;
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
	
	public int getByteDIM(){
		return DIM_ORDINE;
	}
	
	@Override
	public String toString(){
		return cliente.toString() + " Ordine numero: " + numOrdine;
	}
}