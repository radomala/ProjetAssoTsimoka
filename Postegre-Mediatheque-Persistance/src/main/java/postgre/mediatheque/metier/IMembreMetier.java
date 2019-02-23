package postgre.mediatheque.metier;

import java.util.List;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.util.MediathequeException;

public interface IMembreMetier {

	public abstract void add(Membre membre) throws MediathequeException, Exception;

	public abstract void edit(Membre membre) throws MediathequeException;

	public abstract void delete(Membre mail) throws MediathequeException;

	public abstract Membre getMembreByMail(String mail) throws MediathequeException;

	public abstract List getMembreAll() throws MediathequeException;

	public abstract Membre getMembreByName(String nom) throws MediathequeException;

	public abstract void deleteAllMembre() throws MediathequeException;

	public abstract boolean existMembre(Membre membre) throws MediathequeException;
}
