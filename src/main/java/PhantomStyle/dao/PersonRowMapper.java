package PhantomStyle.dao;

import PhantomStyle.domain.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonRowMapper implements RowMapper<Person> {

    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Person((long)resultSet.findColumn("ID"), String.valueOf(resultSet.findColumn("NAME")), (double) (resultSet.findColumn("RATE")));
        //тут доделать
    }
}
