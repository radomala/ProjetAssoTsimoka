package postgre.mediatheque.entiteDao;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.util.MediathequeException;

public class RubriqueImpl implements IRubriqueDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void createRubrique(RubriqueBean rub) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(rub);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur d'ajout DOSSIER:FORMULAIRE" + rub.getRub_label());
		}

	}

	public void deleteRubrique(long idRubrique) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		RubriqueBean rub = new RubriqueBean();

		try {
			// sessionFactory.getCurrentSession().delete(getMembre(mail));
			// on recupere la reference entré par l'utulisateur, on cherche l objet de cette
			// reference
			rub = (RubriqueBean) session.get(RubriqueBean.class, idRubrique);
			// on surpprime cet objet
			session.delete(rub);
			tx.commit();
			session.close();
			System.out.println("le membre" + " " + rub.getRub_label() + "est supprimé");

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur de suppression");
		}

	}

	public void deleteRubriqueByName(String label) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		RubriqueBean rub = new RubriqueBean();

		try {
			
			String sql = "DELETE FROM t_rubrique_rub WHERE rub_label = :name";
			
			
			
			SQLQuery query = session.createSQLQuery(sql);
            //query.setLong(0, 16l);
			query.addEntity(RubriqueBean.class);
			query.setParameter("name", label);
           query.executeUpdate();

			
			tx.commit();
			session.close();
		//	System.out.println("le membre" + " " + rub.getRub_label() + "est supprimé");

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur de suppression");
		}

	}

}
