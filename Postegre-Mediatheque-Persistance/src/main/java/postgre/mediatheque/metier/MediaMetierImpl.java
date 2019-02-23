package postgre.mediatheque.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import postgre.mediatheque.entite.Media;
import postgre.mediatheque.entiteDao.IMediaDao;
import postgre.mediatheque.entiteDao.IStockFilesDao;
import postgre.mediatheque.util.MediathequeException;

public class MediaMetierImpl implements IMediaMetier {

	Logger logger = Logger.getLogger("logger");
	
	@Autowired
	IMediaDao iMediaDao;
	
	@Autowired
	IStockFilesDao iStockFilesDao;

	public void setiMediaDao(IMediaDao iMediaDao) {
		this.iMediaDao = iMediaDao;
	}

	public void setiStockFilesDao(IStockFilesDao iStockFilesDao) {
		this.iStockFilesDao = iStockFilesDao;
	}

	public void addMedia(Media m) throws MediathequeException {

		if (m != null) {
			if (iMediaDao.isexistMedia(m.getReference())) {
				System.out.println("A media with REF " + m.getReference() + " already exist");

			} else {
				try {

					iMediaDao.addMedia(m);
				} catch (Exception e) {
					throw new MediathequeException("eureur da'insertion " + e.toString());
				}
			}

		
		}
	}

	public void updateMedia(Media a) throws MediathequeException {
		try {
			iMediaDao.updateMedia(a);
		} catch (Exception e) {
			throw new MediathequeException("eureur de mise a jour " + e.toString());
		}

	}

	public Media findMedia(String ref) throws MediathequeException {
		Media media = new Media();
		try {
			media = iMediaDao.findMedia(ref);
		} catch (Exception e) {
			throw new MediathequeException("eureur da'insertion " + e.toString());
		}
		return media;
	}

	public List findAllMedia() throws MediathequeException {

		List<Media> allMedia = new ArrayList<Media>();

		try {
			allMedia = iMediaDao.findAllMedia();
		} catch (Exception e) {
			throw new MediathequeException("erreur de findallmedia" + e.toString());
		}
		return allMedia;
	}

	//la suppression d'un objet media et gerer par le stockfiles car media est une clésecondaire da la table Stockfiles
	//si on veut supprimer un objet de stockfiles, media est supprimé automatiquement en cascade
	/*
	 donc: on appelle sctofiles.delete ici , soit on utulise stofiles.delete dans controlleur si on veut supprimer
	 */
	public Media deleteMedia(String m) throws MediathequeException {
		Media media = new Media();
		try {
			
			//on cherche le media par sa reference 
			media=iMediaDao.findMedia(m);
			//on supprime ce media on utulisant la methode stkocfiles (LE CASCATE SE TROUVE DANS L ENTITES)
			iStockFilesDao.delete(media);
			
			logger.info("ETAT: MEDIA " + media.getReference() + " EST SUPPRIME DANS TABLE MEDIA ET DANS STTOCK" );
			
		} catch (Exception e) {
			
			logger.info("ETAT: MEDIA  N EST PAS SUPPRIME" );
			logger.info(e.toString());
			throw new MediathequeException("erreur de suppression de media, le media n'exixte pas" + e.toString());
		}
		return null;
	}

	public boolean isexistMedia(String ref) throws MediathequeException {
		boolean a = false;
		try {
			a = iMediaDao.isexistMedia(ref);
		} catch (Exception e) {

		}
		return a;
	}

	public void deleteAllMedia() throws MediathequeException {
		// TODO Auto-generated method stub

	}

}
