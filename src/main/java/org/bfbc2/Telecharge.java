package org.bfbc2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Collection;
import java.net.URLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 19 juin 2010
 * Time: 14:37:01
 * To change this template use File | Settings | File Templates.
 */
public class Telecharge {

	private String url;
	private List<String> liste_joueurs;
	private JSONObject resultat;

	public Telecharge(List<String> liste_joueurs)
	{
		url="http://api.bfbcs.com/api";
		this.liste_joueurs=liste_joueurs;
	}

	public void telecharge() throws IOException, JSONException {
		String url0,players;

		if(liste_joueurs!=null&&!liste_joueurs.isEmpty())
		{
			players="";
			for(String s:liste_joueurs)
			{
				if(players.length()>0)
				players+=",";
				players+=s.trim();
			}
			url0=url+"/pc?players="+players+"&fields=all,dogtags,grimg,online,misc";
			telecharge(url0);
		}
	}

	private void telecharge(String url0) throws IOException, JSONException {
		String buf;
		URL url = new URL(url0);
		URLConnection conn = url.openConnection();
		/** Récupération de la réponse */
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		buf="";
		while ((line = br.readLine()) != null) {
				/** traitement des lignes */
			buf+=line+"\n";
		} br.close();
		System.out.println("buf="+buf);
		resultat=new JSONObject(buf);
	}

	public JSONObject getResultat() {
		return resultat;
	}
}
