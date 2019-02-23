import org.junit.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.entiteDao.MembreDao;
import postgre.mediatheque.metier.MembreMetier;

public class TestMembre {

	@Test
	public void test() {
		//ListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	    //IPersonneMetier m = (IPersonneMetier) bf.getBean("personneMetier");
		

		
			
			ListableBeanFactory bfa = new XmlBeanFactory(new ClassPathResource("persistance-context.xml"));
			MembreDao membredao= (MembreDao) bfa.getBean("membreDao");
			
			ListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("metier-context.xml"));
			MembreMetier membremetier=(MembreMetier) bf.getBean("membreMetier");
			
			 
			 
			
			Membre membre= new Membre("alteca@yahoo.fr","alteca","alteca","alteca","alteca","alteca");
			String mail = "onyrady@yahoo.fr";
			//String mdp = "alteca";
			//String nom= "alteca";
			//String prenom="alteca";
			//String phone ="alteca";
			//String sexe= "alteca";
			
			membremetier.getMembre(mail);
			//System.exit(0);
	}

}
