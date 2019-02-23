package postgre.mediatheque.entite;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock_files")
public class StockFiles  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="upload_id")
	private long id;
	
	//LE CASCADE PEREMET DE SUPPRIME MEDIA DANS TABLE MEDIA EN CAS DE SUPPRESSION D'UN OBJET STOCKFILES
	@ManyToOne(targetEntity=Media.class, cascade=CascadeType.REMOVE)
	@JoinColumn(name="reference", referencedColumnName = "reference")
	private Media reference;
	
	@Column(name="name_repertoire")
	private String repertoire;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Media getReference() {
		return reference;
	}
	public void setReference(Media reference) {
		this.reference = reference;
	}
	public String getRepertoire() {
		return repertoire;
	}
	public void setRepertoire(String repertoire) {
		this.repertoire = repertoire;
	}
}
