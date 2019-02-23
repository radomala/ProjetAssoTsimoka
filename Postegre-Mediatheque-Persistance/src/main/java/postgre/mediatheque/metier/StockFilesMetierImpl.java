package postgre.mediatheque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import postgre.mediatheque.entite.Media;
import postgre.mediatheque.entite.StockFiles;
import postgre.mediatheque.entiteDao.IStockFilesDao;
import postgre.mediatheque.util.MediathequeException;

public class StockFilesMetierImpl implements IStockFilesMetier {

	@Autowired
	IStockFilesDao iStockFilesDao;

	public void setiStockFilesDao(IStockFilesDao iStockFilesDao) {
		this.iStockFilesDao = iStockFilesDao;
	}

	public void save(StockFiles f) throws MediathequeException {
		iStockFilesDao.save(f);
	}

	public void delete(Media ref) throws MediathequeException {
		iStockFilesDao.delete(ref);

	}

	public List StockFilesAll() throws MediathequeException {

		return iStockFilesDao.StockFilesAll();
	}

	public StockFiles findStockFIlesById(long ref) throws MediathequeException {

		return iStockFilesDao.findStockFIlesById(ref);
	}

	public StockFiles findStockFIlesByReference(Media ref) throws MediathequeException {
		
		return iStockFilesDao.findStockFIlesByReference(ref);
	}

}
