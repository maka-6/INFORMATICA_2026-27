/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/


import java.util.Comparator;

class ComparaNome implements Comparator<Item> {

    @Override
    public int compare(Item a, Item b) {
        return a.getKey().compareToIgnoreCase(b.getKey());
    }
}