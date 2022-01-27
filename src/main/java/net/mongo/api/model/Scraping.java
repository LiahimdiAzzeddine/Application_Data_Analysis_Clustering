package net.mongo.api.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import net.mongo.api.model.Utilisateur;
import net.mongo.api.repository.Utilisateurrepository;

public class Scraping {
	static Utilisateurrepository repository;

	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("https://www.mubawab.ma/fr/a/7320718/grand-appartement-%C3%A0-iberia-vue-d%C3%A9gag%C3%A9e").timeout(6000).get();
		Elements body = doc.select("h1.searchTitle");
		System.out.println(body.select("h1.searchTitle").size());
		

		for(Element e : body.select("h1.searchTitle"))
		{
		   // String img = e.select("td.posterColumn img").attr("src");
		    //System.out.println(img);
		    String title = e.select("h1.searchTitle").text();
		    System.out.println(title);
		   
		}


	}

}
