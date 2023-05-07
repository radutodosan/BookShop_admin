package Utilizator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runners.JUnit4;

class MainTest{

	@Test
	void testMain() {
		
		Carte c1 = new Carte(1, "Maitrey", "Mircea Eliade", 5, 20);
		Carte c2 = new Carte(2, "Fema Animalelor", "George Orwell", 3, 25);
		Carte c3 = new Carte(3, "Amintiri din copilarie", "Ion creanga", 40, 15);
		Carte c4 = new Carte(4, "Ion", "Liviu Rebreanu", 15, 20);
		
		List<Carte> carti = new ArrayList<>();
		carti.add(c1);
		carti.add(c2);
		carti.add(c3);
		carti.add(c4);
		
		Main test = new Main();
		String result = test.afisare(carti);
		assertEquals("Amintiri din copilarie", result);
	}

}
