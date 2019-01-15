package lab3.jpa;

import lab3.Result;
import lab3.UserInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.RollbackException;
import java.util.Collections;
import java.util.List;

public class UserInfoDao {

    public UserInfo findById (int id) throws HibernateException {
        Session session = HibUtil.getInstance().getSessionFactory().openSession();
        UserInfo result = session.get(UserInfo.class, id);
        session.close();
        return result;
    }

    public List<UserInfo> findAll() throws HibernateException {
        Session session = HibUtil.getInstance().getSessionFactory().openSession();
        List<UserInfo> result = (List<UserInfo>) session.createQuery("FROM users").list();
        session.close();
        if (result != null) {
            return result;
        } else {
            return Collections.emptyList();
        }
    }

    public int save (UserInfo res) throws HibernateException, RollbackException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibUtil.getInstance().getSessionFactory().openSession();
            transaction = session.beginTransaction();
            int id = (int) session.save(res);
            transaction.commit();
            return id;
        } catch (RollbackException exc) {
            transaction.rollback();
            throw exc;
        } finally {
            session.close();
        }
    }

    public void update (UserInfo res) throws HibernateException, RollbackException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibUtil.getInstance().getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(res);
            transaction.commit();
        } catch (RollbackException exc) {
            transaction.rollback();
            throw exc;
        } finally {
            session.close();
        }
    }

    public void delete (UserInfo res) throws HibernateException, RollbackException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibUtil.getInstance().getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(res);
            transaction.commit();
        } catch (RollbackException exc) {
            transaction.rollback();
            throw exc;
        } finally {
            session.close();
        }
    }
}
