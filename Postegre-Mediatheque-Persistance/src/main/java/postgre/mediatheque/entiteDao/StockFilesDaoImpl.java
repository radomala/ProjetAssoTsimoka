package postgre.mediatheque.entiteDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import postgre.mediatheque.entite.Media;
import postgre.mediatheque.entite.StockFiles;
import postgre.mediatheque.util.MediathequeException;

public class StockFilesDaoImpl implements IStockFilesDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void save(StockFiles f) throws MediathequeException {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			//sessionFactory.getCurrentSession().persist(f);
			session.save(f);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur d'ajout du nom de chemin du media dans BD stock");
		}

	}


	public void delete(Media ref) throws MediathequeException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		StockFiles s= new StockFiles();
		
		try {
			//s= (StockFiles)session.get(StockFiles.class, ref);
			
			//ON RECUPERE D ABORD CET OBJET A L AIDE DE LA REFERENCE DU MEDIA
			Query query =(Query) session.createQuery("from postgre.mediatheque.entite.StockFiles as c where c.reference = ?");
			query.setParameter(0, ref);
	
		    s = (StockFiles)query.uniqueResult();
			
		    //ON LE SUPPRIME S'IL EXISTE
			session.delete(s);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new  MediathequeException("erreur lors de la suppresion du media");
		}
		
		
	}

	@SuppressWarnings("unchecked")
	public List StockFilesAll() throws MediathequeException {
		Session session= sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List <StockFiles> all= new ArrayList<StockFiles>();
		
		try {
			all= session.createCriteria("from postgre.mediatheque.entite.StockFiles").list();
			
		} catch (HibernateException e) {
			throw new MediathequeException("la liste  de stcckfiles n'existe pas");
		}
		
		return all;
	}


	public StockFiles findStockFIlesById(long id) throws MediathequeException{
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		StockFiles m = new StockFiles();
		Media n= new Media();
		try {
	
			// m= (StockFiles) session.get(StockFiles.class, id);
			
			Query query =(Query) session.createQuery("from postgre.mediatheque.entite.StockFiles as c where c.id = ?");
			query.setParameter(0, id);
			m = (StockFiles)query.uniqueResult();
			
			
			 tx.commit();
				session.close();
			
		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("la referene  n'existe pas dans bd stock");
		}
		
		return m;
	}


	public StockFiles findStockFIlesByReference(Media i) throws MediathequeException {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		StockFiles m = new StockFiles();
		
		try {
		
			Query query =(Query) session.createQuery("from postgre.mediatheque.entite.StockFiles as c where c.reference = ?");
			query.setParameter(0, i);
			m = (StockFiles)query.uniqueResult();
			 
			session.close();
			
		} catch (Exception e) {
			tx.rollback();
			session.close();
			System.out.println(e.toString());
			throw new MediathequeException("la referene  n'existe pas dans bd stock");
		}
		
		return m;
	}
	
	

	


	
	
	


	
	
	

}
