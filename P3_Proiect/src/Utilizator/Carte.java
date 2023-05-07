package Utilizator;

public class Carte {

	int carteID;
	String numeCarte, autor;
	int pret;
	int stoc;
	
	public Carte(int carteID, String numeCarte, String autor, int stoc, int pret) {
		this.carteID = carteID;
		this.numeCarte = numeCarte;
		this.autor = autor;
		this.stoc = stoc;
		this.pret = pret;
		
	}

	@Override
	public String toString() {
		return "Carte [carteID=" + carteID + ", numeCarte=" + numeCarte + ", autor=" + autor + ", pret=" + pret
				+ ", stoc=" + stoc + "]";
	}
	
	public int getCarteID() {
		return carteID;
	}

	public void setCarteID(int carteID) {
		this.carteID = carteID;
	}

	public String getNumeCarte() {
		return numeCarte;
	}

	public void setNumeCarte(String numeCarte) {
		this.numeCarte = numeCarte;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public int getStoc() {
		return stoc;
	}

	public void setStoc(int stoc) {
		this.stoc = stoc;
	}
	
	
}
