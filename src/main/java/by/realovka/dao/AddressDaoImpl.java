package by.realovka.dao;

import by.realovka.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class AddressDaoImpl implements AddressDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address getAddress(long id) {
        return entityManager.getReference(Address.class, id);
    }

    @Override
    public void deleteAddress(Address address) {
        entityManager.remove(address);
    }


}
