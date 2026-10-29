/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 22/10/2026
	Luogo: Lab 53bis
	Descrizione: Verifica Pratica
*/

import java.io.*;
import java.util.*;

class LibreariaMain{
	public static void main(String[] argvs){

		Libreria libreria = new Libreria();

		libreria.aggiungiLibro(new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "fantasy",1946,true,0));
		libreria.aggiungiLibro(new Libro("Harry Potter e la Pietra Filosofale", "J.K. Rowling", "fantasy",1997,true,0));
		libreria.aggiungiLibro(new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "fantasy",1946,true,0));

		libreria.visualizzaLibreria();
	}
}