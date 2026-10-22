/*
	Autore: Makaoui Youness
	Classe: 5G
	Data: 19/10/2026
	Oggetto:
*/

import java.io.*;

class PizzaMain{

	public static void main(String args[]) throws IOException {
		new File("ordini.bin").delete();

		Pizzeria p = new Pizzeria();

		Pizza[] p1 = new Pizza[5];
		p1[0] = new Pizza();
		Ordine o1 = new Ordine(p1, false, 5.99f, new Cliente("Mario", new Data(10, 5), 1), 1, false);

		Pizza[] p2 = new Pizza[5];
		p2[0] = new Pizza("Margherita", 5.99f, 2, false, new Data());
		p2[2] = new Pizza("Diavola", 7.50f, 1, true, new Data(20, 30));
		Ordine o2 = new Ordine(p2, false, 0f, new Cliente("Luigi", 2), 2, false);

		Pizza[] p3 = new Pizza[5];
		p3[4] = new Pizza("Capricciosa", 8.00f, 1, false, new Data());
		Ordine o3 = new Ordine(p3, false, 8.00f, new Cliente("Anna", 3), 3, false);

		p.salvaOrdine(o1);
		p.salvaOrdine(o2);
		p.salvaOrdine(o3);
		p.chiudi();

		// nuova Pizzeria: l'indice viene ricostruito dal file
		Pizzeria q = new Pizzeria();
		System.out.println(q.cercaOrdine("Mario"));
		System.out.println(q.cercaOrdine("luigi"));
		System.out.println(q.cercaOrdine("Anna"));
		System.out.println(q.cercaOrdine("Giulia"));
		q.chiudi();
	}
}