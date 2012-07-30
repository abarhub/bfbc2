package org.bfbc2;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 20 juin 2010
 * Time: 14:48:23
 * To change this template use File | Settings | File Templates.
 */
public class Specialisation {

	private int unlock;
	private int valeur_min;
	private int valeur;
	private String label;
	private String nom;
	private String image;
	private String kits;

	public Specialisation() {
	}

	public int getUnlock() {
		return unlock;
	}

	public void setUnlock(int unlock) {
		this.unlock = unlock;
	}

	public int getValeur_min() {
		return valeur_min;
	}

	public void setValeur_min(int valeur_min) {
		this.valeur_min = valeur_min;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getKits() {
		return kits;
	}

	public void setKits(String kits) {
		this.kits = kits;
	}
}
