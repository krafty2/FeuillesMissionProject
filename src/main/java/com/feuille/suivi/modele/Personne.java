package com.feuille.suivi.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Personne")
public class Personne {
	
	@Id
	private String igg;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "fonction")
	private String fonction;
	@Column(name = "iggSuperieur")
	private String iggSuperieur;
	
	public Personne() {}
	
	public Personne(String igg, String nom, String prenom, String fonction,String iggSuperieur) {
		super();
		this.igg = igg;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.iggSuperieur = iggSuperieur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getIgg() {
		return igg;
	}

	public void setIgg(String igg) {
		this.igg = igg;
	}

	public String getIggSuperieur() {
		return iggSuperieur;
	}

	public void setIggSuperieur(String iggSuperieur) {
		this.iggSuperieur = iggSuperieur;
	}
}
