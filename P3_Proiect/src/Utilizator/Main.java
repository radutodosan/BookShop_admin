package Utilizator;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static String afisare(List<Carte> c) {
		String x = c.get(2).getNumeCarte();
		
		return x;
	}
	
	public static int lungime(List<Carte> c) {
		int l = c.size();
		
		return l;
	}
	
	public static void main(String[] args) {
		Carte c1 = new Carte(1, "Maitrey", "Mircea Eliade", 5, 20);
		Carte c2 = new Carte(2, "Fema Animalelor", "George Orwell", 3, 25);
		Carte c3 = new Carte(3, "Amintiri din copilarie", "Ion creanga", 40, 15);
		Carte c4 = new Carte(4, "Ion", "Liviu Rebreanu", 15, 20);
		
		List<Carte> carti = new ArrayList<>();
		carti.add(c1);
		carti.add(c2);
		carti.add(c3);
		carti.add(c4);
		
		System.out.println("Afisare lista carti:");
		for(Carte c : carti)
			System.out.println(c);
		
		String result = afisare(carti);
		System.out.println("\nTitlul cartii nr. 3 este: \n" + result);
	}
}
