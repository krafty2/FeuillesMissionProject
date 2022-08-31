package com.feuille.suivi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feuille.suivi.modele.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Long> {

}
