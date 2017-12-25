package kz.nursike.dao;

import kz.nursike.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ЕрежеповН on 22.12.2017.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery(
                "from User where username = :username");
        query.setParameter("username", username);

        User user = query.uniqueResult();
        return user;
    }

    @Override
    public void save(User user) {

    }
}
