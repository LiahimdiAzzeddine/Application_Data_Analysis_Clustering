package net.mongo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.mongo.api.model.Appartement;
import net.mongo.api.model.DataFlutter;
import net.mongo.api.repository.AppartementRepository;
import net.mongo.api.repository.DataFlutterRepository;

@CrossOrigin
@RestController
public class DataFlutterController {
	@Autowired
    private DataFlutterRepository repo;
	 @ResponseStatus(HttpStatus.CREATED)
	    @PostMapping("/fluterdataUser")
	    public  void AjouterDevice(@RequestBody DataFlutter data) {
	    	System.out.print(data.getNom()+data.getAge()+data.getEmail()+data.getUdid());
	    	repo.save(data);
	    }
	 
	 @GetMapping("/findAllDevices")
	    public List<DataFlutter> getDevices(){
	    	return repo.findAll();
	    }

}
