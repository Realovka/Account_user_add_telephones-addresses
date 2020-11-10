package by.realovka.dao;


import by.realovka.entity.Telephone;
import by.realovka.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class TelephoneDaoImpl implements TelephoneDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Telephone getTelephone(long id){
       return entityManager.getReference(Telephone.class,id);
    }

    @Override
    public void deleteTelephone(Telephone telephone){
        entityManager.remove(telephone);
    }

}
