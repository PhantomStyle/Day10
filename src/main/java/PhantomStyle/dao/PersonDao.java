package PhantomStyle.dao;

import PhantomStyle.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Person findById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM Person WHERE id = ?", new PersonRowMapper());
    }

    public List<Person> findAll(){
        return jdbcTemplate.query("SELECT * FROM Person", new PersonRowMapper());
    }

    public void deleteById(Long id){
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }

    public void insert(Person person){
        jdbcTemplate.update("INSERT INTO Person(ID, NAME, RATE VALUES (?, ?, ?)", person.getId(), person.getName(), person.getRate());
    }

    public void update(Person person){
        jdbcTemplate.update("UPDATE Person SET name = ?, rate = ?, WHERE id = ?", person.getName(), person.getRate(), person.getId());
    }

    private final Map<Long, Person> persons;

    public PersonDao() {
        persons = new HashMap<Long, Person>();
        persons.put(1L, new Person(1L, "Vasya", 10.0));
        persons.put(2L, new Person(2L, "Sasha", 15.0));
        persons.put(3L, new Person(3L, "Lena", 20.0));
    }

    public Person getById(long id) {
        return persons.get(id);
    }

    public String getAll() {
        StringBuilder ret = new StringBuilder("");
        for (Map.Entry<Long, Person> p : persons.entrySet()) {
            ret.append(p.getValue().toString() + "\n");
        }
        return ret.toString();
    }
}
