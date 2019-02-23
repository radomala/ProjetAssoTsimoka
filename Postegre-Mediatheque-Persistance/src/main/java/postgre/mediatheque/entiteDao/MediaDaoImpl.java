package postgre.mediatheque.entiteDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import postgre.mediatheque.entite.Media;
import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.util.MediathequeException;

public class MediaDaoImpl implements IMediaDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addMedia(Media m) throws MediathequeException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Media media = new Media();
		try {
			session.save(m);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur d'ajout du media" + media.getReference());
		}

	}

	public Media findMedia(String ref) throws MediathequeException {

		Media media = new Media();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// on peut faire aussi une requete SQL
		Media m = (Media) session.get(Media.class, ref);

		if (m != null) {
			System.out.println(media.getReference() + " " + media.getTitre() + " " + media.getType());
			media = m;
		} else {
			System.out.println(media.getReference() + " " + media.getTitre() + " " + media.getType());
			media = m;
		}

		// tx.commit();
		// session.close();

		return media;

	}

	@SuppressWarnings("unchecked")
	public List findAllMedia() throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Media> allMembre = new ArrayList<Media>();

		try {

			// allMembre =
			// sessionFactory.getCurrentSession().createQuery(hql).list();
			allMembre = session.createQuery("from postgre.mediatheque.entite.Media").list();
			return allMembre;

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("eureur findallmedia");
		}

	}

	public boolean isexistMedia(String ref) throws MediathequeException {
		boolean a = false;

		if (ref == null) {
			System.out.println("la REF ne peut pas etre null");
			a = false;
		}

		else if (ref != null) {
			Media m = new Media();
			m = findMedia(ref);
			if (m != null) {
				a = true;
				System.out.println("l'existance de REF " + ref + " est " + a);
			} else if (m == null) {

				a = false;
				System.out.println("l'existance de REF " + ref + " est " + a);
			}

		}

		return a;
	}

	public void updateMedia(Media a) throws MediathequeException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (a != null) {
			try {

				// sessionFactory.getCurrentSession().update(membre);
				session.update(a);
				tx.commit();
				session.close();
			} catch (HibernateException e) {
				tx.rollback();
				session.close();
				throw new MediathequeException("erreur de mise a jour du membre" + a);
			}
		}
	}

	
	public Media deleteMedia(String m) throws MediathequeException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Media media = new Media();

		try {
			// sessionFactory.getCurrentSession().delete(getMembre(mail));
			media = (Media) session.get(Media.class, m);
			session.delete(media);
			
			tx.commit();
			session.close();
			System.out.println("le membre" + " " + media.getReference() + "est supprimé");

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur de suppression");
		}
		return media;
	}

	public void deleteAllMedia() throws MediathequeException {
		// TODO Auto-generated method stub

	}

}
