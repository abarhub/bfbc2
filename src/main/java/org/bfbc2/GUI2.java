package org.bfbc2;

import org.json.JSONObject;
import org.json.JSONArray;

import javax.swing.*;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.AffineTransformOp;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 19 juin 2010
 * Time: 17:10:25
 * To change this template use File | Settings | File Templates.
 */
public class GUI2 extends JFrame implements ActionListener {

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 250;
	
	private static final String GENERAL = "General";
	private static final String ARMES = "Arme";
	private static final String GADGETS = "Gadgets";
	private static final String VEHICULES = "Vehicules";
	private static final String INSIGNES = "Insignes";
	private static final String PINS = "Pins";
	private static final String SPECIALISATION = "Specialisation";
	private static final String ACHEVEMENTS = "Achevements";
	private static final String DOGTAG = "Dogtag";

	private JPanel panel;
	private JComboBox combo;
	private JPanel panel2;
	private Joueurs joueurs;
	private Joueur joueur;

	public GUI2(Joueurs joueurs)
	{
		this.joueurs=joueurs;
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		init();
		telecharge_images();
		actualise();
	}

	private void telecharge_images() {
		BufferedImage bi;
		String rand;
		//http://files2.bfbcs.com/img/bfbcs/misc_normal/s_gold.png
		try {
			bi=lecture_image("/misc_normal/s_gold.png");
			bi=lecture_image("/misc_normal/s_silv.png");
			bi=lecture_image("/misc_normal/s_bron.png");
			bi=lecture_image("/misc_normal/s_plat.png");
			bi=lecture_image("/misc_normal/s_goldv.png");
			bi=lecture_image("/misc_normal/s_silvv.png");
			bi=lecture_image("/misc_normal/s_bronv.png");
			bi=lecture_image("/misc_normal/s_platv.png");
			bi=lecture_image("/ranks_big/r027.png");
			for(int i=1;i<=50;i++)
			{
				if(i<10)
					rand="0"+i;
				else
					rand=""+i;
				bi=lecture_image("/ranks_big/r0"+rand+".png");
			}
			for(int i=1;i<=50;i++)
			{
				if(i<10)
					rand="0"+i;
				else
					rand=""+i;
				bi=lecture_image("/ranks/r0"+rand+".png");
			}
			bi=lecture_image("/misc_icons/s_bron.png");
			bi=lecture_image("/misc_icons/s_silv.png");
			bi=lecture_image("/misc_icons/s_gold.png");
			bi=lecture_image("/misc_icons/s_plat.png");
			for(int i=1;i<10;i++)
			{
				bi=lecture_image("/misc_icons/s_gold_"+i+".png");
			}
			bi=lecture_image("/misc_icons/dt1.png");
			bi=lecture_image("/misc_icons/dt2.png");
			bi=lecture_image("/misc_icons/dt3.png");
			bi=lecture_image("misc_normal/dt1.png");
			bi=lecture_image("misc_normal/dt2.png");
			bi=lecture_image("misc_normal/dt3.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		//String
		JSONObject player;
		JSONArray players;
		JLabel label;
		String nom;
		Box box,box2;
		panel=new JPanel();
			//System.out.println("request="+racine.getString("requested"));
			//players=racine.getJSONArray("players");
			if(joueurs!=null&&joueurs.getListe_joueur()!=null&&!joueurs.getListe_joueur().isEmpty())
			{
				joueur=joueurs.getListe_joueur().get(0);
				nom=joueur.getNom();
			}
			else
			{
				joueur=null;
				nom="";
			}
				//player=players..getJSONObject("players");
				//player=players.getJSONObject(0);
				System.out.println("nom="+nom);
				box=Box.createVerticalBox();
				box2=Box.createHorizontalBox();
				label=new JLabel("Nom:");
				box2.add(label);
				label=new JLabel(nom);
				box2.add(label);
				box.add(box2);
				box2=Box.createHorizontalBox();
				combo=new JComboBox();
				combo.setEditable(false);
				combo.addItem(GENERAL);
				combo.addItem(ARMES);
				combo.addItem(GADGETS);
				combo.addItem(VEHICULES);
				combo.addItem(INSIGNES);
				combo.addItem(PINS);
				combo.addItem(ACHEVEMENTS);
				combo.addItem(SPECIALISATION);
				combo.addItem(DOGTAG);
				combo.addActionListener(this);
				box2.add(combo);
				box.add(box2);
		add(BorderLayout.NORTH,box);
				panel2=new JPanel();
				if(false)
				{
					box.add(panel2);
				}
				else
				{
					JScrollPane scroll;
					Dimension dim;
					dim=new Dimension(500,500);
					//dim=box.getMaximumSize();
					//dim=panel.getPreferredSize();
					//dim=panel.getMaximumSize();
					scroll=new JScrollPane(panel2);
					scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
					//scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
					//scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scroll.setMaximumSize(dim);
					scroll.setPreferredSize(dim);
					//panel.add(BorderLayout.CENTER,scroll);
					add(BorderLayout.CENTER,scroll);
				}
				//panel.add(box);
		//add(BorderLayout.CENTER,panel);
		//add(BorderLayout.CENTER,scroll);
	}

	private void actualise()
	{
		String selection;
		Box box,box2;
		selection=(String)combo.getSelectedItem();
		if(selection!=null)
		{
			if(selection.equals(GENERAL))
			{
				panel2.removeAll();
				if(joueur!=null)
				{
					box=Box.createVerticalBox();
					panel2.add(box);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("score : "));
					box2.add(new JLabel(""+joueur.getScore()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("rand : "));
					box2.add(new JLabel(""+joueur.getRand()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Nom rand : "));
					box2.add(new JLabel(joueur.getNom_rand()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("nivau : "));
					box2.add(new JLabel(""+joueur.getNiveau()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Vétérand : "));
					box2.add(new JLabel(""+joueur.getVeteran()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("nb morts : "));
					box2.add(new JLabel(""+joueur.getNb_morts()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Nb tués : "));
					box2.add(new JLabel(""+joueur.getNb_tues()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Plateforme : "));
					box2.add(new JLabel(joueur.getPlateforme()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("form : "));
					box2.add(new JLabel(""+joueur.getForm()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("elo : "));
					box2.add(new JLabel(""+joueur.getElo()));
					box.add(box2);

					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score assaut : "));
					box2.add(new JLabel(""+joueur.getScore_assaut()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score reconnaissance : "));
					box2.add(new JLabel(""+joueur.getScore_recon()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score Ingenieur : "));
					box2.add(new JLabel(""+joueur.getScore_ingenieur()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score Medecin : "));
					box2.add(new JLabel(""+joueur.getScore_medic()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("elo 1 : "));
					box2.add(new JLabel(""+joueur.getElo1()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("elo 0 : "));
					box2.add(new JLabel(""+joueur.getElo0()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score general : "));
					box2.add(new JLabel(""+joueur.getScore_general()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score objectif : "));
					box2.add(new JLabel(""+joueur.getScore_objectifs()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("dogt : "));
					box2.add(new JLabel(""+joueur.getNb_dogt()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("dogr : "));
					box2.add(new JLabel(""+joueur.getNb_dogr()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score award : "));
					box2.add(new JLabel(""+joueur.getScore_award()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Echecs : "));
					box2.add(new JLabel(""+joueur.getNb_echecs()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("teamkill : "));
					box2.add(new JLabel(""+joueur.getTeamkills()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score bonus : "));
					box2.add(new JLabel(""+joueur.getScore_bonus()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Nb jeux : "));
					box2.add(new JLabel(""+joueur.getGames()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Gold edition : "));
					box2.add(new JLabel(""+joueur.getGold_edition()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score véhicules : "));
					box2.add(new JLabel(""+joueur.getScore_vehicule()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score escouade : "));
					box2.add(new JLabel(""+joueur.getScore_escouade()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Score equipe : "));
					box2.add(new JLabel(""+joueur.getScore_equipe()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Précision tirs : "));
					box2.add(new JLabel(""+joueur.getPrecision_tirs()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Victoires : "));
					box2.add(new JLabel(""+joueur.getNb_victoires()));
					box.add(box2);

					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Ingenieur morts : "));
					box2.add(new JLabel(""+joueur.getIngenieur_morts()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Ingenieur tués : "));
					box2.add(new JLabel(""+joueur.getIngenieur_tues()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Ingenieur score : "));
					box2.add(new JLabel(""+joueur.getIngenieur_score()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Medic morts : "));
					box2.add(new JLabel(""+joueur.getMedic_morts()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Medic tués : "));
					box2.add(new JLabel(""+joueur.getMedic_tues()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Medic score : "));
					box2.add(new JLabel(""+joueur.getMedic_score()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Recon morts : "));
					box2.add(new JLabel(""+joueur.getRecon_morts()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Recon tués : "));
					box2.add(new JLabel(""+joueur.getRecon_tues()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Recon score : "));
					box2.add(new JLabel(""+joueur.getRecon_score()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Assaut morts : "));
					box2.add(new JLabel(""+joueur.getAssaut_morts()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Assaut tués : "));
					box2.add(new JLabel(""+joueur.getAssaut_tues()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Assaut score : "));
					box2.add(new JLabel(""+joueur.getAssaut_score()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Défense victoires : "));
					box2.add(new JLabel(""+joueur.getDefense_victoire()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Défense défaites : "));
					box2.add(new JLabel(""+joueur.getDefense_defaite()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Attaque victoires : "));
					box2.add(new JLabel(""+joueur.getAttaque_victoire()));
					box.add(box2);
					box2=Box.createHorizontalBox();
					box2.add(new JLabel("Attaque défaites : "));
					box2.add(new JLabel(""+joueur.getAttaque_defaite()));
					box.add(box2);

				}
			}
			else if(selection.equals(PINS))
			{
				/*
				http://files2.bfbcs.com/img/bfbcs/pins_small/p01.png
				/pins_normal/p02.png
				http://files2.bfbcs.com/img/bfbcs/pins_normal/p02.png
				 */
				panel2.removeAll();
				if(joueur!=null)
				{
					List<Pin> liste_pins;
					box=Box.createVerticalBox();
					panel2.add(box);
					/*{
						URL url= null;
						try {
							url = new URL("http://files2.bfbcs.com/img/bfbcs/pins_normal/p02.png");
							BufferedImage image = ImageIO.read(url);
							//image=scale(image,75,75);
							image=scale(image,0.5);
							box2=Box.createHorizontalBox();
							box2.add(new JLabel("nom : "));
							//box2.add(new JLabel(image));
							box2.add(new ImagePanel(image));
							box.add(box2);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}*/
					liste_pins=joueur.getListe_pins();
					if(liste_pins!=null&&!liste_pins.isEmpty())
					{
						Box box3,box4=null;
						int i=1,nb=4;
						box4=Box.createHorizontalBox();
						for(Pin p:liste_pins)
						{
							//box2=Box.createHorizontalBox();
							//box2.add(new JLabel("nom : "));
							try {
								//URL url2 = new URL("http://files2.bfbcs.com/img/bfbcs/"+p.getUrl_image());
								//BufferedImage image = ImageIO.read(url2);
								BufferedImage image =lecture_image(p.getUrl_image());
								//image=scale(image,75,75);
								image=scale(image,0.5);
								box2=Box.createVerticalBox();
								//box2.add(new JLabel("nom : "));
								//box2.add(new JLabel(image));
								box2.add(new ImagePanel(image));
								box3=Box.createHorizontalBox();
								//box3.add(new JLabel("nom : "));
								box3.add(new JLabel(p.getNom()));
								box3.add(new JLabel("x"+p.getNb()));
								box2.add(box3);
								box4.add(box2);
								if(i%nb==0)
								{
									box.add(box4);
									box4=Box.createHorizontalBox();
								}
								else
								{
									//box.add(box2);
								}
								i++;
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							//box2.add(new JLabel(p.getNom()));
							//box.add(box2);
						}

						if(i%nb!=0&&box4!=null)
						{
							box.add(box4);
							//box4=Box.createHorizontalBox();
						}
					}
				}
			}
			else if(selection.equals(ARMES))
			{
				/*
				http://files2.bfbcs.com/img/bfbcs/pins_small/p01.png
				/pins_normal/p02.png
				http://files2.bfbcs.com/img/bfbcs/pins_normal/p02.png
				 */
				panel2.removeAll();
				if(joueur!=null)
				{
					List<Arme> liste_armes;
					box=Box.createVerticalBox();
					panel2.add(box);
					liste_armes=joueur.getListe_armes();
					if(liste_armes!=null&&!liste_armes.isEmpty())
					{
						for(Arme p:liste_armes)
						{
							box2=Box.createHorizontalBox();
							//box2.add(new JLabel("nom : "));
							try {
								//URL url2 = new URL("http://files2.bfbcs.com/img/bfbcs/"+p.getUrl_image());
								//BufferedImage image = ImageIO.read(url2);
								BufferedImage image =lecture_image(p.getImage());
								//image=scale(image,75,75);
								//image=scale(image,0.5);
								box2=Box.createHorizontalBox();
								//box2.add(new JLabel("nom : "));
								//box2.add(new JLabel(image));
								box2.add(new ImagePanel(image));
								box.add(box2);
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							box2.add(new JLabel(p.getNom()));
							box.add(box2);
						}
					}
				}
			}
			else if(selection.equals(VEHICULES))
			{
				/*
				http://files2.bfbcs.com/img/bfbcs/pins_small/p01.png
				/pins_normal/p02.png
				http://files2.bfbcs.com/img/bfbcs/pins_normal/p02.png
				 */
				panel2.removeAll();
				if(joueur!=null)
				{
					List<Vehicule> liste_vehicule;
					box=Box.createVerticalBox();
					panel2.add(box);
					liste_vehicule=joueur.getListe_vehicules();
					if(liste_vehicule!=null&&!liste_vehicule.isEmpty())
					{
						for(Vehicule p:liste_vehicule)
						{
							box2=Box.createHorizontalBox();
							//box2.add(new JLabel("nom : "));
							try {
								//URL url2 = new URL("http://files2.bfbcs.com/img/bfbcs/"+p.getUrl_image());
								//BufferedImage image = ImageIO.read(url2);
								BufferedImage image =lecture_image(p.getImage());
								//image=scale(image,75,75);
								//image=scale(image,0.5);
								box2=Box.createHorizontalBox();
								//box2.add(new JLabel("nom : "));
								//box2.add(new JLabel(image));
								box2.add(new ImagePanel(image));
								box.add(box2);
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							box2.add(new JLabel(p.getNom()));
							box.add(box2);
						}
					}
				}
			}
			else if(selection.equals(GADGETS))
			{
				/*
				http://files2.bfbcs.com/img/bfbcs/pins_small/p01.png
				/pins_normal/p02.png
				http://files2.bfbcs.com/img/bfbcs/pins_normal/p02.png
				 */
				panel2.removeAll();
				if(joueur!=null)
				{
					List<Gadget> liste_gadgets;
					box=Box.createVerticalBox();
					panel2.add(box);
					liste_gadgets=joueur.getListe_gadgets();
					if(liste_gadgets!=null&&!liste_gadgets.isEmpty())
					{
						for(Gadget p:liste_gadgets)
						{
							box2=Box.createHorizontalBox();
							//box2.add(new JLabel("nom : "));
							try {
								//URL url2 = new URL("http://files2.bfbcs.com/img/bfbcs/"+p.getUrl_image());
								//BufferedImage image = ImageIO.read(url2);
								BufferedImage image =lecture_image(p.getImage());
								//image=scale(image,75,75);
								//image=scale(image,0.5);
								box2=Box.createHorizontalBox();
								//box2.add(new JLabel("nom : "));
								//box2.add(new JLabel(image));
								box2.add(new ImagePanel(image));
								box.add(box2);
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							box2.add(new JLabel(p.getNom()));
							box.add(box2);
						}
					}
				}
			}
			else if(selection.equals(SPECIALISATION))
			{
				panel2.removeAll();
				if(joueur!=null)
				{
					List<Specialisation> liste_specialisations;
					box=Box.createVerticalBox();
					panel2.add(box);
					liste_specialisations=joueur.getListe_specialisations();
					if(liste_specialisations!=null&&!liste_specialisations.isEmpty())
					{
						for(Specialisation p:liste_specialisations)
						{
							box2=Box.createHorizontalBox();
							//box2.add(new JLabel("nom : "));
							try {
								//URL url2 = new URL("http://files2.bfbcs.com/img/bfbcs/"+p.getUrl_image());
								//BufferedImage image = ImageIO.read(url2);
								BufferedImage image =lecture_image(p.getImage());
								//image=scale(image,75,75);
								//image=scale(image,0.5);
								box2=Box.createHorizontalBox();
								//box2.add(new JLabel("nom : "));
								//box2.add(new JLabel(image));
								box2.add(new ImagePanel(image));
								box.add(box2);
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							box2.add(new JLabel(p.getNom()));
							box.add(box2);
						}
					}
				}
			}
			else if(selection.equals(INSIGNES))
			{
				panel2.removeAll();
				if(joueur!=null)
				{
					List<Insigne> liste_insignes;
					box=Box.createVerticalBox();
					panel2.add(box);
					liste_insignes=joueur.getListe_insignes();
					if(liste_insignes!=null&&!liste_insignes.isEmpty())
					{
						for(Insigne p:liste_insignes)
						{
							box2=Box.createHorizontalBox();
							//box2.add(new JLabel("nom : "));
							try {
								//URL url2 = new URL("http://files2.bfbcs.com/img/bfbcs/"+p.getUrl_image());
								//BufferedImage image = ImageIO.read(url2);
								BufferedImage image =lecture_image(p.getImage());
								//image=scale(image,75,75);
								//image=scale(image,0.5);
								box2=Box.createHorizontalBox();
								//box2.add(new JLabel("nom : "));
								//box2.add(new JLabel(image));
								box2.add(new ImagePanel(image));
								box.add(box2);
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							box2.add(new JLabel(p.getNom()));
							box.add(box2);
						}
					}
				}
			}
			else if(selection.equals(ACHEVEMENTS))
			{
				panel2.removeAll();
				if(joueur!=null)
				{
					List<Achevement> liste_achevements;
					box=Box.createVerticalBox();
					panel2.add(box);
					liste_achevements=joueur.getListe_achevement();
					if(liste_achevements!=null&&!liste_achevements.isEmpty())
					{
						for(Achevement p:liste_achevements)
						{
							box2=Box.createHorizontalBox();
							//box2.add(new JLabel("nom : "));
							try {
								//URL url2 = new URL("http://files2.bfbcs.com/img/bfbcs/"+p.getUrl_image());
								//BufferedImage image = ImageIO.read(url2);
								BufferedImage image =lecture_image(p.getImage());
								//image=scale(image,75,75);
								//image=scale(image,0.5);
								box2=Box.createHorizontalBox();
								//box2.add(new JLabel("nom : "));
								//box2.add(new JLabel(image));
								box2.add(new ImagePanel(image));
								box.add(box2);
							} catch (MalformedURLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							box2.add(new JLabel(p.getNom()));
							box.add(box2);
						}
					}
				}
			}
			else
			{
				panel2.removeAll();
			}
		}
		//panel2.repaint();
		panel2.revalidate();
	}

	private BufferedImage lecture_image(String url_image) throws IOException {
		BufferedImage image;
		File f,tmp,f2;
		//tmp=new File("c:/projet/bfbc2/"+"tmp/images");
		tmp=new File("tmp/images");
		if(!tmp.exists())
		{
			tmp.mkdirs();
		}
		f=new File(tmp,url_image);
		if(f.exists())
		{
			image = ImageIO.read(f);
		}
		else
		{
			URL url2 = new URL("http://files2.bfbcs.com/img/bfbcs/"+url_image);
			image = ImageIO.read(url2);

			f2=f.getParentFile();
			if(!f2.exists())
			{
				f2.mkdirs();
			}

			Iterator writers = ImageIO.getImageWritersByFormatName("png");
			ImageWriter writer = (ImageWriter)writers.next();
			ImageOutputStream ios = ImageIO.createImageOutputStream(f);
			writer.setOutput(ios);
			writer.write(image);

		}
		return image;
	}

	public void actionPerformed(ActionEvent e) {
		if(e!=null)
		{
			if(e.getSource()==combo)
			{
				actualise();
			}
		}
	}

	private BufferedImage scale(BufferedImage bi, double scaleValue) {
        AffineTransform tx = new AffineTransform();
        tx.scale(scaleValue, scaleValue);
        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_BILINEAR);
        BufferedImage biNew = new BufferedImage( (int) (bi.getWidth() * scaleValue),
                (int) (bi.getHeight() * scaleValue),
                //bi.getType()
		        BufferedImage.TYPE_INT_ARGB
		        //BufferedImage.TYPE_INT_ARGB_PRE
		        //BufferedImage.TYPE_4BYTE_ABGR
		        //BufferedImage.TYPE_3BYTE_BGR
                );
        return op.filter(bi, biNew);

	}

	private BufferedImage scale(BufferedImage bi, int width,int height) {
        AffineTransform tx = new AffineTransform();
		double scaleValue1,scaleValue2;
		int width0,height0;
		width0=bi.getWidth();
		height0=bi.getHeight();
		scaleValue1=width/width0;
		scaleValue2=height/height0;
        tx.scale(scaleValue1, scaleValue2);
        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_BILINEAR);
        BufferedImage biNew = new BufferedImage( (int) (bi.getWidth() * scaleValue1),
                (int) (bi.getHeight() * scaleValue2),
                //bi.getType()
		        BufferedImage.TYPE_INT_ARGB
		        //BufferedImage.TYPE_INT_ARGB_PRE
                );
        return op.filter(bi, biNew);

	}
}
