package org.bfbc2;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 19 juin 2010
 * Time: 19:49:17
 * To change this template use File | Settings | File Templates.
 */
public class Joueur {

	private String nom;
	private int score;
	private String temps_jeux;
	private int rand;
	private int niveau;
	private int veteran;
	private int nb_morts;
	private String nom_rand;
	private int nb_tues;
	private String plateforme;
	private int form;
	private String elo;
	private int score_assaut;
	private int score_recon;
	private int score_ingenieur;
	private int score_medic;
	private String elo1;
	private String elo0;
	private int score_general;
	private int score_objectifs;
	private int nb_dogt;
	private int nb_dogr;
	private int score_award;
	private int nb_echecs;
	private int teamkills;
	private int score_bonus;
	private int games;
	private int gold_edition;
	private int score_vehicule;
	private int score_escouade;
	private int score_equipe;
	private String precision_tirs;
	private int nb_victoires;
	private int ingenieur_morts;
	private int ingenieur_tues;
	private int ingenieur_score;
	private int medic_morts;
	private int medic_tues;
	private int medic_score;
	private int assaut_morts;
	private int assaut_tues;
	private int assaut_score;
	private int recon_morts;
	private int recon_tues;
	private int recon_score;
	private int defense_victoire;
	private int defense_defaite;
	private int attaque_victoire;
	private int attaque_defaite;
	private List<Pin> liste_pins;
	private List<Arme> liste_armes;
	private List<Vehicule> liste_vehicules;
	private List<Gadget> liste_gadgets;
	private List<Specialisation> liste_specialisations;
	private List<Insigne> liste_insignes;
	private List<Achevement> liste_achevement;
	private Etoiles vehicule_eau;
	private Etoiles vehicule_air;
	private Etoiles vehicule_leger;
	private Etoiles vehicule_lourd;
	private Etoiles vehicule_stationaire;
	private int dogt_total;
	private int dogt_bronze;
	private int dogt_bronze_unique;
	private int dogt_argent;
	private int dogt_argent_unique;
	private int dogt_or;
	private int dogt_or_unique;

