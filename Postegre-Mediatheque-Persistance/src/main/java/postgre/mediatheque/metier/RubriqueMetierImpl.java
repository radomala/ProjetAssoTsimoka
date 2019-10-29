package postgre.mediatheque.metier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.entiteDao.IRubriqueDao;
import postgre.mediatheque.util.MediathequeException;

/**
 * @author douda
 *
 */
public class RubriqueMetierImpl implements IRubriqueMetier {

	@Autowired
	private IRubriqueDao iRubriqueDao;

	public void setiRubriqueDao(IRubriqueDao iRubriqueDao) {
		this.iRubriqueDao = iRubriqueDao;
	}
	
	/**
	 * pointeur error 
	 */
		Map<String, Object> message = new HashMap<String, Object>();
	private static final String SUCCESS = "success";
	private static final String ERROR = "erreur";
	 /** erreur. */
    private String errorRecuperer = "";

	
	public Map<String, Object> createRubrique(RubriqueBean rub) throws MediathequeException, IOException {
		
		
		verificationNameDouble(rub.getLabel());
		verificationName(rub.getLabel());
		
		 if ("".equals(errorRecuperer)) {
			 message = iRubriqueDao.createRubrique(rub);	  
		 } else {
			 
			 message.put(SUCCESS, false);
             message.put(ERROR, errorRecuperer);
             errorRecuperer = "";
		 }

		return message;

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
	
	public Object getRubriqueBeanTable(long idRubrique) throws MediathequeException {
		// TODO Auto-generated method stub
		return null;
	}

	public RubriqueBean getRubriqueBeanEntity(long idRubrique) throws MediathequeException {
		// TODO Auto-generated method stub
		return null;
	}

	public List getListRubriqueTable() throws MediathequeException {
		return iRubriqueDao.getListRubriqueTable();

	}

	public List getListRubriqueEntity() throws MediathequeException {
		return iRubriqueDao.getListRubriqueEntity();
	}

	public List getListRubriqueDissierOrFormulaire(boolean quoi) throws MediathequeException {
		return iRubriqueDao.getListRubriqueDissierOrFormulaire(quoi);
	}
	
	/**
     * @param nameFormulaire nameFormulaire.
     */
    public void verificationName(String nameDossier) {

        if (nameDossier.length()==0) {
            errorRecuperer = errorRecuperer + "," + "Le champ nom dossier doit être renseigné.";
        }

    }
    
    /**
     * @param nameFormulaire nameFormulaire.
     * @throws MediathequeException 
     * @throws IOException 
     */
    public void verificationNameDouble(String nameDossier) throws MediathequeException, IOException {

     RubriqueBean oneRub= getRubriqueBeanEntityByNom(nameDossier);
    }

	public RubriqueBean getRubriqueBeanEntityByNom(String nom) throws MediathequeException, IOException {
				return iRubriqueDao.getRubriqueBeanEntityByNom(nom);
	}	
    
    

}
