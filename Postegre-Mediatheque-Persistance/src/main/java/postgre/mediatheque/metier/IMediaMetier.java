package postgre.mediatheque.metier;

import java.util.List;

import postgre.mediatheque.entite.Media;
import postgre.mediatheque.util.MediathequeException;

public interface IMediaMetier {
	public abstract void addMedia(Media m)throws MediathequeException;
	public abstract void updateMedia(Media a)throws MediathequeException;
	public abstract Media findMedia(String ref) throws MediathequeException;
	public abstract List findAllMedia() throws MediathequeException;
	public abstract Media deleteMedia(String m)throws MediathequeException;
	public abstract void deleteAllMedia()throws MediathequeException;
	public abstract boolean isexistMedia(String ref)throws MediathequeException;
}
