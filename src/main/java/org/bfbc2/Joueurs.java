package org.bfbc2;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 19 juin 2010
 * Time: 19:52:41
 * To change this template use File | Settings | File Templates.
 */
public class Joueurs {

	private List<Joueur> liste_joueur;

	public Joueurs()
	{
		
	}


	public List<Joueur> getListe_joueur() {
		return liste_joueur;
	}

	public void setListe_joueur(List<Joueur> liste_joueur) {
		this.liste_joueur = liste_joueur;
	}
}
