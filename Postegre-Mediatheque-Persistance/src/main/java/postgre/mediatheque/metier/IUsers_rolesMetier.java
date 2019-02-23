package postgre.mediatheque.metier;

import java.util.List;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.entite.Users_roles;
import postgre.mediatheque.util.MediathequeException;

public interface IUsers_rolesMetier {

	public abstract void save(Membre m, String authority)throws MediathequeException;
	public abstract List users_rolesAll()throws MediathequeException;
}
