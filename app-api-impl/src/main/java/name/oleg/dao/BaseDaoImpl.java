package name.oleg.dao;

import name.oleg.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public abstract class BaseDaoImpl<T extends Entity> implements BaseDao<T> {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private Class<T> type;

    protected BaseDaoImpl(Class<T> type) {
        this.type = type;
    }

    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }

    @Override
    public List<T> loadAll() {
        return null;
    }

    @Override
    public T load(long id) {
        return null;
    }

    @Override
    public void update(T entity) {
    }

    @Override
    public void save(T entity) {
    }

    @Override
    public void delete(T entity) {
    }
}
