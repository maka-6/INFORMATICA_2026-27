/*
Autore: Makaoui Youness
Classe: 5G
Data: 2/10/2026
Oggetto:
*/

import java.util.ArrayList;
import java.util.Collections;

class IndexTable {
	private ArrayList<ItemCompare> table = new ArrayList<>();

    
	public void add(String key, int pos) {
		table.add(new ItemCompare(key, pos));
	}

   
	public void ordina() {
		Collections.sort(table);
	}

	public int cerca(String key) {

		for (ItemCompare item : table) {

			if (item.getKey().equals(key)) {
				return item.getPos();
			}
		}

		return -1;
	}

    
	public void svuota() {
		table.clear();
	}

	@Override
	public String toString() {
		String s = "--- Tabella Indice ---\n";
		for (ItemCompare item : table) {
			s += item.toString() + "\n";
		}
		return s;
	}
}