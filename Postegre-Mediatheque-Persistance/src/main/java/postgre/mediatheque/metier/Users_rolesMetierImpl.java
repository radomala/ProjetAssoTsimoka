package postgre.mediatheque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.entite.Users_roles;
import postgre.mediatheque.entiteDao.IUsers_rolesDao;
import postgre.mediatheque.util.MediathequeException;

public class Users_rolesMetierImpl implements IUsers_rolesMetier {
	@Autowired
	IUsers_rolesDao iUsers_rolesDao;

	public void setiUsers_rolesDao(IUsers_rolesDao iUsers_rolesDao) {
		this.iUsers_rolesDao = iUsers_rolesDao;
	}

	public void save(Membre m, String authority) throws MediathequeException {
		Users_roles u=new Users_roles();
		u.setMail(m);
		u.setAuthority(authority);
		
		iUsers_rolesDao.save(u);

	}

	public List users_rolesAll() throws MediathequeException {
		
		return iUsers_rolesDao.users_rolesAll();
	}

}
