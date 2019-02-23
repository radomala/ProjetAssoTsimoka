package postgre.mediatheque.metier;

import java.util.List;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.entiteDao.MembreDao;

public class MembreMetierImpl implements MembreMetier {

	MembreDao membreDao;
	
	
	public void setMembreDao(MembreDao membreDao) {
		this.membreDao = membreDao;
	}

	public void add(Membre membre) {
		membreDao.add(membre);

	}

	public void edit(Membre membre) {
		membreDao.edit(membre);
	}

	public void delete(String mail) {
		membreDao.delete(mail);
	}

	public Membre getMembre(String mail) {
		return membreDao.getMembre(mail);
	}

	public List getMembreAll() {
		return membreDao.getMembreAll();
	}

}
