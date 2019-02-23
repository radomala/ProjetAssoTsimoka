package postgre.mediatheque.entite;

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
@Table(name="USER_ROLES")
public class Users_roles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_ROLE_USER")
	private int id;
	
	//LE CASCADE PERMET DE SUPPRIMER MEMBRE DANS TABLE MEMBRE EN CAS DE SUPPRESSION D'UN OBJET USERS-ROLES
	@ManyToOne(targetEntity=Membre.class, cascade=CascadeType.REMOVE)
	@JoinColumn(name="mail", referencedColumnName = "mail")
	private  Membre mail;
	
	@Column(name="AUTHORITY")
	private String authority;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Users_roles() {
		super();
	}

	public Membre getMail() {
		return mail;
	}

	public void setMail(Membre mail) {
		this.mail = mail;
	}

	/*public Users_roles(Membre mail, String authority) {
		super();
		this.mail.getMail() = mail;
		this.authority = authority;
	}*/

	
	
	
	
	

}
