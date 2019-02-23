package postgre.mediatheque.entiteDao;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.util.MediathequeException;

public interface IRubriqueDao {
	
	public abstract void createRubrique(RubriqueBean rub)throws MediathequeException;
	
	public void deleteRubrique(long idRubrique) throws MediathequeException;
	
	public void deleteRubriqueByName(String label) throws MediathequeException;

}
