package postgre.mediatheque.entiteDao;

import java.util.List;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.entite.Users_roles;
import postgre.mediatheque.util.MediathequeException;

public interface IUsers_rolesDao {
	

	public abstract void save(Users_roles u)throws MediathequeException;
	public abstract List users_rolesAll()throws MediathequeException;
	public abstract void delete(Membre m)throws MediathequeException;

}
