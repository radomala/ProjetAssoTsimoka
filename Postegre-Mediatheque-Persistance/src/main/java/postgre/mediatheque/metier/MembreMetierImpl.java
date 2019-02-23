package postgre.mediatheque.metier;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SocketHandler;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.entiteDao.IMembreDao;
import postgre.mediatheque.entiteDao.IUsers_rolesDao;
import postgre.mediatheque.util.MediathequeException;

public class MembreMetierImpl implements IMembreMetier {

	Logger logger = Logger.getLogger("logger");
	
	@Autowired
	private IMembreDao iMembreDao;
	@Autowired
	private IUsers_rolesDao iUsers_rolesDao;

	public void setiMembreDao(IMembreDao iMembreDao) {
		this.iMembreDao = iMembreDao;
	}
	
	

	public void setiUsers_rolesDao(IUsers_rolesDao iUsers_rolesDao) {
		this.iUsers_rolesDao = iUsers_rolesDao;
	}



	public void add(Membre membre) throws MediathequeException, Exception {

		try {
			iMembreDao.add(membre);	
			logger.log(Level.INFO, "LE MEMBRE EST CREE");
			
		} catch (HibernateException e) {
			logger.log(Level.INFO, e.toString());
			throw new MediathequeException("erreur");
		}
	}

	public void edit(Membre membre) throws MediathequeException {
		try {
			iMembreDao.edit(membre);
		} catch (HibernateException e) {
			throw new MediathequeException("erreur");
		}
	}

	//LA DELETE DE MEBRE EST GERE PAR USER_ROLES EN CASCADE CAR MEMBRE EST UNE CLE SECONDAIRE DE USERS_ROLES 
	public void delete(Membre mail) throws MediathequeException {
		try {
			//iMembreDao.delete(mail);
			iUsers_rolesDao.delete(mail);
		} catch (HibernateException e) {
			throw new MediathequeException("erreur");
		}
	}

	public Membre getMembreByMail(String mail) throws MediathequeException {

		return iMembreDao.getMembreByMail(mail);

	}

	public List getMembreAll() throws MediathequeException {

		return iMembreDao.getMembreAll();
	}

	public Membre getMembreByName(String nom) throws MediathequeException {

		return iMembreDao.getMembreByName(nom);
	}

	public void deleteAllMembre() throws MediathequeException {
		iMembreDao.deleteAllMembre();
	}

	public boolean existMembre(Membre membre) throws MediathequeException {
		return iMembreDao.existMembre(membre);
	}
}
