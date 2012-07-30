package org.bfbc2;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 20 juin 2010
 * Time: 11:51:58
 * To change this template use File | Settings | File Templates.
 */
public class Gadget {
	private int unlock;
	private int nb_tires;
	private int nb_tires_touche;
	private String secondes;
	private Etoiles etoiles;
	private int headshot;
	private String nom;
	private String image;
	private int nb_tues;
	private String kits;

	public Gadget() {
	}

	public int getUnlock() {
		return unlock;
	}

	public void setUnlock(int unlock) {
		this.unlock = unlock;
	}

	public int getNb_tires() {
		return nb_tires;
	}

	public void setNb_tires(int nb_tires) {
		this.nb_tires = nb_tires;
	}

	public int getNb_tires_touche() {
		return nb_tires_touche;
	}

	public void setNb_tires_touche(int nb_tires_touche) {
		this.nb_tires_touche = nb_tires_touche;
	}

	public String getSecondes() {
		return secondes;
	}

	public void setSecondes(String secondes) {
		this.secondes = secondes;
	}

	public Etoiles getEtoiles() {
		return etoiles;
	}

	public void setEtoiles(Etoiles etoiles) {
		this.etoiles = etoiles;
	}

	public int getHeadshot() {
		return headshot;
	}

	public void setHeadshot(int headshot) {
		this.headshot = headshot;
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

	public String getKits() {
		return kits;
	}

	public void setKits(String kits) {
		this.kits = kits;
	}
}
