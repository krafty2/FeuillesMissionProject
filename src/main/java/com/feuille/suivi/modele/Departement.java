package com.feuille.suivi.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departement")
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "departement")
	private String departement;
	@Column(name = "iggChef")
	private String iggChef;
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "numb_departement",referencedColumnName = "id")
	private List<Personne> personnes = new ArrayList<>();
	
	public Departement() {}
	
	public Departement(String nom_Departement, String iggChef, List<Personne> personnes) {
		super();
		this.departement = nom_Departement;
		this.iggChef = iggChef;
		this.personnes = personnes;
	}

	public String getNom_Departement() {
		return departement;
	}

	public void setNom_Departement(String nom_Departement) {
		this.departement = nom_Departement;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Personne personnes) {
		this.personnes = (List<Personne>) personnes;
	}

	public String getIggChef() {
		return iggChef;
	}

	public void setIggChef(String iggChef) {
		this.iggChef = iggChef;
	}
	
	
}
