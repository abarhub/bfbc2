package org.bfbc2;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 20 juin 2010
 * Time: 15:05:04
 * To change this template use File | Settings | File Templates.
 */
public class Insigne {

	private int nombre;
	private int valeur_min;
	private int valeur;
	private String label;
	private String nom;
	private String image;

	public Insigne() {
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
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
}
