package by.realovka.dao;

import by.realovka.entity.Telephone;

public interface TelephoneDao {
    Telephone getTelephone(long id);
    void deleteTelephone(Telephone telephone);
}
