package com.feuille.suivi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feuille.suivi.modele.Personne;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, String> {

	@Query(value="SELECT p.igg, p.nom, p.prenom, p.fonction, d.departement \r\n"
			+ "FROM personne p , departement d \r\n"
			+ "where p.numb_departement=d.id;",nativeQuery=true)
	List<Object[]> listeInfoPersonnes();

}
