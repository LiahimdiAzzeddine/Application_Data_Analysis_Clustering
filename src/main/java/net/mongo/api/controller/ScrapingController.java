package net.mongo.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.mongo.api.model.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@CrossOrigin
@RestController
public class ScrapingController {
	//https://news.ycombinator.com/
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/datahtml")
	public  List<String> getDataHtml(@RequestBody String url) throws IOException {
		List<String> myArrayList = new ArrayList<>();
		Document doc = Jsoup.connect(url).timeout(6000).get();
		Elements body = doc.getAllElements();
		myArrayList.add(body.toString());
		return myArrayList;
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/donne")
	public  List<String> donnee(@RequestBody Item item) throws IOException {
		String url=item.getUrl();
		String emp=item.getBalise1()+"."+item.getClasse1();
		List<String> myArrayList = new ArrayList<>();
		Document doc = Jsoup.connect(url).timeout(6000).get();
		Elements body = doc.select(emp);
		System.out.print(item.getBalise1()+".......................");

		for(Element e : body.select(item.getBalise1()))
		{
		    String title = e.select(emp).text();
		    myArrayList.add(title);
		   
		}
		return myArrayList;
	}
	
	

}
