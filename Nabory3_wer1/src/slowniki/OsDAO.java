package slowniki;

import hibernate.SessionFactoryHelper;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class OsDAO {
	
	Session session;
	
	@SuppressWarnings("unchecked")
	public List<Os> getOsie() {
		
	List<Os> lista_osi;
			
	session = SessionFactoryHelper.getSessionFactory().openSession();
	session.beginTransaction();
	Query query = session.createQuery("from Os");
	lista_osi = (List<Os>) query.list();
	
	session.getTransaction().commit();
	session.close();
	
	return lista_osi;		
	}

	public Os getOs(String nr_os) {
		Os o1= null;
		session = SessionFactoryHelper.getSessionFactory().openSession();
		session.beginTransaction();
		o1 = (Os) session.get(Os.class, nr_os);
		session.getTransaction().commit();
		session.close();
		return o1;
	}
	
	@SuppressWarnings("unchecked")
	public List<Dzialanie> getDzialania(String Nr_os) {
	
		List<Dzialanie> lista_dzialan;
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Dzialanie d where d.nr_os= :param");
		query.setString("param", Nr_os); 
		lista_dzialan = (List<Dzialanie>) query.list();
		
		session.getTransaction().commit();
		session.close();
		return lista_dzialan;
	}
	
	@SuppressWarnings("unchecked")
	public List<Poddzialanie> getPodDzialania(String klucz) {
		List<Poddzialanie> lista_poddzialan;
		Session session = SessionFactoryHelper.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Poddzialanie p where p.klucz= :param");
		query.setString("param", klucz); 
		lista_poddzialan = (List<Poddzialanie>) query.list();
		
		session.getTransaction().commit();
		session.close();
		return lista_poddzialan;
	}
	
}
