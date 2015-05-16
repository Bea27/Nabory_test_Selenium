package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class SessionFactoryHelper {
	private static final SessionFactory sf;
	private static ServiceRegistry serviceRegistry;
	
    static {
        try {     	          
 //           Configuration configuration = new Configuration();
 //   		configuration.configure("hibernate.cfg.xml");
 //   		serviceRegistry = new ServiceRegistryBuilder().applySettings(
 //   				configuration.getProperties()).getBootstrapServiceRegistry();
 //   		sf = configuration.buildSessionFactory(serviceRegistry);
    		
    		Configuration configuration = new Configuration();
    		configuration.configure("hibernate.cfg.xml");
    		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sf = configuration.buildSessionFactory(ssrb.build());
            
        } catch (Throwable e) {
            System.err.println("Error in creating SessionFactory object."
                    + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sf;
    }
}
