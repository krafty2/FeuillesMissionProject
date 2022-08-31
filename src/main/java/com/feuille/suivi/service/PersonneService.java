package com.feuille.suivi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuille.suivi.modele.Personne;
import com.feuille.suivi.repository.PersonneRepository;


@Service
public class PersonneService {
	
	@Autowired
	private PersonneRepository personneRepository;
	
	Iterable<Personne> listesPersonne(){
		return  personneRepository.findAll();
	}
	
	public void ajouterPersonne (Personne personne){
		personneRepository.save(personne);
	}
	
	public List<Object[]> infoPersonnes(){
		return personneRepository.listeInfoPersonnes();
	}
}
