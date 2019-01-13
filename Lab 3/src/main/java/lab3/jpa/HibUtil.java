package lab3.jpa;
import lab3.Group;
import lab3.Result;
import lab3.UserInfo;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil{
    private SessionFactory sessionFactory = null;

    private static final HibUtil instance = new HibUtil();
    public static HibUtil getInstance() {
        return instance;
    }

    SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Result.class);
                configuration.addAnnotatedClass(UserInfo.class);
                configuration.addAnnotatedClass(Group.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
