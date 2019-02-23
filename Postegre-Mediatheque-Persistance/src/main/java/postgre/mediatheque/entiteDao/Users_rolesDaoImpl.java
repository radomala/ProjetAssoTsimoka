package postgre.mediatheque.entiteDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.entite.Users_roles;
import postgre.mediatheque.util.MediathequeException;

public class Users_rolesDaoImpl implements IUsers_rolesDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Users_roles u) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			// sessionFactory.getCurrentSession().persist(membre);
			session.save(u);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("Users_roles erreur d'ajout du " + u);
		}
	}

	@SuppressWarnings("unchecked")
	public List users_rolesAll() throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Users_roles> listUsers_roles = new ArrayList<Users_roles>();

		try {
			listUsers_roles = session.createQuery("from postgre.mediatheque.entite.Users_roles").list();
			return listUsers_roles;
		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur getAllMembree");
		}

	}

	public void delete(Membre mail) throws MediathequeException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Users_roles s= new Users_roles();
		
		
		try {
			//s= (StockFiles)session.get(StockFiles.class, ref);
			
			//ON RECUPERE D ABORD CET OBJET A L AIDE DE LA REFERENCE DU MEDIA
			Query query =(Query) session.createQuery("from postgre.mediatheque.entite.Users_roles as c where c.mail = ?");
			query.setParameter(0, mail);
	
		    s = (Users_roles)query.uniqueResult();
			
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

}
