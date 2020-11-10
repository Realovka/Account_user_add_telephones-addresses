package by.realovka.service;

import by.realovka.dao.UserDaoImpl;
import by.realovka.dto.*;
import by.realovka.entity.Address;
import by.realovka.entity.Telephone;
import by.realovka.entity.User;
import by.realovka.service.exception.NoSuchUserException;
import by.realovka.service.exception.SuchUserIsPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDaoImpl userDaoImpl;

    public void save(UserRegDTO userRegDTO) {
        User user = new User(userRegDTO.getNameUserRegDTO(), userRegDTO.getLoginUserRegDTO(), userRegDTO.getPasswordUserRegDTO());
        userDaoImpl.save(user);
    }

    public boolean findByLoginAndPassword(UserAuthDTO userAuthDTO) {
        if (!userDaoImpl.findByLoginAndPassword(userAuthDTO.getLoginUserAuthDTO(), userAuthDTO.getLoginUserAuthDTO())) {
            throw new NoSuchUserException();
        } else return true;
    }

    public boolean findByLogin(UserRegDTO userRegDTO) {
        if (userDaoImpl.findByLogin(userRegDTO.getLoginUserRegDTO())) {
            throw new SuchUserIsPresentException();
        } else return false;
    }

    public User findAuthUserByLogin(UserAuthDTO userAuthDTO) {
        return userDaoImpl.findUserByLogin(userAuthDTO.getLoginUserAuthDTO());
    }


    public User getAuthUser(User user) {
        return userDaoImpl.findUserByLogin(user.getLogin());
    }

    public void updateUserAddTelephone(User userAuth, TelephoneDTO telephoneDTO) {
        Telephone telephone = new Telephone(telephoneDTO.getNumber(), telephoneDTO.getCategory());
        User user = userDaoImpl.findUserByLogin(userAuth.getLogin());
        user.getTelephones().add(telephone);
        userDaoImpl.updateUser(user);
    }

    public void updateUserAddAddress(User userAuth, AddressDTO addressDTO) {
        Address address = new Address(addressDTO.getCity(), addressDTO.getStreet(), addressDTO.getHouse(), addressDTO.getFlat(), addressDTO.getCategory());
        User user = userDaoImpl.findUserByLogin(userAuth.getLogin());
        user.getAddresses().add(address);
        userDaoImpl.updateUser(user);
    }

    public void updateTelephone(long idTelephone, TelephoneUpdateDTO telephoneUpdateDTO, HttpSession httpSession) {
        User authUser =  userDaoImpl.findUserByLogin(((User)httpSession.getAttribute("userAuth")).getLogin());
        List<Telephone> telephones = authUser.getTelephones();
        for(Telephone item : telephones){
            if(item.getId()==idTelephone){
                item.setNumber(telephoneUpdateDTO.getNumber());
            }
        }
        authUser.setTelephones(telephones);
        userDaoImpl.updateUser(authUser);

    }

    public void updateCity(long idAddress, CityUpdateDTO cityUpdateDTO, HttpSession httpSession) {
        User authUser =  userDaoImpl.findUserByLogin(((User)httpSession.getAttribute("userAuth")).getLogin());
        List<Address> addresses = authUser.getAddresses();
        for(Address item : addresses){
            if(item.getId()==idAddress){
                item.setCity(cityUpdateDTO.getCity());
            }
        }
        authUser.setAddresses(addresses);
        userDaoImpl.updateUser(authUser);

    }

    public void updateHouse(long idAddress, HouseUpdateDTO houseUpdateDTO, HttpSession httpSession) {
        User authUser =  userDaoImpl.findUserByLogin(((User)httpSession.getAttribute("userAuth")).getLogin());
        List<Address> addresses = authUser.getAddresses();
        for(Address item : addresses){
            if(item.getId()==idAddress){
                item.setHouse(houseUpdateDTO.getHouse());
            }
        }
        authUser.setAddresses(addresses);
        userDaoImpl.updateUser(authUser);

    }

    public void updateStreet(long idStreet, StreetUpdateDTO streetUpdateDTO, HttpSession httpSession) {
        User authUser =  userDaoImpl.findUserByLogin(((User)httpSession.getAttribute("userAuth")).getLogin());
        List<Address> addresses = authUser.getAddresses();
        for(Address item : addresses){
            if(item.getId()==idStreet){
                item.setStreet(streetUpdateDTO.getStreet());
            }
        }
        authUser.setAddresses(addresses);
        userDaoImpl.updateUser(authUser);

    }

    public void updateFlat(long idAddress, FlatUpdateDTO flatUpdateDTO, HttpSession httpSession) {
        User authUser =  userDaoImpl.findUserByLogin(((User)httpSession.getAttribute("userAuth")).getLogin());
        List<Address> addresses = authUser.getAddresses();
        for(Address item : addresses){
            if(item.getId()==idAddress){
                item.setFlat(flatUpdateDTO.getFlat());
            }
        }
        authUser.setAddresses(addresses);
        userDaoImpl.updateUser(authUser);

    }
}
