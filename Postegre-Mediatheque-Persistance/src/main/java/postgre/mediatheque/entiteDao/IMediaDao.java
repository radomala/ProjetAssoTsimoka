package postgre.mediatheque.entiteDao;

import java.util.List;

import postgre.mediatheque.entite.Media;
import postgre.mediatheque.util.MediathequeException;

public interface IMediaDao {
	
	public abstract void addMedia(Media m)throws MediathequeException;
	public abstract void updateMedia(Media a)throws MediathequeException;
	public abstract Media findMedia(String ref) throws MediathequeException;
	public abstract List findAllMedia() throws MediathequeException;
	//MEDIA EST UNE CLE ETRANGERE DE LA TABLE STOCKFILES, DON POUR LE SUPPRIMER, IL FAUT UTULISER LA METHODE DE LA TABLE STOCKFILES(entite est metnionne avec CASCADE)
	public abstract Media deleteMedia(String m)throws MediathequeException;
	public abstract void deleteAllMedia()throws MediathequeException;
	public abstract boolean isexistMedia(String string)throws MediathequeException;

}
