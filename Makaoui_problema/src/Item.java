/*
* Autore: Makaoui Youness
* Classe: 5G
* Data: 29/10/2026
* Versione: 1.0
* Descrizione: Classe Item
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
    