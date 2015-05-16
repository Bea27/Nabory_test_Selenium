package nabor;

import hibernate.SessionFactoryHelper;

import org.hibernate.Session;

public class NaborDAO {
	Session session;
	
	public NaborDAO() {
		session = SessionFactoryHelper.getSessionFactory().openSession();
	}

	public Nabor getNabor(int idNaboru) {
		Nabor nab = null;

		nab = (Nabor) session.get(Nabor.class, idNaboru);

		return nab;
	}

	public void saveNabor(Nabor nab) {
		
		session.beginTransaction();
		session.save(nab);
		session.getTransaction().commit();
		session.close();
	}
}
