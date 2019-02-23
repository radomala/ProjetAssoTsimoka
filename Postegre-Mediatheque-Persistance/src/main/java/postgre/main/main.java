package postgre.main;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import postgre.mediatheque.entite.Media;
import postgre.mediatheque.entiteDao.IMediaDao;
import postgre.mediatheque.entiteDao.IMembreDao;
import postgre.mediatheque.entiteDao.IStockFilesDao;
import postgre.mediatheque.entiteDao.IUsers_rolesDao;
import postgre.mediatheque.metier.IMediaMetier;
import postgre.mediatheque.metier.IMembreMetier;
import postgre.mediatheque.metier.IUsers_rolesMetier;
import postgre.mediatheque.util.MediathequeException;



public class main {



	public static void main(String[] args) throws Exception {
		ListableBeanFactory bfa = new XmlBeanFactory(new ClassPathResource("persistance-context.xml"));
		
		IMembreDao membredao= (IMembreDao) bfa.getBean("iMembreDao");
		IMediaDao beansMediaDao= (IMediaDao) bfa.getBean("iMediaDao");
		IUsers_rolesDao iUsers_rolesDao= (IUsers_rolesDao) bfa.getBean("iUsers_rolesDao");
		IStockFilesDao iStockFilesDao= (IStockFilesDao) bfa.getBean("iStockFilesDao");
		
		ListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("persistance-context.xml"));
		IMembreMetier membremetier=(IMembreMetier) bf.getBean("iMembreMetier");
		IMediaMetier mediamedia =(IMediaMetier) bf.getBean("iMediaMetier");
		IUsers_rolesMetier iUsers_rolesMetier= (IUsers_rolesMetier) bfa.getBean("iUsers_rolesMetier");
		
		 
		try{
		//*****************************ADD VIA DAO*********************************** 
		Media m= new Media("FF","FF","FF");
		
		
			System.out.println(iStockFilesDao.findStockFIlesByReference(m));
			
		//******************************GET UN MEMBRE VIA DAO********************************** 	
		/*Media N= new Media();
		N=beansMediaDao.findMedia("media");
		System.out.println(m.getReference() + N.getTitre()+ N.getType());*/
			
		//******************************GET ALL MAMBRE VIA DAO********************************** 
		/*List <Membre> allMembre = new ArrayList<Membre>();
		allMembre=membredao.getMembreAll();
		for(Membre m2 : allMembre){
			System.out.println(m2.getMail() +" "+ m2.getAdresse()+ " " + m2.getNom());
		}*/
		
		
		//******************************GET ALL MAMBRE VIA DAO********************************** 	
	/*	beansMediaDao.deleteMedia("O");
		beansMediaDao.deleteMedia("D");
		beansMediaDao.deleteMedia("DDIDI");
		List <Media> allMembre = new ArrayList<Media>();
		allMembre=beansMediaDao.findAllMedia();
		for(Media b : allMembre){
			System.out.println(b.getReference() +" "+ b.getTitre()+ " " + b.getType());
		
		}
		*/
		
		/*Membre membre= new Membre("a.radomala@gmail.fr","1234","rado","alteca","alteca","alteca");
		membredao.add(membre);
		Users_roles users_roles= new Users_roles();
		users_roles.setMail(membre);
		users_roles.setAuthority("ROLE_admin");
		iUsers_rolesDao.save(users_roles);*/
		
		
		
			//******************************GET UN MEMBRE VIA METIER********************************** 	
			/*Membre m= new Membre();
			m=membremetier.getMembreByMail("cxf");
			System.out.println(m.getAdresse() + m.getMail()+ m.getMotdepasse()+ m.getPhone());*/
			
			
			//******************************GET UN MEMBRE VIA METIer ********************************** 	
			/*Membre m2= new Membre();
			m2=membredao.getMembreByName("Rado");
			System.out.println(m2.getAdresse() + m2.getMail()+ m2.getMotdepasse()+ m2.getPhone());
			
			
			*/
			//Media media= new Media();
			mediamedia.isexistMedia("media");
		
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new MediathequeException("erreur oh");
		}
		
		
	}

}
