package postgre.mediatheque.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;




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
	private int rub_id;
	@Column(name="rub_label")
	private String  label;
	@Column(name="rub_idparent")
	private int rub_idparent;
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
	/** children. */
	@Transient
    private List<RubriqueBean> rubriqueNoIdParent = new ArrayList<RubriqueBean>();
	
	@Transient
    private List<RubriqueBean> rubriqueAvecIdParent = new ArrayList<RubriqueBean>();
	
	
	public int getRub_id() {
		return rub_id;
	}
	public void setRub_id(int rub_id) {
		this.rub_id = rub_id;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getRub_idparent() {
		return rub_idparent;
	}
	public void setRub_idparent(int rub_idparent) {
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
	public List<RubriqueBean> getRubriqueNoIdParent() {
		return rubriqueNoIdParent;
	}
	public void setRubriqueNoIdParent(List<RubriqueBean> rubriqueNoIdParent) {
		this.rubriqueNoIdParent = rubriqueNoIdParent;
	}
	public List<RubriqueBean> getRubriqueAvecIdParent() {
		return rubriqueAvecIdParent;
	}
	public void setRubriqueAvecIdParent(List<RubriqueBean> rubriqueAvecIdParent) {
		this.rubriqueAvecIdParent = rubriqueAvecIdParent;
	}
	
	
	
}
