package testJunit.Rubrique;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.metier.IRubriqueMetier;
import postgre.mediatheque.util.MediathequeException;

public class TestRubriqueMetier {

	ListableBeanFactory bfa = new XmlBeanFactory(new ClassPathResource("persistance-context.xml"));
	IRubriqueMetier iRubriqueMetier = (IRubriqueMetier) bfa.getBean("iRubriqueMetier");
	
	
	@Test
	public void testCreateRubrique() throws MediathequeException, ParseException {

		RubriqueBean rub = new RubriqueBean();
		rub.setRub_label("metier");
		rub.setRub_id(100);

		String s = "12/12/2017";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYyy");
		Date d = sdf.parse(s);
		rub.setRub_datecreate(d);
		rub.setRub_usercreate("dd");
		rub.setRub_dossierOrformulaire(true);
		rub.setRub_description("ff");
		rub.setRub_finishconfiguration("ddd");

		iRubriqueMetier.createRubrique(rub);
	}
	
	
}
