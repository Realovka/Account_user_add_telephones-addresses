package by.realovka.service;

import by.realovka.dao.AddressDaoImpl;
import by.realovka.dto.CityUpdateDTO;
import by.realovka.dto.FlatUpdateDTO;
import by.realovka.dto.HouseUpdateDTO;
import by.realovka.dto.StreetUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressDaoImpl addressDao;

    public void deleteAddress(long id){
        addressDao.deleteAddress(addressDao.getAddress(id));
    }
}
