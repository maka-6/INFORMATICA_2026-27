/*
Autore: Makaoui Youness
Classe: 5G
Data: 8/10/2026
Oggetto:
*/

class ItemCompare implements Comparable<ItemCompare> {
	
	private String key;
	private int pos;
	
	ItemCompare ( String key, int pos ) {
		this.key = key;
		this.pos = pos;
	}

	public String getKey() {
		return key;
	}

	public int getPos() {
		return pos;
	}
	
	@Override
	public int compareTo(ItemCompare i) {
		return key.compareTo(i.key);
	}

	
	@Override
	public String toString() {
		return key + " " + pos;
	}
}