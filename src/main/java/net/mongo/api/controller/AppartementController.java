 package net.mongo.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.mongo.api.model.Appartement;
import net.mongo.api.model.Utilisateur;
import net.mongo.api.repository.AppartementRepository;

@CrossOrigin
@RestController
public class AppartementController {
	@Autowired
    private AppartementRepository rep;
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/FlutterGetAll")
    public List<Appartement> getAllAppartement(){
    	return rep.findAll();
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/deleteData/{id}")
    public void delete(@PathVariable String id) {
    	Appartement UDB= rep.findById(id)
    			.orElseThrow(RuntimeException::new);
    	rep.delete(UDB);
    }

}
