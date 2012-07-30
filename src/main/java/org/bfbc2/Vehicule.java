package org.bfbc2;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 20 juin 2010
 * Time: 11:27:21
 * To change this template use File | Settings | File Templates.
 */
public class Vehicule {
	private String distance;
	private int roadkills;
	private String secondes;
	private String nom;
	private String image;
	private String classe;
	private int tues;
	private Etoiles etoiles;

	public Vehicule() {
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getRoadkills() {
		return roadkills;
	}

	public void setRoadkills(int roadkills) {
		this.roadkills = roadkills;
	}

	public String getSecondes() {
		return secondes;
	}

	public void setSecondes(String secondes) {
		this.secondes = secondes;
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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getTues() {
		return tues;
	}

	public void setTues(int tues) {
		this.tues = tues;
	}

	public Etoiles getEtoiles() {
		return etoiles;
	}

	public void setEtoiles(Etoiles etoiles) {
		this.etoiles = etoiles;
	}
}
