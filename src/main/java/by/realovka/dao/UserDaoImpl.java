package by.realovka.dao;

import by.realovka.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user){
       entityManager.persist(user);
    }

    @Override
    public boolean findByLogin(String login){
        return entityManager.createNamedQuery("User.findByLogin", User.class).setParameter("login", login).getResultList().size()>0;
    }

    @Override
    public boolean findByLoginAndPassword(String login, String password){
        return  entityManager.createNamedQuery("User.findByLoginAndPassword", User.class)
                .setParameter("login", login).setParameter("password", password).getResultList().size()>0;
    }

    @Override
    public User findUserByLogin(String login){
        return entityManager.createNamedQuery("User.findUserByLogin", User.class).setParameter("login", login).getSingleResult();
    }


    @Override
    public void updateUser(User user){
        entityManager.merge(user);
    }


}
