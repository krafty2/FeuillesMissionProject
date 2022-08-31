package com.feuille.suivi.service;

import java.util.List;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuille.suivi.modele.Feuille;
import com.feuille.suivi.repository.FeuilleRepository;

@Service
public class FeuilleService {

	@Autowired
	private FeuilleRepository feuilleRepository;
	
	public void saveFeuille(Feuille feuille) {
		feuilleRepository.save(feuille);
	}
	
	public List<Object[]> findEditeur(String editeurIgg) {
		return feuilleRepository.findEditeur(editeurIgg);
	}
}
