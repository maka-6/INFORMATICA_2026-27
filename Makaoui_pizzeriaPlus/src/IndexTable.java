/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 22/10/2026
	Oggetto:
*/

import java.util.ArrayList;
import java.util.Collections;

class IndexTable {
    private ArrayList<Item> indice = new ArrayList<>();
    private ComparaNome comp = new ComparaNome();

    void aggiungi(String key, int pos) {
        indice.add(new Item(key, pos));
        Collections.sort(indice, comp);
    }

    int cerca(String key) {                          // posizione nel file, -1 se assente
        int i = Collections.binarySearch(indice, new Item(key, 0), comp);
        return i >= 0 ? indice.get(i).getPosizione() : -1;
    }
}