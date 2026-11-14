/*
* Autore: Makaoui Youness
* Classe: 5G
* Data: 29/10/2026
* Versione: 1.0
* Descrizione: Classe IndexHash
*/

import java.io.*;
import java.util.*;

class IndexHash {
    
    private TreeMap<String, Integer> index;
    
    IndexHash(){
		index = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	}
    
    public void add(String nome, Integer matr){
		index.put(nome,matr);
	}
	
	public Integer getMatr(String nome){
		return index.get(nome);
	}
    
    public Integer getNome(Integer matr){
		return index.get(matr);
	}
}