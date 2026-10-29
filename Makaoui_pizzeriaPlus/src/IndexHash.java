/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 26/10/2026
	Oggetto:
*/


import java.util.HashMap;

class IndexHash {
	private HashMap<String, Integer> index;
	
	IndexHash(){
		index = new HashMap<>();
	}
	
	public void add(String key, Integer pos){
		index.put(key,pos);
	}
	
	
	public Integer getKey(String key){
		return index.get(key);
	}
}