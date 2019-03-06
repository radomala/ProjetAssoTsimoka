package postgre.mediatheque.entiteDao;

import java.util.List;
import java.util.Map;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.util.MediathequeException;

/**
 * @author rjbandriambololotomp
 *
 */
public interface IRubriqueDao {
	
	public abstract Map<String, Object> createRubrique(RubriqueBean rub)throws MediathequeException;
	
	public void deleteRubriqueEntity(long idRubrique) throws MediathequeException;
	
	public void deleteRubriqueTable(String label) throws MediathequeException;
	
	public void updateRubriqueTable(long idRubrique , String Name) throws MediathequeException;
	
	public void updateRubriqueEntity(long idRubrique , String Name) throws MediathequeException;
	
	public List getListRubriqueTable() throws MediathequeException;
	
	public List getListRubriqueEntity() throws MediathequeException;
	
	public Object getRubriqueBeanTable(long idRubrique)throws MediathequeException;
	
	public RubriqueBean getRubriqueBeanEntity(long idRubrique)throws MediathequeException;


}
