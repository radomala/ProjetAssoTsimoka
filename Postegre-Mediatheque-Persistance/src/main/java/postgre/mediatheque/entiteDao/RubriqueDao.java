package postgre.mediatheque.entiteDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.util.MediathequeException;

/**
 * @author rjbandriambololotomp.
 *
 */
public class RubriqueDao implements IRubriqueDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	
	
	private static final String SUCCESS  = "success";

	public Map <String, Object> createRubrique(RubriqueBean rub) throws MediathequeException {
		
		Map <String, Object> message = new HashMap<String, Object>();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(rub);
			tx.commit();
			session.close();
			
			message.put(SUCCESS, true);

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			message.put(SUCCESS, true);
			throw new MediathequeException("erreur d'ajout DOSSIER:FORMULAIRE" + rub.getRub_label());
		}
		
		return message;

	}

	public void deleteRubriqueEntity(long idRubrique) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		RubriqueBean rub = new RubriqueBean();

		try {

			rub = (RubriqueBean) session.get(RubriqueBean.class, idRubrique);
			session.delete(rub);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur de suppression");
		}
	}

	public void deleteRubriqueTable(String label) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		RubriqueBean rub = new RubriqueBean();
		String sql = "DELETE FROM t_rubrique_rub WHERE rub_label = :name";

		try {

			SQLQuery query = session.createSQLQuery(sql);
			// IMPORTANT
			query.addEntity(RubriqueBean.class);

			query.setParameter("name", label);
			query.executeUpdate();

			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
			throw new MediathequeException("erreur de suppression");
		}

	}

	/*
	 * mise a jour avec en utulisant la table.
	 */
	public void updateRubriqueTable(long idRubrique, String newLabel) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sqlUpdate = "UPDATE t_rubrique_rub SET rub_label = :newLabel WHERE rub_id = :idRubrique";

		try {
			SQLQuery query = session.createSQLQuery(sqlUpdate);
			query.addEntity(RubriqueBean.class);
			query.setParameter("idRubrique", idRubrique);
			query.setParameter("newLabel", newLabel);
			// query.executeUpdate();
			int result = query.executeUpdate();
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
		}

	}

	/*
	 * mise a jour en utulisant l' entité ou le beans Le plus gros avantage de la.
	 * mise en veille prolongée (HIBERNATE) est qu'elle fournit l'ORM (mapping
	 * relationnel d'objet).
	 */
	public void updateRubriqueEntity(long idRubrique, String newLabel) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			RubriqueBean rubriqueBean = (RubriqueBean) session.get(RubriqueBean.class, idRubrique);
			rubriqueBean.setRub_label(newLabel);
			session.update(rubriqueBean);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			tx.rollback();
			session.close();
		}

	}
	

	/*
	 * LISTE RUBRIQUE DANS MODULE ADMINISTRATION-RUBRIQUE.
	 * 
	 */
	
	
	@SuppressWarnings("unchecked")
	public List getListRubriqueTable() throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<RubriqueBean> rubriqueBeans = new ArrayList<RubriqueBean>();
		// String sql = "SELECT first_name, salary FROM EMPLOYEE";
		String sql = "SELECT * FROM t_rubrique_rub";

		try {
			SQLQuery query = session.createSQLQuery(sql);
			// IMPORTANT
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			rubriqueBeans = query.list();

			return rubriqueBeans;

		} catch (HibernateException e) {
			session.close();
			throw new MediathequeException("eureur getListRubriqueTable");
		}

	}
	
	
	
	/* 
	 
	  SELECT
      id_rub AS id,
      label_rub AS label,
      LOWER(label_rub) as lowerLabel,
      id_parent_rub AS idparent,
      isformulaire AS isFormulaire
    FROM
      t_rubrique_rub
    where
      (id_parent_rub is null and (:idParent is null OR :idParent ::numeric = -1))
      or
      (id_parent_rub is not null and id_parent_rub = :idParent ::numeric)
    ORDER BY
      isFormulaire ASC,
      lowerLabel ASC
	  
	 */
	
	

	/* 
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List getListRubriqueEntity() throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<RubriqueBean> rubriqueBeans = new ArrayList<RubriqueBean>();
		String sql = "SELECT * FROM t_rubrique_rub";

		try {

			SQLQuery query = session.createSQLQuery(sql);
			// IMPORTANT
			query.addEntity(RubriqueBean.class);
			rubriqueBeans = query.list();
			return rubriqueBeans;

		} catch (HibernateException e) {
			session.close();
			throw new MediathequeException("eureur getListRubriqueTable");
		}

	}

	public Object getRubriqueBeanTable(long idRubrique) throws MediathequeException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		RubriqueBean rubriqueBean = new RubriqueBean();
		String sql = "SELECT * FROM t_rubrique_rub where rub_id = :idRubrique";

		try {

			Query query = session.createSQLQuery(sql);
			query.setParameter("idRubrique", idRubrique);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			return query.uniqueResult();

		} catch (HibernateException e) {
			session.close();
			throw new MediathequeException("erreur");
		}

	}

	public RubriqueBean getRubriqueBeanEntity(long idRubrique) throws MediathequeException {

		RubriqueBean rubriqueBean = new RubriqueBean();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		rubriqueBean = (RubriqueBean) session.get(RubriqueBean.class, idRubrique);

		if (rubriqueBean.equals(null)) {
			System.out.println("null");
		}

		return rubriqueBean;
	}

}
