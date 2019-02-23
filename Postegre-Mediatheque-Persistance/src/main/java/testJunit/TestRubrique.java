package testJunit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import postgre.mediatheque.entite.RubriqueBean;
import postgre.mediatheque.entiteDao.IRubriqueDao;
import postgre.mediatheque.util.MediathequeException;

public class TestRubrique {

	
	ListableBeanFactory bfa = new XmlBeanFactory(new ClassPathResource("persistance-context.xml"));
	IRubriqueDao iRubriqueDao = (IRubriqueDao) bfa.getBean("iRubriqueDao");
	
	@Test
	public void testCreate() throws MediathequeException, ParseException {

		RubriqueBean rub = new RubriqueBean();
		rub.setRub_label("dd");
		rub.setRub_id(100);

		String s = "12/12/2017";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYyy");
		Date d = sdf.parse(s);
		rub.setRub_datecreate(d);
		rub.setRub_usercreate("dd");
		rub.setRub_dossierOrformulaire(true);
		rub.setRub_description("ff");
		rub.setRub_finishconfiguration("ddd");

		iRubriqueDao.createRubrique(rub);
	}

	@Test
	public void testeDelete() throws MediathequeException, ParseException {

		iRubriqueDao.deleteRubrique(3);
	}
	
	@Test
	public void testeDeletebynom() throws MediathequeException, ParseException {

		iRubriqueDao.deleteRubriqueByName("dd");
	}
}
