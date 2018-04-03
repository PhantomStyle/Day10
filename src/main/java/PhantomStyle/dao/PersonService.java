package PhantomStyle.dao;

import PhantomStyle.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
    @Autowired
    PersonDao personDao;

    public String getAll(){
        return personDao.getAll();
    }
}
