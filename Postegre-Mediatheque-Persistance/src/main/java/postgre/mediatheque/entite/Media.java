package postgre.mediatheque.entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Media")

public class Media implements Serializable {
	@Id
	@Column(name="reference")
	private String reference;
	@Column(name="type")
	private String type;
	@Column(name="titre")
	private String titre;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Media(String reference, String type, String titre) {
		super();
		this.reference = reference;
		this.type = type;
		this.titre = titre;
	}

	public Media() {
		super();
	}

}
