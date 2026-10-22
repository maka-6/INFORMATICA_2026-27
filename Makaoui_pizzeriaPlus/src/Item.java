/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/

class Item {
	private String key;
	private int posizione;
	
	Item(String s, int pos){
		key = s;
		posizione = pos;
	}

	public String getKey(){
		return key;
	}

	public int getPosizione(){
		return posizione;
	}

}