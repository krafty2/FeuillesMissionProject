package com.feuille.suivi.controller;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.feuille.suivi.modele.Feuille;
import com.feuille.suivi.modele.Personne;
import com.feuille.suivi.service.FeuilleService;
import com.feuille.suivi.service.PersonneService;

@Controller
public class FormulaireController {

	@Autowired
	PersonneService personneService;
	
	@Autowired
	FeuilleService feuilleService;

	@GetMapping("/formulaire")
	public String formulaireFeuille() {
		return "pages/formulaire";
	}
	
	@RequestMapping(value = "/enregistrerFeuille",method = RequestMethod.POST)
	public String enregistrerFeuille(
			@RequestParam String igg,
			@RequestParam Date date_depart, @RequestParam String heureD,
			@RequestParam Date date_retour, @RequestParam String heureR ,
			@RequestParam String destination, @RequestParam String locomotion,
			@RequestParam String objetMission, @RequestParam String argent
			) {
		Personne personne = new Personne();
		Feuille feuille = new Feuille();
		
		personne.setIgg(igg);
		
		feuille.setDate_depart(date_depart);
		feuille.setHeure_Depart(heureD);
		feuille.setHeure_Retour(heureR);
		feuille.setDate_retour(date_retour);
		feuille.setDestination(destination);
		feuille.setMoyenLocomoaton(locomotion);
		feuille.setObjetMission(objetMission);
		feuille.setArgent(argent);
	
		feuille.setPersonne(personne);
		
		feuilleService.saveFeuille(feuille);
		
		return "pages/formulaire";
	}

	@GetMapping(value = "/test")
	public String viewEditeurFeuille(Model model) {
		//version test
		String igg = "L1049814";
		Feuille feuille 	= new Feuille();
		Personne personne 	= new Personne();
		
		List<Object[]> result = feuilleService.findEditeur(igg);
		
		result.stream().forEach((record)->{

			
			
			
			
			personne.setIgg((String) record[0]);
			personne.setNom((String) record[1]);
			personne.setPrenom((String) record[2]);
			personne.setIggSuperieur((String) record[3]);
			personne.setFonction((String) record[4]);
			
			Long numero_departement = ((BigInteger) record[5]).longValue();
			feuille.setDate_depart((Date) record[6]);
			feuille.setDate_retour((Date) record[7]);
			feuille.setHeure_Depart((String) record[8]);
			feuille.setHeure_Retour((String) record[9]);
			String destination = (String) record[10];
			feuille.setDestination(destination);
			
			feuille.setMoyenLocomoaton((String) record[11]);
			
			System.out.println(destination);
			
		});
		model.addAttribute("personne", personne);
		model.addAttribute("feuille", feuille);
		return "pages/feuille_mission";
	}
}
