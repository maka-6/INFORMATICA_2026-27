/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/

class Cliente{
	
	private String nome;
	private boolean ritiraDopo; // flag che indica se il cliente ritira il suo ordine subito o prenota per un orario preciso
	private Data ritiro;
	private int numOrdine;
	
	private static final int MAX_DIM = 20;
	private static int CLIENTE_DIM = MAX_DIM + Data.getByteDIM() + 4 + 1;
	
	public Cliente (){
		nome = "mario";
		ritiro = null;
		numOrdine = 1;
		ritiraDopo = false;
	}

	public Cliente (String nome, Data ritiro, boolean ritiraDopo, int numOrdine){
		this.nome = nome;
		this.ritiro = ritiro;
		this.ritiraDopo = ritiraDopo;
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
	
	@Override
	public String toString(){
		return "Cliente: " + nome + " Ritira" + (ritiraDopo ? " subito" : " alle ore: " + ritiro.toString());
	}
}