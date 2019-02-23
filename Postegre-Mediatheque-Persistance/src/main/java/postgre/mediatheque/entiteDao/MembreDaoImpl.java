package postgre.mediatheque.entiteDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SocketHandler;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.util.MediathequeException;

public class MembreDaoImpl implements IMembreDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// @Transactional(propagation = Propagation.REQUIRED, rollbackFor =MediathequeException.class)
	public void add(Membre membre) throws MediathequeException, Exception {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			// sessionFactory.getCurrentSession().persist(membre);
			session.save(membre);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur d'ajout du membre" + membre);
		}
	}

	// @Transactional(propagation = Propagation.REQUIRED, rollbackFor =MediathequeException.class)
	public void edit(Membre membre) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (membre != null) {
			
			try {
				// sessionFactory.getCurrentSession().update(membre);
				session.update(membre);
				tx.commit();
				session.close();
			} catch (HibernateException e) {
				tx.rollback();
				session.close();
				throw new MediathequeException("erreur de mise a jour du membre" + membre);
			}
		}
	}

	// LA SUPPRESSION DE MEMBRE EST GRERER PAR USER_ROLES EN CASCADE CAR MEMBRE EST UNE CLE SECONDAIRE DE USERS_ROLES
	//LA METHODE DELTE DE USERS_ROLES EST APPELLE DANS MEMBRE METIER
	public void delete(String mail) throws MediathequeException {

		
		
		/*Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Membre membre = new Membre();

		try {
			// sessionFactory.getCurrentSession().delete(getMembre(mail));
			//on recupere la reference entré par l'utulisateur, on cherche l objet de cette reference 
			membre = (Membre) session.get(Membre.class, mail);
			//on surpprime cet objet
			session.delete(membre);
			tx.commit();
			session.close();
			System.out.println("le membre" + " " + membre.getNom() + "est supprimé");

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur de suppression");
		}*/
	}

	public void deleteAllMembre() throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "delete from postgre.mediatheque.entite.Membre";

		try {

			session.createQuery(sql).executeUpdate();
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur de suppression All");
		}

	}

	// @Transactional(propagation = Propagation.MANDATORY, rollbackFor =MediathequeException.class)
	public Membre getMembreByMail(String mail) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Membre membre = new Membre();

		try {
			// sessionFactory.getCurrentSession().get(Membre.class, mail);
			membre = (Membre) session.get(Membre.class, mail);  //avec cette methode, on utulise toujours la clé primaire
			tx.commit();
			session.close();

		} catch (HibernateException e) {

			tx.rollback();
			session.close();
			throw new MediathequeException("erreur de retour getMmembreByMmail");
		}
		return membre;
	}

	public Membre getMembreByName(String nom) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from postgre.mediatheque.entite.Membre as c where c.nom = ?";
		Membre membre = new Membre();

		try {

			Query query = session.createQuery(hql);
			query.setParameter(0, nom);
			membre = (Membre) query.uniqueResult();

			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur de retour getMmembreByname");
		}
		return membre;
	}

	// @Transactional(propagation = Propagation.MANDATORY, rollbackFor =MediathequeException.class)
	@SuppressWarnings("unchecked")
	public List getMembreAll() throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Membre> allMembre = new ArrayList<Membre>();

		try {

			// allMembre =sessionFactory.getCurrentSession().createQuery(hql).list();
			allMembre = session.createQuery("from postgre.mediatheque.entite.Membre").list();
			return allMembre;

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur getAllMembree");
		}

	}

	public boolean existMembre(Membre membre) throws MediathequeException {
		boolean a = false;
		a = getMembreByMail(membre.getMail()) != null;
		return a;
	}

}
