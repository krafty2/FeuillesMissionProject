package com.feuille.suivi.controller;


import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Email;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feuille.suivi.modele.Departement;
import com.feuille.suivi.modele.ObjetInfoPersonnes;
import com.feuille.suivi.modele.Personne;
import com.feuille.suivi.service.DepartementService;
import com.feuille.suivi.service.PersonneService;

@Controller
public class CreationController {
	
	@Autowired
	PersonneService personneService;
	
	@Autowired
	DepartementService departementService;
	
//------------------------------------------------------------------------------------------------------------------->
	@GetMapping("/creation")
	public String creation() {
		return "pages/creation_compte";
	}
//-------------------------------------------------------------------------------------------------------------------->
	@RequestMapping(value = "/creer")
	public String savePerson(
			@RequestParam String nom,
			@RequestParam String prenom,@RequestParam String fonction,
			@RequestParam String departement,@RequestParam String igg,
			@RequestParam String iggSuperieur, @RequestParam (required = false) String directeur){
		
			Personne personne = new Personne();
			Departement departement2 = new Departement();
			
			System.out.println("test : " + directeur);
			if(directeur != null) {
				personne.setNom(nom);
				personne.setPrenom(prenom);
				personne.setFonction(fonction);
				personne.setIgg(igg);
				personne.setIggSuperieur(iggSuperieur);
				
				departement2.setNom_Departement(departement);
				departement2.setIggChef(igg);
				departement2.getPersonnes().add(personne);
			} else {
				personne.setNom(nom);
				personne.setPrenom(prenom);
				personne.setFonction(fonction);
				personne.setIgg(igg);
				personne.setIggSuperieur(iggSuperieur);
				
				departement2.setNom_Departement(departement);
				
				departement2.getPersonnes().add(personne);
			}
				
			departementService.save(departement2);
			personneService.ajouterPersonne(personne);
		
			return "pages/creation_compte";
	}
//-------------------------------------------------------------------------------------------------------->
	@SuppressWarnings("unchecked")
	@GetMapping("/afficher")
	public String afficheInfo(Model model) {
		List<Object[]> resultsList = personneService.infoPersonnes();
		
		@SuppressWarnings("rawtypes")
		List myArrayList = new ArrayList();
		//List totaList = new ArrayList<>();
		resultsList.stream().forEach((record)->{
			String igg = (String) record[0];
			String nom = (String) record[1];
			String prenom = (String) record[2];
			String fonction = (String) record[3];
			String departement = (String) record[4];
			
			ObjetInfoPersonnes listPersonnes = new ObjetInfoPersonnes();
			
			listPersonnes.setIgg(igg);
			listPersonnes.setNom(nom);
			listPersonnes.setPrenom(prenom);
			listPersonnes.setFonction(fonction);
			listPersonnes.setDepartement(departement);
			
			myArrayList.add(listPersonnes);
			
		});
		System.out.println("myArraylist" + myArrayList);
		
		model.addAttribute("listePersonnel", myArrayList);
		
		return "pages/listeInfoPersonne";
	}
}
