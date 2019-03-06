package postgre.mediatheque.metier;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.entiteDao.IRubriqueDao;
import postgre.mediatheque.util.MediathequeException;

public class RubriqueMetierImpl implements IRubriqueMetier {

	@Autowired
	private IRubriqueDao iRubriqueDao;

	public void setiRubriqueDao(IRubriqueDao iRubriqueDao) {
		this.iRubriqueDao = iRubriqueDao;
	}
	
	
	

	public Map <String, Object> createRubrique(RubriqueBean rub) throws MediathequeException {
		
		return iRubriqueDao.createRubrique(rub);

	}

	public void deleteRubriqueEntity(long idRubrique) throws MediathequeException {
		// TODO Auto-generated method stub

	}

	public void deleteRubriqueTable(String label) throws MediathequeException {
		// TODO Auto-generated method stub

	}

	public void updateRubriqueTable(long idRubrique, String Name) throws MediathequeException {
		// TODO Auto-generated method stub

	}

	public void updateRubriqueEntity(long idRubrique, String Name) throws MediathequeException {
		// TODO Auto-generated method stub

	}

	public List getListRubriqueTable() throws MediathequeException {
		// TODO Auto-generated method stub
		return null;
	}

	public List getListRubriqueEntity() throws MediathequeException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRubriqueBeanTable(long idRubrique) throws MediathequeException {
		// TODO Auto-generated method stub
		return null;
	}

	public RubriqueBean getRubriqueBeanEntity(long idRubrique) throws MediathequeException {
		// TODO Auto-generated method stub
		return null;
	}

}
