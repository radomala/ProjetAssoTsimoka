package postgre.mediatheque.entiteDao;

import java.io.IOException;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	private static final String SUCCESS = "success";

	public Map<String, Object> createRubrique(RubriqueBean rub) throws MediathequeException {

		Map<String, Object> message = new HashMap<String, Object>();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(rub);
			tx.commit();
			session.close();

			message.put(SUCCESS, true);

		} catch (Exception e) {
			tx.rollback();
			session.close();
			message.put(SUCCESS, false);
			throw new MediathequeException(" ERROR ADD DOSSIER : " + rub.getLabel());
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
			rubriqueBean.setLabel(newLabel);
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

	public RubriqueBean getRubriqueBeanEntity(String idRubrique) throws MediathequeException {

	//	long id = Long.parseLong(idRubrique);
		RubriqueBean rubriqueBean = new RubriqueBean();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		rubriqueBean = (RubriqueBean) session.get(RubriqueBean.class, idRubrique);

		if (rubriqueBean.equals(null)) {
			System.out.println("null");
		}
 
		return rubriqueBean;
	}


    public List<RubriqueBean> getRubriquesByParentId(String idForm) {
    	
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	String idParent = idForm.equals("root") ? "-1" : idForm;
    	
		List<RubriqueBean> rubriqueBeans = new ArrayList<RubriqueBean>();
		
		String sql = "SELECT rub_id AS id, rub_label AS label, LOWER(rub_label) as lowerLabel, rub_idparent AS idparent,rub_dossierOrformulaire AS dossierOrformulaire FROM t_rubrique_rub where (rub_idparent is null and (:idParent is null OR :idParent = -1)) or (id_parent_rub is not null and id_parent_rub = :idParent)";

		try {

			SQLQuery query = session.createSQLQuery(sql);
			// IMPORTANT
			query.addEntity(RubriqueBean.class);
			rubriqueBeans = query.list();
			return rubriqueBeans;

		} catch (HibernateException e) {
			session.close();
		}
		return rubriqueBeans;
    }

	public List<RubriqueBean> getRubriqueParentAndFils(String idForm, String listRubriques) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRubriqueBeanTable(String idRubrique) throws MediathequeException {
		// TODO Auto-generated method stub
		return null;
	}

	public List getListRubriqueTableNoIdParent() throws MediathequeException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<RubriqueBean> rubriqueBeans = new ArrayList<RubriqueBean>();
		// String sql = "SELECT first_name, salary FROM EMPLOYEE";
		String sql = "SELECT * FROM t_rubrique_rub where rub_idparent is null";

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
	
	public List getListRubriqueTableAvecIdParent() throws MediathequeException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<RubriqueBean> rubriqueBeans = new ArrayList<RubriqueBean>();
	
		String sql = "SELECT * FROM t_rubrique_rub where rub_idparent is not null";

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

	public List getListRubriqueDissierOrFormulaire(boolean quoi) throws MediathequeException {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<RubriqueBean> rubriqueBeans = new ArrayList<RubriqueBean>();
		String sql = "";
		
		if(!quoi) {
			sql = "SELECT * FROM t_rubrique_rub where rub_dossierorformulaire = false";
		} else {
			sql = "SELECT * FROM t_rubrique_rub where rub_dossierorformulaire = true";
		}
	

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

	public RubriqueBean getRubriqueBeanEntityByNom(String nom) throws MediathequeException, IOException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		RubriqueBean rubriqueBean = new RubriqueBean();
		
		 ObjectMapper objectMapper = new ObjectMapper();
		String sql = "SELECT * FROM t_rubrique_rub where rub_label = :label";

		try {

			SQLQuery query = session.createSQLQuery(sql);
			query.setParameter("label", nom);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			//return query.uniqueResult();
			
			 System.out.println(query.uniqueResult());
			 
				
			 // JSON à l'objet Java
	      
			 rubriqueBean = objectMapper.readValue(""+query.uniqueResult(), RubriqueBean.class);
			 System.out.println( rubriqueBean.toString());
			 
			return null;

		} catch (HibernateException e) {
			session.close();
			throw new MediathequeException("erreur");
		}

	
		
	
	}
}

/* 
 
 private long rub_id;
	@Column(name="rub_label")
	private String  rub_label;
	@Column(name="rub_idparent")
	private long rub_idparent;
	@Column(name="rub_datecreate")
	private Date rub_datecreate;
	@Column(name="rub_usercreate")
	private String  rub_usercreate;
	@Column(name="rub_dossierOrformulaire")
	private boolean  rub_dossierOrformulaire;
	@Column(name="rub_description")
	private String rub_description;
	@Column(name="rub_finishconfiguration")
	private String rub_finishconfiguration;
	
	
 
 
 
 
 
 
 

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

