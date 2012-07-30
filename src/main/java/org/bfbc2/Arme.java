package org.bfbc2;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 20 juin 2010
 * Time: 10:53:56
 * To change this template use File | Settings | File Templates.
 */
public class Arme {

	private int nb_tirs;
	private int nb_touches;
	private String secondes_arme;
	private int etoiles_bronze;
	private int etoiles_argent;
	private int etoiles_or;
	private int etoiles_platine;
	private int tirs_tete;
	private String nom;
	private String image;
	private int nb_tues;

	public Arme() {
	}

	public int getNb_tirs() {
		return nb_tirs;
	}

	public void setNb_tirs(int nb_tirs) {
		this.nb_tirs = nb_tirs;
	}

	public int getNb_touches() {
		return nb_touches;
	}

	public void setNb_touches(int nb_touches) {
		this.nb_touches = nb_touches;
	}

	public String getSecondes_arme() {
		return secondes_arme;
	}

	public void setSecondes_arme(String secondes_arme) {
		this.secondes_arme = secondes_arme;
	}

	public int getEtoiles_bronze() {
		return etoiles_bronze;
	}

	public void setEtoiles_bronze(int etoiles_bronze) {
		this.etoiles_bronze = etoiles_bronze;
	}

	public int getEtoiles_argent() {
		return etoiles_argent;
	}

	public void setEtoiles_argent(int etoiles_argent) {
		this.etoiles_argent = etoiles_argent;
	}

	public int getEtoiles_or() {
		return etoiles_or;
	}

	public void setEtoiles_or(int etoiles_or) {
		this.etoiles_or = etoiles_or;
	}

	public int getEtoiles_platine() {
		return etoiles_platine;
	}

	public void setEtoiles_platine(int etoiles_platine) {
		this.etoiles_platine = etoiles_platine;
	}

	public int getTirs_tete() {
		return tirs_tete;
	}

	public void setTirs_tete(int tirs_tete) {
		this.tirs_tete = tirs_tete;
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

	public int getNb_tues() {
		return nb_tues;
	}

	public void setNb_tues(int nb_tues) {
		this.nb_tues = nb_tues;
	}
}
