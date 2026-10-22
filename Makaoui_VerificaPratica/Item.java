/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 22/10/2026
	Luogo: Lab 53bis
	Descrizione: Verifica Pratica
*/

class Item implements Comparable<Item> {
	
	private int key; // codice univoco per libro
	private int pos;
	
	Item(int key, int pos) {
		this.key = key;
		this.pos = pos;
	}
	
	@Override
	public int compareTo(Item item2){
		return Integer.compare(key, item2.key);
	}

	@Override
	public String toString(){
		return "Key: " + key + ", Pos: " + pos;
	}
}