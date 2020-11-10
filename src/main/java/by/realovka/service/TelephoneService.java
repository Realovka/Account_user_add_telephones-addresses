package by.realovka.service;

import by.realovka.dao.TelephoneDaoImpl;
import by.realovka.dao.UserDaoImpl;
import by.realovka.dto.TelephoneUpdateDTO;
import by.realovka.entity.Telephone;
import by.realovka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TelephoneService {
    @Autowired
    private TelephoneDaoImpl telephoneDao;

    public void deleteTelephone(long id) {
        telephoneDao.deleteTelephone(telephoneDao.getTelephone(id));
    }

}
