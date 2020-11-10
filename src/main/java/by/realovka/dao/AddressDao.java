package by.realovka.dao;

import by.realovka.entity.Address;

public interface AddressDao {
    Address getAddress(long id);

    void deleteAddress(Address address);
}
