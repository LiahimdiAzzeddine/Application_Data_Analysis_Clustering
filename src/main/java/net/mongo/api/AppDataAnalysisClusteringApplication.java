package net.mongo.api;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELException;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import net.mongo.api.model.Appartement;
import net.mongo.api.model.Utilisateur;
import net.mongo.api.repository.AppartementRepository;
import net.mongo.api.repository.Utilisateurrepository;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AppDataAnalysisClusteringApplication implements CommandLineRunner {
	@Autowired
	private  AppartementRepository repository;
	

	public static void main(String[] args) {
		SpringApplication.run(AppDataAnalysisClusteringApplication.class, args);
		
		
	}
	@Override
	public void run(String... args) throws Exception {

		
	}


}