package postgre.mediatheque.entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="membre")
public class Membre implements Serializable{
	
	@Id
	@Column(name="mail")
	private String mail;
	
	@Column(name="mot_de_passe")
	private String motdepasse;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="status")
	private String status;
	
	@Column(name="codestatus")
	private String codestatus;
	
	@Column(name="adresse")
	private String adresse;
	
	

	


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getCodestatus() {
		return codestatus;
	}

	public void setCodestatus(String codestatus) {
		this.codestatus = codestatus;
	}

	public Membre() {
		
	}
	

	public Membre(String mail, String motdepasse, String nom, String status, String codestatus, String adresse) {
		
		this.mail = mail;
		this.motdepasse = motdepasse;
		this.nom = nom;
		this.status = status;
		this.codestatus = codestatus;
		this.adresse = adresse;
	}


}
