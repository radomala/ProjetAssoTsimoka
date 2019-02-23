package postgre.mediatheque.metier;

import java.util.List;

import postgre.mediatheque.entite.Media;
import postgre.mediatheque.entite.StockFiles;
import postgre.mediatheque.util.MediathequeException;

public interface IStockFilesMetier {

	public abstract void save(StockFiles f)throws MediathequeException;
	public abstract void delete(Media ref) throws MediathequeException;
	public abstract List StockFilesAll ()throws MediathequeException;
	public abstract StockFiles findStockFIlesById(long id)throws MediathequeException;
	public abstract StockFiles findStockFIlesByReference(Media ref)throws MediathequeException;
	
}
