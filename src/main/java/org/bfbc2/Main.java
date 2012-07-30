package org.bfbc2;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 19 juin 2010
 * Time: 14:35:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {

	// file:///C:/projet/bfbc2/stats/res2010-06-19_07h43m58s.json

	public static void main(String arg[])
	{
		System.out.println("coucou");
		test1();
		//test2();
	}

	private static void test1() {
		List<String> liste_joueurs;
		Telecharge telecharge;
		JSONObject res=null;
		Joueurs joueur=null;
		liste_joueurs=new ArrayList<String>();
		if(true)
		{
			liste_joueurs.add("forniax");
		}
		else
		{
			liste_joueurs.add("1ApRiL");
			liste_joueurs.add("ContraViZe");
		}
		telecharge=new Telecharge(liste_joueurs);
		try {
			telecharge.telecharge();
			res=telecharge.getResultat();
			System.out.println("res="+res);
			enregistre(res);
			joueur=convertie(res);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		fenetre2(joueur);
	}


	private static void test2() {
		List<String> liste_joueurs;
		Telecharge telecharge;
		JSONObject res=null;
		Joueurs joueur=null;
		File f;
		liste_joueurs=new ArrayList<String>();
		if(true)
		{
			liste_joueurs.add("forniax");
		}
		else
		{
			liste_joueurs.add("1ApRiL");
			liste_joueurs.add("ContraViZe");
		}
		//C:\projet\bfbc2\stats\res2010-06-19_09h03m19s.json
		f=new File("stats/res2010-06-19_09h03m19s.json");

		//telecharge=new Telecharge(liste_joueurs);
		try {
			res=lecture(f);
			//telecharge.telecharge();
			//res=telecharge.getResultat();
			System.out.println("res="+res);
			//enregistre(res);
			joueur=convertie(res);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		fenetre2(joueur);
	}

	private static JSONObject lecture(File f) throws IOException, JSONException {
		JSONObject res=null;
		BufferedReader in=null;
		String s,buf;
		try{
			in=new BufferedReader(new FileReader(f));
			buf="";
			while((s=in.readLine())!=null)
			{
				buf+=s+"\n";
			}
			res=new JSONObject(buf);
		}finally{
			if(in!=null)
				in.close();
		}
		return res;
	}

	private static Joueurs convertie(JSONObject racine) throws JSONException {
		Joueur joueur=null;
		JSONObject player,general,kits,tmp,tmp2,team,armes,
				vehicules,gadgets,specialisation;
		JSONArray players,pins,insignes,achevements;
		Joueurs joueurs=null;
		List<Joueur> liste_joueurs;
		if(racine!=null)
		{
			joueurs=new Joueurs();
			liste_joueurs=new ArrayList<Joueur>();
			joueurs.setListe_joueur(liste_joueurs);
			System.out.println("request="+racine.getString("requested"));
			players=racine.getJSONArray("players");
			if(players!=null&&players.length()>0)
			{
				for(int i=0;i<players.length();i++)
				{
					//player=players..getJSONObject("players");
					player=players.getJSONObject(i);
					System.out.println("nom="+player.getString("name"));
					joueur=new Joueur();
					liste_joueurs.add(joueur);
					joueur.setNom(player.getString("name"));
					joueur.setScore(player.getInt("score"));
					joueur.setRand(player.getInt("rank"));
					joueur.setNiveau(player.getInt("level"));
					joueur.setVeteran(player.getInt("veteran"));
					joueur.setNb_morts(player.getInt("deaths"));
					joueur.setNom_rand(player.getString("rank_name"));
					joueur.setNb_tues(player.getInt("kills"));
					joueur.setPlateforme(player.getString("platform"));
					joueur.setForm(player.getInt("form"));
					joueur.setElo(player.getString("elo"));

					general=player.getJSONObject("general");
					if(general!=null)
					{
						joueur.setNb_dogr(general.getInt("dogr"));
						joueur.setNb_dogt(general.getInt("dogt"));
						joueur.setNb_dogt(general.getInt("dogt"));
						joueur.setScore_assaut(general.getInt("sc_assault"));
						joueur.setElo1(general.getString("elo1"));
						joueur.setElo0(general.getString("elo0"));
						joueur.setScore_general(general.getInt("sc_general"));
						joueur.setScore_objectifs(general.getInt("sc_objective"));
						joueur.setScore_award(general.getInt("sc_award"));
						joueur.setNb_echecs(general.getInt("losses"));
						joueur.setTeamkills(general.getInt("teamkills"));
						joueur.setScore_ingenieur(general.getInt("sc_demo"));
						joueur.setScore_bonus(general.getInt("sc_bonus"));
						joueur.setGames(general.getInt("games"));
						joueur.setGold_edition(general.getInt("goldedition"));
						joueur.setScore(general.getInt("sc_vehicle"));
						joueur.setScore_recon(general.getInt("sc_recon"));
						joueur.setScore_medic(general.getInt("sc_support"));
						joueur.setScore_escouade(general.getInt("sc_squad"));
						joueur.setPrecision_tirs(general.getString("accuracy"));
						joueur.setScore_equipe(general.getInt("sc_team"));
						joueur.setNb_victoires(general.getInt("wins"));
					}
					kits=player.getJSONObject("kits");
					if(kits!=null)
					{
						tmp=kits.getJSONObject("demo");
						joueur.setIngenieur_morts(tmp.getInt("deaths"));
						joueur.setIngenieur_score(tmp.getInt("score"));
						joueur.setIngenieur_tues(tmp.getInt("kills"));
						tmp=kits.getJSONObject("support");
						joueur.setMedic_morts(tmp.getInt("deaths"));
						joueur.setMedic_score(tmp.getInt("score"));
						joueur.setMedic_tues(tmp.getInt("kills"));
						tmp=kits.getJSONObject("recon");
						joueur.setRecon_morts(tmp.getInt("deaths"));
						joueur.setRecon_score(tmp.getInt("score"));
						joueur.setRecon_tues(tmp.getInt("kills"));
						tmp=kits.getJSONObject("assault");
						joueur.setAssaut_morts(tmp.getInt("deaths"));
						joueur.setAssaut_score(tmp.getInt("score"));
						joueur.setAssaut_tues(tmp.getInt("kills"));
					}
					team=player.getJSONObject("teams");
					if(team!=null)
					{
						tmp=team.getJSONObject("def");
						joueur.setDefense_defaite(tmp.getInt("loss"));
						joueur.setDefense_victoire(tmp.getInt("win"));
						tmp=team.getJSONObject("att");
						joueur.setAttaque_defaite(tmp.getInt("loss"));
						joueur.setAttaque_victoire(tmp.getInt("win"));
					}
					pins=player.getJSONArray("pins");
					if(pins!=null&&pins.length()>0)
					{
						List<Pin> liste_pins;
						Pin tmp3;
						liste_pins=new ArrayList<Pin>();
						joueur.setListe_pins(liste_pins);
						for(int j=0;j<pins.length();j++)
						{
							tmp=pins.getJSONObject(j);
							tmp3=new Pin();
							tmp3.setNb(tmp.getInt("count"));
							tmp3.setNom(tmp.getString("name"));
							tmp3.setUrl_image(tmp.getString("img"));
							liste_pins.add(tmp3);
						}
					}
					armes=player.getJSONObject("weapons");
					if(armes!=null)
					{
						JSONArray tab;
						JSONObject tmp3,tmp4;
						Arme arme;
						List<Arme> liste_armes;
						Iterator iter;
						String s;
						iter=armes.keys();

						//tab=armes.names();
						//if(tab!=null&&tab.length()>0)
						if(iter!=null&&iter.hasNext())
						{
							liste_armes=new ArrayList<Arme>();
							joueur.setListe_armes(liste_armes);
							//for(int j=0;j<tab.length();j++)
							//while(iter.hasMoreElements())
							//for(JSONObject o:iter)
							while(iter.hasNext())
							{
								//tmp3=tab.getJSONObject(j);
								//tmp3= (JSONObject) enum0.nextElement();
								s= (String) iter.next();
								System.out.println("armes="+s);
								if(armes.has(s))
								{
									tmp3= armes.getJSONObject(s) ;
									arme=new Arme();
									arme.setNb_tirs(tmp3.getInt("shots_fired"));
									arme.setNb_touches(tmp3.getInt("shots_hit"));
									arme.setTirs_tete(tmp3.getInt("headshots"));
									arme.setSecondes_arme(tmp3.getString("seconds"));
									arme.setNom(tmp3.getString("name"));
									arme.setImage(tmp3.getString("img"));
									arme.setNb_tues(tmp3.getInt("kills"));
									if(!tmp3.isNull("stars"))
									{
										//tmp3.
										tmp4=tmp3.optJSONObject("stars");
										//tmp4=tmp3.getJSONObject("stars");
										if(tmp4!=null)
										{
											arme.setEtoiles_bronze(tmp4.getInt("bron"));
											arme.setEtoiles_argent(tmp4.getInt("silv"));
											arme.setEtoiles_or(tmp4.getInt("gold"));
											arme.setEtoiles_platine(tmp4.getInt("plat"));
										}
									}
									liste_armes.add(arme);
								}
							}
						}
					}
					vehicules=player.getJSONObject("vehicles");
					if(vehicules!=null)
					{
						JSONArray tab;
						JSONObject tmp3,tmp4;
						Vehicule vehicule;
						List<Vehicule> liste_vehicules;
						Iterator iter;
						String s;
						Etoiles etoiles;
						iter=vehicules.keys();

						//tab=vehicules.names();
						//if(tab!=null&&tab.length()>0)
						if(iter!=null&&iter.hasNext())
						{
							liste_vehicules=new ArrayList<Vehicule>();
							joueur.setListe_vehicules(liste_vehicules);
							//for(int j=0;j<tab.length();j++)
							//while(iter.hasMoreElements())
							//for(JSONObject o:iter)
							while(iter.hasNext())
							{
								//tmp3=tab.getJSONObject(j);
								//tmp3= (JSONObject) enum0.nextElement();
								s= (String) iter.next();
								System.out.println("vehicules="+s);
								if(vehicules.has(s))
								{
									tmp3= vehicules.getJSONObject(s) ;
									vehicule=new Vehicule();
									if(tmp3.has("distance"))
										vehicule.setDistance(tmp3.getString("distance"));
									vehicule.setSecondes(tmp3.getString("seconds"));
									if(tmp3.has("roadkills"))
										vehicule.setRoadkills(tmp3.getInt("roadkills"));
									vehicule.setNom(tmp3.getString("name"));
									vehicule.setImage(tmp3.getString("img"));
									vehicule.setClasse(tmp3.getString("class"));
									if(tmp3.has("kills"))
										vehicule.setTues(tmp3.getInt("kills"));
									etoiles=new Etoiles();
									vehicule.setEtoiles(etoiles);
									tmp4=tmp3.getJSONObject("stars");
									if(tmp4!=null)
									{
										etoiles.setBronze(tmp4.getInt("bron"));
										etoiles.setArgent(tmp4.getInt("silv"));
										etoiles.setOr(tmp4.getInt("gold"));
										etoiles.setPlatine(tmp4.getInt("plat"));
									}
									liste_vehicules.add(vehicule);
								}
							}
						}
					}
					specialisation=player.getJSONObject("specializations");
					if(specialisation!=null)
					{
						JSONArray tab;
						JSONObject tmp3,tmp4;
						Specialisation spec;
						List<Specialisation> liste_specialisations;
						Iterator iter;
						String s;
						Etoiles etoiles;
						iter=specialisation.keys();

						//tab=vehicules.names();
						//if(tab!=null&&tab.length()>0)
						if(iter!=null&&iter.hasNext())
						{
							liste_specialisations=new ArrayList<Specialisation>();
							joueur.setListe_specialisations(liste_specialisations);
							//for(int j=0;j<tab.length();j++)
							//while(iter.hasMoreElements())
							//for(JSONObject o:iter)
							while(iter.hasNext())
							{
								//tmp3=tab.getJSONObject(j);
								//tmp3= (JSONObject) enum0.nextElement();
								s= (String) iter.next();
								System.out.println("specialisation="+s);
								if(specialisation.has(s))
								{
									tmp3= specialisation.getJSONObject(s) ;
									spec=new Specialisation();
									spec.setUnlock(tmp3.optInt("unlocked"));
									spec.setNom(tmp3.getString("name"));
									spec.setImage(tmp3.getString("img"));
									spec.setKits(tmp3.getString("kit"));
									if(tmp3.has("criteria1"))
									{
										tmp4=tmp3.getJSONObject("criteria1");
										spec.setValeur_min(tmp4.getInt("target"));
										spec.setValeur(tmp4.getInt("value"));
										spec.setLabel(tmp4.getString("label"));
									}
									liste_specialisations.add(spec);
								}
							}
						}
					}
					gadgets=player.getJSONObject("gadgets");
					if(gadgets!=null)
					{
						JSONArray tab;
						JSONObject tmp3,tmp4;
						Gadget gadget;
						List<Gadget> liste_gadgets;
						Iterator iter;
						String s;
						Etoiles etoiles;
						iter=gadgets.keys();

						//tab=vehicules.names();
						//if(tab!=null&&tab.length()>0)
						if(iter!=null&&iter.hasNext())
						{
							liste_gadgets=new ArrayList<Gadget>();
							joueur.setListe_gadgets(liste_gadgets);
							//for(int j=0;j<tab.length();j++)
							//while(iter.hasMoreElements())
							//for(JSONObject o:iter)
							while(iter.hasNext())
							{
								//tmp3=tab.getJSONObject(j);
								//tmp3= (JSONObject) enum0.nextElement();
								s= (String) iter.next();
								System.out.println("gadget="+s);
								if(gadgets.has(s))
								{
									tmp3= gadgets.getJSONObject(s) ;
									gadget=new Gadget();
									gadget.setUnlock(tmp3.optInt("unlocked"));
									if(tmp3.has("shots_fired"))
										gadget.setNb_tires(tmp3.getInt("shots_fired"));
									if(tmp3.has("shots_fired"))
										gadget.setNb_tires_touche(tmp3.getInt("shots_hit"));
									if(tmp3.has("shots_fired"))
										gadget.setNb_tues(tmp3.getInt("kills"));
									if(tmp3.has("shots_fired"))
										gadget.setHeadshot(tmp3.getInt("headshots"));
									if(tmp3.has("shots_fired"))
										gadget.setSecondes(tmp3.getString("seconds"));
									gadget.setEtoiles(etoiles(tmp3));
									gadget.setNom(tmp3.getString("name"));
									gadget.setImage(tmp3.getString("img"));
									gadget.setKits(tmp3.getString("kit"));
									liste_gadgets.add(gadget);
								}
							}
						}
					}
					insignes=player.getJSONArray("insiginias");
					if(insignes!=null&&insignes.length()>0)
					{
						JSONArray tab;
						JSONObject tmp3,tmp4;
						Insigne insigne;
						List<Insigne> liste_insignes;
						Iterator iter;
						String s;
						Etoiles etoiles;
						//iter=insignes.keys();

						//tab=vehicules.names();
						//if(tab!=null&&tab.length()>0)
						//if(iter!=null&&iter.hasNext())
						{
							liste_insignes=new ArrayList<Insigne>();
							joueur.setListe_insignes(liste_insignes);
							//for(int j=0;j<tab.length();j++)
							//while(iter.hasMoreElements())
							//for(JSONObject o:iter)
							//while(iter.hasNext())
							for(int j=0;j<insignes.length();j++)
							{
								tmp3=insignes.getJSONObject(j);
								//tmp3= (JSONObject) enum0.nextElement();
								//s= (String) iter.next();
								//System.out.println("insigne="+s);
								//if(insignes.has(s))
								{
									//tmp3= insignes.getJSONObject(s) ;
									insigne=new Insigne();
									insigne.setNombre(tmp3.optInt("count"));
									insigne.setNom(tmp3.getString("name"));
									insigne.setImage(tmp3.getString("img"));
									if(tmp3.has("criteria1"))
									{
										tmp4=tmp3.getJSONObject("criteria1");
										insigne.setValeur_min(tmp4.getInt("target"));
										insigne.setValeur(tmp4.getInt("value"));
										insigne.setLabel(tmp4.getString("label"));
									}
									liste_insignes.add(insigne);
								}
							}
						}
					}
					achevements=player.getJSONArray("achievements");
					if(achevements!=null&&achevements.length()>0)
					{
						JSONArray tab;
						JSONObject tmp3,tmp4;
						Achevement achevement;
						List<Achevement> liste_achevements;
						Iterator iter;
						String s;
						Etoiles etoiles;
						//iter=insignes.keys();

						//tab=vehicules.names();
						//if(tab!=null&&tab.length()>0)
						//if(iter!=null&&iter.hasNext())
						{
							liste_achevements=new ArrayList<Achevement>();
							joueur.setListe_achevement(liste_achevements);
							//for(int j=0;j<tab.length();j++)
							//while(iter.hasMoreElements())
							//for(JSONObject o:iter)
							//while(iter.hasNext())
							for(int j=0;j<achevements.length();j++)
							{
								tmp3=achevements.getJSONObject(j);
								//tmp3= (JSONObject) enum0.nextElement();
								//s= (String) iter.next();
								//System.out.println("insigne="+s);
								//if(insignes.has(s))
								{
									//tmp3= insignes.getJSONObject(s) ;
									achevement=new Achevement();
									achevement.setUnlock(tmp3.optInt("unlocked"));
									achevement.setNom(tmp3.getString("name"));
									achevement.setImage(tmp3.getString("img"));
									liste_achevements.add(achevement);
								}
							}
						}
					}

					vehicules=player.getJSONObject("vehicle_class");
					if(vehicules!=null)
					{
						JSONArray tab;
						JSONObject tmp3,tmp4;
						Vehicule vehicule;
						List<Vehicule> liste_vehicules;
						Iterator iter;
						String s;
						Etoiles etoiles;
						//iter=vehicules.keys();

						if(vehicules.has("water"))
						{
							tmp3=vehicules.getJSONObject("water");
							joueur.setVehicule_eau(etoiles(tmp3));
						}
						if(vehicules.has("stationary"))
						{
							tmp3=vehicules.getJSONObject("stationary");
							joueur.setVehicule_stationaire(etoiles(tmp3));
						}
						if(vehicules.has("air"))
						{
							tmp3=vehicules.getJSONObject("air");
							joueur.setVehicule_air(etoiles(tmp3));
						}
						if(vehicules.has("heavy"))
						{
							tmp3=vehicules.getJSONObject("heavy");
							joueur.setVehicule_lourd(etoiles(tmp3));
						}
						if(vehicules.has("light"))
						{
							tmp3=vehicules.getJSONObject("light");
							joueur.setVehicule_leger(etoiles(tmp3));
						}
					}
				}
			}
		}
		return joueurs;
	}

	private static Etoiles etoiles(JSONObject tmp3) throws JSONException {
		Etoiles etoiles=null;
		JSONObject tmp4;
		if(tmp3.has("stars")&&!tmp3.isNull("stars"))
		{
			tmp4=tmp3.optJSONObject("stars");
			if(tmp4!=null)
			{
				etoiles=new Etoiles();
				etoiles.setBronze(tmp4.getInt("bron"));
				etoiles.setArgent(tmp4.getInt("silv"));
				etoiles.setOr(tmp4.getInt("gold"));
				etoiles.setPlatine(tmp4.getInt("plat"));
			}
		}
		return etoiles;
	}

	private static void fenetre2(Joueurs joueurs) {
		GUI2 gui;
		gui=new GUI2(joueurs);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}

	private static void enregistre(JSONObject res) {
		FileWriter destinationFile = null;
			File dest=null;
		int i;
		String debut,fin;
		DateFormat dateFormat;
		try{
			dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh'h'mm'm'ss's'");
			debut="stats/res"+dateFormat.format(new Date());
			fin=".json";
			dest=new File(debut+fin);
			i=2;
			while(dest.exists())
			{
				dest=new File(debut+i+fin);
				i++;
			}
			try{
				destinationFile = new FileWriter(dest);

				// Lecture par segment de 0.5Mo
				//byte buffer[] = new byte[512 * 1024];
				//int nbLecture;
				destinationFile.write(res.toString());
				//while ((nbLecture = sourceFile.read(buffer)) != -1){
				//	destinationFile.write(buffer, 0, nbLecture);
				//}
			} finally {
				if(destinationFile!=null)
					destinationFile.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
