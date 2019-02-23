package postgre.mediatheque.entiteDao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.util.MediathequeException;



public interface IMembreDao {
	
//	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=MediathequeException.class)
	public abstract void add(Membre membre)throws MediathequeException, Exception ;
	
//	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=MediathequeException.class)
	public abstract void edit (Membre membre) throws MediathequeException;
	
//	@Transactional(propagation=Propagation.MANDATORY,rollbackFor=MediathequeException.class)
	public abstract void delete(String mail) throws MediathequeException;
	
//	@Transactional(propagation=Propagation.MANDATORY,rollbackFor=MediathequeException.class)
	public abstract Membre getMembreByMail( String mail) throws MediathequeException;

//	@Transactional(propagation=Propagation.MANDATORY,rollbackFor=MediathequeException.class)
	public List getMembreAll()throws MediathequeException;
	
	public abstract Membre getMembreByName(String phone) throws MediathequeException;
	
	public abstract void deleteAllMembre()throws MediathequeException;

	
	public abstract boolean existMembre(Membre membre)throws MediathequeException;


}
