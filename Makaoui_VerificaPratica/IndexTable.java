/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 22/10/2026
	Luogo: Lab 53bis
	Descrizione: Verifica Pratica
*/

import java.util.*;


class IndexTable{
	private ArrayList<Item> table;
	
	
	public IndexTable(){
		table = new ArrayList<Item>();
		
	}
	
	public void aggiungiItem( Item item ){
		table.add(item);
		Collections.sort(table);
	}
	
	public void rimuoviItem( Item item ){
		table.remove(item);
		Collections.sort(table);
	}
}