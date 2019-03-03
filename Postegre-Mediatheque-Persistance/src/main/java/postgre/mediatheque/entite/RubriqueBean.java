package postgre.mediatheque.entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_rubrique_rub")

public class RubriqueBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rub_id")
	private long rub_id;
	@Column(name="rub_label")
	private String  rub_label;
	@Column(name="rub_idparent")
	private long rub_idparent;
	@Column(name="rub_datecreate")
	private Date rub_datecreate;
	@Column(name="rub_usercreate")
	private String  rub_usercreate;
	@Column(name="rub_dossierOrformulaire")
	private boolean  rub_dossierOrformulaire;
	@Column(name="rub_description")
	private String rub_description;
	@Column(name="rub_finishconfiguration")
	private String rub_finishconfiguration;
	
	
	public long getRub_id() {
		return rub_id;
	}
	public void setRub_id(long rub_id) {
		this.rub_id = rub_id;
	}
	public String getRub_label() {
		return rub_label;
	}
	public void setRub_label(String rub_label) {
		this.rub_label = rub_label;
	}
	public long getRub_idparent() {
		return rub_idparent;
	}
	public void setRub_idparent(long rub_idparent) {
		this.rub_idparent = rub_idparent;
	}
	public Date getRub_datecreate() {
		return rub_datecreate;
	}
	public void setRub_datecreate(Date rub_datecreate) {
		this.rub_datecreate = rub_datecreate;
	}
	public String getRub_usercreate() {
		return rub_usercreate;
	}
	public void setRub_usercreate(String rub_usercreate) {
		this.rub_usercreate = rub_usercreate;
	}
	public boolean isRub_dossierOrformulaire() {
		return rub_dossierOrformulaire;
	}
	public void setRub_dossierOrformulaire(boolean rub_dossierOrformulaire) {
		this.rub_dossierOrformulaire = rub_dossierOrformulaire;
	}
	public String getRub_description() {
		return rub_description;
	}
	public void setRub_description(String rub_description) {
		this.rub_description = rub_description;
	}
	public String getRub_finishconfiguration() {
		return rub_finishconfiguration;
	}
	public void setRub_finishconfiguration(String rub_finishconfiguration) {
		this.rub_finishconfiguration = rub_finishconfiguration;
	}
	public RubriqueBean(String rub_label, long rub_idparent, Date rub_datecreate, String rub_usercreate,
			boolean rub_dossierOrformulaire, String rub_description, String rub_finishconfiguration) {
		
		this.rub_label = rub_label;
		this.rub_idparent = rub_idparent;
		this.rub_datecreate = rub_datecreate;
		this.rub_usercreate = rub_usercreate;
		this.rub_dossierOrformulaire = rub_dossierOrformulaire;
		this.rub_description = rub_description;
		this.rub_finishconfiguration = rub_finishconfiguration;
	}
	public RubriqueBean() {
	}
}