	public Joueur()
	{

	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTemps_jeux() {
		return temps_jeux;
	}

	public void setTemps_jeux(String temps_jeux) {
		this.temps_jeux = temps_jeux;
	}

	public int getRand() {
		return rand;
	}

	public void setRand(int rand) {
		this.rand = rand;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getVeteran() {
		return veteran;
	}

	public void setVeteran(int veteran) {
		this.veteran = veteran;
	}

	public int getNb_morts() {
		return nb_morts;
	}

	public void setNb_morts(int nb_morts) {
		this.nb_morts = nb_morts;
	}

	public String getNom_rand() {
		return nom_rand;
	}

	public void setNom_rand(String nom_rand) {
		this.nom_rand = nom_rand;
	}

	public int getNb_tues() {
		return nb_tues;
	}

	public void setNb_tues(int nb_tues) {
		this.nb_tues = nb_tues;
	}

	public String getPlateforme() {
		return plateforme;
	}

	public void setPlateforme(String plateforme) {
		this.plateforme = plateforme;
	}

	public int getForm() {
		return form;
	}

	public void setForm(int form) {
		this.form = form;
	}

	public String getElo() {
		return elo;
	}

	public void setElo(String elo) {
		this.elo = elo;
	}

	public int getScore_assaut() {
		return score_assaut;
	}

	public void setScore_assaut(int score_assaut) {
		this.score_assaut = score_assaut;
	}

	public int getScore_recon() {
		return score_recon;
	}

	public void setScore_recon(int score_recon) {
		this.score_recon = score_recon;
	}

	public int getScore_ingenieur() {
		return score_ingenieur;
	}

	public void setScore_ingenieur(int score_ingenieur) {
		this.score_ingenieur = score_ingenieur;
	}

	public int getScore_medic() {
		return score_medic;
	}

	public void setScore_medic(int score_medic) {
		this.score_medic = score_medic;
	}

	public String getElo1() {
		return elo1;
	}

	public void setElo1(String elo1) {
		this.elo1 = elo1;
	}

	public String getElo0() {
		return elo0;
	}

	public void setElo0(String elo0) {
		this.elo0 = elo0;
	}

	public int getScore_general() {
		return score_general;
	}

	public void setScore_general(int score_general) {
		this.score_general = score_general;
	}

	public int getScore_objectifs() {
		return score_objectifs;
	}

	public void setScore_objectifs(int score_objectifs) {
		this.score_objectifs = score_objectifs;
	}

	public int getNb_dogt() {
		return nb_dogt;
	}

	public void setNb_dogt(int nb_dogt) {
		this.nb_dogt = nb_dogt;
	}

	public int getScore_award() {
		return score_award;
	}

	public void setScore_award(int score_award) {
		this.score_award = score_award;
	}

	public int getNb_echecs() {
		return nb_echecs;
	}

	public void setNb_echecs(int nb_echecs) {
		this.nb_echecs = nb_echecs;
	}

	public int getTeamkills() {
		return teamkills;
	}

	public void setTeamkills(int teamkills) {
		this.teamkills = teamkills;
	}

	public int getScore_bonus() {
		return score_bonus;
	}

	public void setScore_bonus(int score_bonus) {
		this.score_bonus = score_bonus;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getGold_edition() {
		return gold_edition;
	}

	public void setGold_edition(int gold_edition) {
		this.gold_edition = gold_edition;
	}

	public int getScore_vehicule() {
		return score_vehicule;
	}

	public void setScore_vehicule(int score_vehicule) {
		this.score_vehicule = score_vehicule;
	}

	public int getScore_escouade() {
		return score_escouade;
	}

	public void setScore_escouade(int score_escouade) {
		this.score_escouade = score_escouade;
	}

	public int getScore_equipe() {
		return score_equipe;
	}

	public void setScore_equipe(int score_equipe) {
		this.score_equipe = score_equipe;
	}

	public String getPrecision_tirs() {
		return precision_tirs;
	}

	public void setPrecision_tirs(String precision_tirs) {
		this.precision_tirs = precision_tirs;
	}

	public int getNb_victoires() {
		return nb_victoires;
	}

	public void setNb_victoires(int nb_victoires) {
		this.nb_victoires = nb_victoires;
	}

	public int getNb_dogr() {
		return nb_dogr;
	}

	public void setNb_dogr(int nb_dogr) {
		this.nb_dogr = nb_dogr;
	}

	public int getIngenieur_morts() {
		return ingenieur_morts;
	}

	public void setIngenieur_morts(int ingenieur_morts) {
		this.ingenieur_morts = ingenieur_morts;
	}

	public int getIngenieur_tues() {
		return ingenieur_tues;
	}

	public void setIngenieur_tues(int ingenieur_tues) {
		this.ingenieur_tues = ingenieur_tues;
	}

	public int getIngenieur_score() {
		return ingenieur_score;
	}

	public void setIngenieur_score(int ingenieur_score) {
		this.ingenieur_score = ingenieur_score;
	}

	public int getMedic_morts() {
		return medic_morts;
	}

	public void setMedic_morts(int medic_morts) {
		this.medic_morts = medic_morts;
	}

	public int getMedic_tues() {
		return medic_tues;
	}

	public void setMedic_tues(int medic_tues) {
		this.medic_tues = medic_tues;
	}

	public int getMedic_score() {
		return medic_score;
	}

	public void setMedic_score(int medic_score) {
		this.medic_score = medic_score;
	}

	public int getAssaut_morts() {
		return assaut_morts;
	}

	public void setAssaut_morts(int assaut_morts) {
		this.assaut_morts = assaut_morts;
	}

	public int getAssaut_tues() {
		return assaut_tues;
	}

	public void setAssaut_tues(int assaut_tues) {
		this.assaut_tues = assaut_tues;
	}

	public int getAssaut_score() {
		return assaut_score;
	}

	public void setAssaut_score(int assaut_score) {
		this.assaut_score = assaut_score;
	}

	public int getRecon_morts() {
		return recon_morts;
	}

	public void setRecon_morts(int recon_morts) {
		this.recon_morts = recon_morts;
	}

	public int getRecon_tues() {
		return recon_tues;
	}

	public void setRecon_tues(int recon_tues) {
		this.recon_tues = recon_tues;
	}

	public int getRecon_score() {
		return recon_score;
	}

	public void setRecon_score(int recon_score) {
		this.recon_score = recon_score;
	}

	public int getDefense_victoire() {
		return defense_victoire;
	}

	public void setDefense_victoire(int defense_victoire) {
		this.defense_victoire = defense_victoire;
	}

	public int getDefense_defaite() {
		return defense_defaite;
	}

	public void setDefense_defaite(int defense_defaite) {
		this.defense_defaite = defense_defaite;
	}

	public int getAttaque_victoire() {
		return attaque_victoire;
	}

	public void setAttaque_victoire(int attaque_victoire) {
		this.attaque_victoire = attaque_victoire;
	}

	public int getAttaque_defaite() {
		return attaque_defaite;
	}

	public void setAttaque_defaite(int attaque_defaite) {
		this.attaque_defaite = attaque_defaite;
	}

	public List<Pin> getListe_pins() {
		return liste_pins;
	}

	public void setListe_pins(List<Pin> liste_pins) {
		this.liste_pins = liste_pins;
	}

	public List<Arme> getListe_armes() {
		return liste_armes;
	}

	public void setListe_armes(List<Arme> liste_armes) {
		this.liste_armes = liste_armes;
	}

	public List<Vehicule> getListe_vehicules() {
		return liste_vehicules;
	}

	public void setListe_vehicules(List<Vehicule> liste_vehicules) {
		this.liste_vehicules = liste_vehicules;
	}

	public List<Gadget> getListe_gadgets() {
		return liste_gadgets;
	}

	public void setListe_gadgets(List<Gadget> liste_gadgets) {
		this.liste_gadgets = liste_gadgets;
	}

	public List<Specialisation> getListe_specialisations() {
		return liste_specialisations;
	}

	public void setListe_specialisations(List<Specialisation> liste_specialisations) {
		this.liste_specialisations = liste_specialisations;
	}

	public List<Insigne> getListe_insignes() {
		return liste_insignes;
	}

	public void setListe_insignes(List<Insigne> liste_insignes) {
		this.liste_insignes = liste_insignes;
	}

	public List<Achevement> getListe_achevement() {
		return liste_achevement;
	}

	public void setListe_achevement(List<Achevement> liste_achevement) {
		this.liste_achevement = liste_achevement;
	}

	public Etoiles getVehicule_eau() {
		return vehicule_eau;
	}

	public void setVehicule_eau(Etoiles vehicule_eau) {
		this.vehicule_eau = vehicule_eau;
	}

	public Etoiles getVehicule_air() {
		return vehicule_air;
	}

	public void setVehicule_air(Etoiles vehicule_air) {
		this.vehicule_air = vehicule_air;
	}

	public Etoiles getVehicule_leger() {
		return vehicule_leger;
	}

	public void setVehicule_leger(Etoiles vehicule_leger) {
		this.vehicule_leger = vehicule_leger;
	}

	public Etoiles getVehicule_lourd() {
		return vehicule_lourd;
	}

	public void setVehicule_lourd(Etoiles vehicule_lourd) {
		this.vehicule_lourd = vehicule_lourd;
	}

	public Etoiles getVehicule_stationaire() {
		return vehicule_stationaire;
	}

	public void setVehicule_stationaire(Etoiles vehicule_stationaire) {
		this.vehicule_stationaire = vehicule_stationaire;
	}
}
