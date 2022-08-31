package com.feuille.suivi.modele;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feuille")
public class Feuille {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "locomotion")
	private String moyenLocomotion;
	
	@Column(name = "objet")
	private String objetMission;
	
	@Column(name = "dateDepart")
	private Date date_depart;
	
	@Column(name = "heureDepart")
	private String heure_Depart;
	
	@Column(name = "dateRetour")
	private Date date_retour;
	
	@Column(name = "heureRetour")
	private String heure_Retour;
	
	@Column(name = "argent_sollicite")
	private String argent;
	
	@ManyToOne
	@JoinColumn(name = "editeur_Igg",foreignKey = @ForeignKey(name="EDITEUR_IGG_FK"))
	private Personne personne;
	
	@Column(name = "V_SH")
	private String validation_S_H;
	
	@Column(name = "V_dir")
	private String validation_Dir;
	
	@Column(name = "V_HSEQ")
	private String validation_HSEQ;
	
	@Column(name = "V_DRH")
	private String validation_DRH;
	
	@Column(name = "V_DG_DF")
	private String validation_DG_DF;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	
	private List<Personne> personnes = new ArrayList<>();
//-----------------------------------------------------------------------
	public Feuille() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMoyenLocomotion() {
		return moyenLocomotion;
	}

	public void setMoyenLocomoaton(String moyenLocomotion) {
		this.moyenLocomotion = moyenLocomotion;
	}

	public String getObjetMission() {
		return objetMission;
	}

	public void setObjetMission(String objetMission) {
		this.objetMission = objetMission;
	}

	public Date getDate_depart() {
		return date_depart;
	}

	public void setDate_depart(Date date_depart) {
		this.date_depart = date_depart;
	}

	public String getHeure_Depart() {
		return heure_Depart;
	}

	public void setHeure_Depart(String heure_Depart) {
		this.heure_Depart = heure_Depart;
	}

	public Date getDate_retour() {
		return date_retour;
	}

	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}

	public String getHeure_Retour() {
		return heure_Retour;
	}

	public void setHeure_Retour(String varHeureRetour) {
		this.heure_Retour = varHeureRetour;
	}

	public String getArgent() {
		return argent;
	}

	public void setArgent(String argent2) {
		this.argent = argent2;
	}
	
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public String getValidation_S_H() {
		return validation_S_H;
	}

	public void setValidation_S_H(String validation_S_H) {
		this.validation_S_H = validation_S_H;
	}

	public String getValidation_Dir() {
		return validation_Dir;
	}

	public void setValidation_Dir(String validation_Dir) {
		this.validation_Dir = validation_Dir;
	}

	public String getValidation_HSEQ() {
		return validation_HSEQ;
	}

	public void setValidation_HSEQ(String validation_HSEQ) {
		this.validation_HSEQ = validation_HSEQ;
	}

	public String getValidation_DRH() {
		return validation_DRH;
	}

	public void setValidation_DRH(String validation_DRH) {
		this.validation_DRH = validation_DRH;
	}

	public String getValidation_DG_DF() {
		return validation_DG_DF;
	}

	public void setValidation_DG_DF(String validation_DG_DF) {
		this.validation_DG_DF = validation_DG_DF;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	
}
