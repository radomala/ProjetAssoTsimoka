package postgre.mediatheque.metier;

import java.util.List;

import postgre.mediatheque.entite.Membre;

public interface MembreMetier {

	
	public abstract void add(Membre membre) ;
	
	
	public abstract void edit (Membre membre);
	
	
	public abstract void delete(String mail) ;
	
	
	public abstract Membre getMembre( String mail) ;

	
	public List getMembreAll();
	
}
