package com.feuille.suivi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.feuille.suivi.modele.Feuille;

public interface FeuilleRepository extends CrudRepository<Feuille, Long> {
		
	@Query(value="SELECT igg, nom, prenom, igg_superieur,fonction,\r\n"
			+ "numb_departement, date_depart, date_retour,\r\n"
			+ "heure_depart,heure_retour,destination,locomotion\r\n"
			+ "FROM feuille\r\n"
			+ "JOIN personne\r\n"
			+ "ON personne.igg=feuille.editeur_igg\r\n"
			+ "WHERE feuille.editeur_igg = :editeur_igg",nativeQuery=true)
	List<Object[]> findEditeur(String editeur_igg);
	
}
