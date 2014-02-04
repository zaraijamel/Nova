package name.oleg.dao;

import name.oleg.entity.resume.Vacancy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class VacancyDaoImpl extends BaseDaoImpl<Vacancy> implements VacancyDao {

    public VacancyDaoImpl() {
        super(Vacancy.class);
    }

    @Override
    public void test() {
        getJdbcTemplate().query("SELECT * FROM suppliers", new ResultSetExtractor<Object>() {
            @Override
            public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                while (resultSet.next()) {
                    System.err.println(resultSet.getInt(1));
                }
                return null;
            }
        });
    }
}
